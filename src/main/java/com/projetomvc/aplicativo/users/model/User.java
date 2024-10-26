package com.projetomvc.aplicativo.users.model;

public class User {
    private int cdUser;
    private String nmUser;   
    private String snActive;
    private String dsPassword;

    public int getCdUser() {
        return cdUser;
    }
    public void setCdUser(int cdUser) {
        this.cdUser = cdUser;
    }

    public String getNmUser() {
        return nmUser;
    }
    public void setNmUser(String nmUser) {
        this.nmUser = nmUser;
    }
    public String getDsPassword() {
        return dsPassword;
    }
    public void setDsPassword(String dsPassword) {
        this.dsPassword = dsPassword;
    }
    public String getSnActive() {
        return snActive;
    }
    public void setSnActive(String snActive) {
        this.snActive = snActive;
    }
}
