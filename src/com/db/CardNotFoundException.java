package com.db;

public class CardNotFoundException extends Exception{
    public CardNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
