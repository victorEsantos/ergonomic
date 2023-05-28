package com.ergo.ergonomic.utils;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@UtilityClass
public class Crypto {

    public static String encrypt(String password) {
        return new BCryptPasswordEncoder().encode(password);
        //return BCrypt.hashpw(password, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String password, String hash) {
        return BCrypt.checkpw(password, hash);

    }
}
