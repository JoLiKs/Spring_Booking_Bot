package com.example.spring_booking_bot.helpers;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class TimeControl {
    private List<String> times = new ArrayList<>();

    public TimeControl() {
        this.times.add("10.00");
        this.times.add("11.00");
        this.times.add("12.00");

        this.times.add("13.00");
        this.times.add("14.00");
        this.times.add("15.00");

        this.times.add("16.00");
        this.times.add("17.00");
        this.times.add("18.00");

    }
}
