package com.projetomvc.aplicativo.global.model;

public class ServiceMessageReturn {

    private boolean isError;
    private String  messageReturn;

    public ServiceMessageReturn(boolean isErrorCons, String messageReturnCons){
        this.setError(isErrorCons);
        this.setMessageReturn(messageReturnCons);
    }

    public String getMessageReturn() {
        return messageReturn;
    }

    public void setMessageReturn(String parMessageReturn) {
        messageReturn = parMessageReturn;
    }

    public boolean isError() {
        return isError;
    }

    public void setError(boolean isError) {
        this.isError = isError;
    }

}
