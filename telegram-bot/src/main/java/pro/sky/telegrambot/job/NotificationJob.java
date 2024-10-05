package pro.sky.telegrambot.job;

import com.pengrad.telegrambot.TelegramBot;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pro.sky.telegrambot.entity.NotificationTask;
import pro.sky.telegrambot.repository.NotificationTaskRepository;
import pro.sky.telegrambot.service.MessageSender;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Component
public class NotificationJob {

    private Logger logger = LoggerFactory.getLogger(NotificationJob.class);

    private final NotificationTaskRepository notificationTaskRepository;
    private final MessageSender messageSender;

    public NotificationJob(NotificationTaskRepository notificationTaskRepository, MessageSender messageSender) {
        this.notificationTaskRepository = notificationTaskRepository;
        this.messageSender = messageSender;
    }

    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void sendNotifications() {

        LocalDateTime currentDateTime = LocalDateTime.now().truncatedTo(ChronoUnit.MINUTES);
        logger.info("Job start for date time {}", currentDateTime);

        List<NotificationTask> notificationsTasks = notificationTaskRepository.findAllByNotificationDateTime(currentDateTime);
        logger.info("{} tasks have been found", notificationsTasks.size());

        for (NotificationTask notificationsTask : notificationsTasks) {
            messageSender.send(
                    notificationsTask.getChatId(),
                    "Напоминание! " + notificationsTask.getMessageText()
            );

            logger.info("Notification with id {} has been successfully sent", notificationsTask.getId());
        }

        logger.info("Job finished");
    }
}
