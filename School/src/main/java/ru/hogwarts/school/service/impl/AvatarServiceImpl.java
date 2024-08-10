package ru.hogwarts.school.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.AvatarRepository;
import ru.hogwarts.school.repository.StudentRepository;
import ru.hogwarts.school.service.AvatarService;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE_NEW;

@Service
public class AvatarServiceImpl implements AvatarService {

    @Value("${path.to.avatars.folder}")
    private String avatarsDir;

    private final int BUFFER_SIZE = 1024;

    private final StudentRepository studentRepository;
    private final AvatarRepository avatarRepository;

    public AvatarServiceImpl(StudentRepository studentRepository, AvatarRepository avatarRepository) {
        this.studentRepository = studentRepository;
        this.avatarRepository = avatarRepository;
    }

    @Override
    public Avatar uploadAvatar(Long studentId, MultipartFile avatarFile) throws IOException {
        Student student = studentRepository.findById(studentId).orElseThrow(() ->
                new IllegalArgumentException("Student with id " + studentId + " is not found in database")
        );

        Path avatarPath = saveToLocalDirectory(student, avatarFile);
        Avatar avatar = saveToDb(student, avatarPath, avatarFile);

        return avatar;
    }

    @Override
    public Avatar findAvatar(Long avatarId) {
        return avatarRepository.findById(avatarId).orElseThrow(() ->
                new IllegalArgumentException("Avatar with id " + avatarId + " is not found in database")
        );
    }

    private Path saveToLocalDirectory(Student student, MultipartFile avatarFile) throws IOException {
        Path avatarPath = Path.of(avatarsDir, "student" + student.getId() + "." + getExtensions(avatarFile.getOriginalFilename()));
        Files.createDirectories(avatarPath.getParent());
        Files.deleteIfExists(avatarPath);

        try (
                InputStream is = avatarFile.getInputStream();
                OutputStream os = Files.newOutputStream(avatarPath, CREATE_NEW);

                BufferedInputStream bis = new BufferedInputStream(is, BUFFER_SIZE);
                BufferedOutputStream bos = new BufferedOutputStream(os, BUFFER_SIZE)
        ) {
            bis.transferTo(bos);
        }

        return avatarPath;
    }

    private Avatar saveToDb(Student student, Path avatarPath, MultipartFile avatarFile) throws IOException {
        Avatar avatar = getAvatarByStudent(student);
        avatar.setFilePath(avatarPath.toString());
        avatar.setFileSize(avatarFile.getSize());
        avatar.setMediaType(avatarFile.getContentType());
        avatar.setData(avatarFile.getBytes());

        return avatarRepository.save(avatar);
    }

    private Avatar getAvatarByStudent(Student student) {
        return avatarRepository.findByStudent(student).orElseGet(() -> {
            Avatar avatar = new Avatar();
            avatar.setStudent(student);
            return avatar;
        });
    }

    private String getExtensions(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
