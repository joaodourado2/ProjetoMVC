package com.projetomvc.aplicativo.session;

import jakarta.servlet.http.HttpSession;

public class SessionConfiguration {

    public static void setSession(HttpSession sessionUser, String idUser ){
        sessionUser.setAttribute("loggedUser",idUser);
    }

    public static boolean isConnected(HttpSession sessionUser) {

        String loggedUser = (String) sessionUser.getAttribute("loggedUser");

        return loggedUser != null;

    }

    public static void closeSession(HttpSession sessionUser){
        sessionUser.invalidate();
    }

}
