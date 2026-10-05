package se.kth.kebiche.labb1dis.bo;

import se.kth.kebiche.labb1dis.db.UserDB;

public class UserHandler {

    public static boolean login(String username, String password) {
        return UserDB.checkLogin(username, password);
    }
}
