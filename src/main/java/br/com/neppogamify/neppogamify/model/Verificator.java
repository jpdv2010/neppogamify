package br.com.neppogamify.neppogamify.model;

/**
 * Created by joaop on 23/08/2017.
 */
public class Verificator {
    public String getEmailVerify() {
        return emailVerify;
    }

    public void setEmailVerify(String emailVerify) {
        this.emailVerify = emailVerify;
    }

    private String emailVerify;

    public String getPasswordVerify() {
        return passwordVerify;
    }

    public void setPasswordVerify(String passwordVerify) {
        this.passwordVerify = passwordVerify;
    }

    private String passwordVerify;
}
