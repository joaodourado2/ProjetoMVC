package com.projetomvc.aplicativo.global.model;

public class ServiceMessageReturn {

    private boolean isError;
    private String  MessageReturn;

    public String getMessageReturn() {
        return MessageReturn;
    }

    public void setMessageReturn(String messageReturn) {
        MessageReturn = messageReturn;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

}
