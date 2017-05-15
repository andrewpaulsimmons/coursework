package com.company;

public class BankAccountException extends Exception {

    public BankAccountException(String error) {
        super("Invalid Bank Account info : " + error);
    }
}