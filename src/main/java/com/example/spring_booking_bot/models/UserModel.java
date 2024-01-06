package com.example.spring_booking_bot.models;

import com.example.spring_booking_bot.helpers.DoctorEnum;
import lombok.Data;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.persistence.*;
@Table(name = "telegram_user")
@Entity
@Data
public class UserModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;

    @Column(name = "username")
    String username;

    @Column(name = "telegram_id")
    String telegram_id;

    @Column(name = "person_name")
    String person_name;

    @Column(name = "wanted_doc")
    @Enumerated
    DoctorEnum doctorEnum;
}
