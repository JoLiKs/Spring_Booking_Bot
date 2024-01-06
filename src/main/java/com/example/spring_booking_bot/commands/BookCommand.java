package com.example.spring_booking_bot.commands;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookCommand implements WorkerCommand{

    @Override
    public SendMessage start(Update update) {
        if (!update.getMessage().getText().equals("Записаться к врачу")){
            return null;
        }
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        KeyboardRow k1 = new KeyboardRow();
        k1.add(new KeyboardButton("Терапевт"));
        k1.add(new KeyboardButton("Хирург"));
        KeyboardRow k2 = new KeyboardRow();
        k2.add(new KeyboardButton("Окулист"));
        k2.add(new KeyboardButton("Лор"));
        KeyboardRow k3 = new KeyboardRow();
        k3.add(new KeyboardButton("Гинеколог"));
        k3.add(new KeyboardButton("Аллерголог"));
        List<KeyboardRow> list = new ArrayList<>();
        list.add(k1);
        list.add(k2);
        list.add(k3);
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(list);
        sendMessage.setReplyMarkup(replyKeyboardMarkup);
        sendMessage.setText("Выберите подходящего врача");
        return sendMessage;
    }

    @Override
    public SendMessage sendDefaultMessage(Update update) {
        return null;
    }
}
