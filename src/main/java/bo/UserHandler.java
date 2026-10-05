package bo;

import db.UserDB;

public class UserHandler {

    public static boolean login(String username, String password) {
        return UserDB.checkLogin(username, password);
    }
}
