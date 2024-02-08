package com.example.spring_booking_bot.helpers;

import com.example.spring_booking_bot.models.UserModel;
import com.example.spring_booking_bot.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserHelper {
    private static UserHelper helper = null;
    public UserHelper(){
        helper = this;
    }

    @Autowired
    UserRepo userRepo;
    public static void saveUser(UserModel t){
        helper.userRepo.save(t);
    }
    public static UserModel findUser(String tgId){

    UserModel userModel = helper.userRepo.findUserModelByTgId(tgId);
    if (userModel == null) {
        return new UserModel();
    }
    return userModel;
    }
}
