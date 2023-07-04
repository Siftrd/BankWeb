/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.model;

import java.util.Objects;

/**
 *
 * @author rioxv
 */
public class Account {
    private int userID;
    private String userName;
    private String passWord;
    private int isAdmin;

    public Account() {
    }

    public Account(int userID, String userName, String passWord, int isAdmin) {
        this.userID = userID;
        this.userName = userName;
        this.passWord = passWord;
        this.isAdmin = isAdmin;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.passWord);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.userID != other.userID) {
            return false;
        }
        if (this.isAdmin != other.isAdmin) {
            return false;
        }
        return Objects.equals(this.userName, other.userName);
    }

 

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }


    public int getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(int isAdmin) {
        this.isAdmin = isAdmin;
    }

    @Override
    public String toString() {
        return "Account{" + "userID=" + userID + ", userName=" + userName + ", passWord=" + passWord + ", isAdmin=" + isAdmin + '}';
    }
    
}
