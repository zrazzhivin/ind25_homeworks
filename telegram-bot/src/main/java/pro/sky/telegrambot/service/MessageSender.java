package pro.sky.telegrambot.service;

import org.springframework.stereotype.Component;

public interface MessageSender {

    void send(Long chatId, String messageText);

}
