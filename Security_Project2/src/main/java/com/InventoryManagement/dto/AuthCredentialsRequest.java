package com.InventoryManagement.dto;

//NOT stored in database just used to hold data to pass along
public class AuthCredentialsRequest {

    private String username;
    private String password;

    public String getUsername() {
    	//System.out.println(username);
    	return username;
        
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}