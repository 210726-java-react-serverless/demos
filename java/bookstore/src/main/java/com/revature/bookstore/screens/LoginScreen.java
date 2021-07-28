package com.revature.bookstore.screens;

public class LoginScreen extends Screen{


    public LoginScreen(String name, String route) {
        super(name, route);
    }

    private String loginUsername;
    private String loginPassword;

    public String getLoginUsername() {
        return loginUsername;
    }

    public void setLoginUsername(String loginUsername) {
        this.loginUsername = loginUsername;
    }

    public String getLoginPassword() {
        return loginPassword;
    }

    public void setLoginPassword(String loginPassword) {
        this.loginPassword = loginPassword;
    }

    @Override
    public void render() throws Exception {

    }
}
