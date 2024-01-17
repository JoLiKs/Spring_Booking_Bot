package com.example.spring_booking_bot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@SpringBootApplication
public class SpringBookingBotApplication {

	public static void main(String[] args) throws TelegramApiException {
		SpringApplication.run(SpringBookingBotApplication.class, args);
		TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
		try{
			telegramBotsApi.registerBot(new Bot());
		} catch (TelegramApiException e){

		}
	}
	}


