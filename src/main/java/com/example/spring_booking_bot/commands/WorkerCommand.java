package com.example.spring_booking_bot.commands;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface WorkerCommand {
    public SendMessage start(Update update);

    public SendMessage sendDefaultMessage(Update update);
}
