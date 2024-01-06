package com.example.spring_booking_bot;

import com.example.spring_booking_bot.commands.BookCommand;
import com.example.spring_booking_bot.commands.ChooseTime;
import com.example.spring_booking_bot.commands.LoginCommand;
import com.example.spring_booking_bot.commands.WorkerCommand;
import com.example.spring_booking_bot.commands.bookcommand.*;
import com.example.spring_booking_bot.repos.UserRepo;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class Bot extends TelegramLongPollingBot {

    @Override
    public String getBotUsername() {
        return "Bio_DocBooking_bot";
    }
    @Override
    public String getBotToken(){
        return "6352247546:AAFWyC_txjP4__i3qHJ5pqd0Bfiv9xb4ICc";
    }


    @Override
    public void onUpdateReceived(Update update) {
        KeyboardRow k = new KeyboardRow();
        k.add(new KeyboardButton("Log In"));

        k.add(new KeyboardButton("Записаться к врачу"));
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(update.getMessage().getChatId().toString());
        sendMessage.setText("Выберите действие");
        ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
        replyKeyboardMarkup.setKeyboard(Collections.singletonList(k));
        sendMessage.setReplyMarkup(replyKeyboardMarkup);

        List<WorkerCommand> list = new ArrayList<>();
        list.add(new LoginCommand());
        list.add(new BookCommand());
        list.add(new TerapevtBookCommand());
        list.add(new AllergologBookCommand());
        list.add(new GinekologBookCommand());
        list.add(new HirurgBookCommand());
        list.add(new LorBookCommand());
        list.add(new OkulistBookCommand());
        list.add(new ChooseTime());
        for (WorkerCommand w: list){
            if (w.start(update)!= null){
                sendMessage = w.start(update);
                break;
            }
        }

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }
}
