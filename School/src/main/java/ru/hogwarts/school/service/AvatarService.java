package ru.hogwarts.school.service;

import org.springframework.web.multipart.MultipartFile;
import ru.hogwarts.school.model.Avatar;

import java.io.IOException;

public interface AvatarService {

    Avatar uploadAvatar(Long studentId, MultipartFile avatar) throws IOException;

    Avatar findAvatar(Long avatarId);
}
