package ru.netologi.domain;

public class NotRegisteredException extends RuntimeException {
    public NotRegisteredException(String s) {
        super(s);
    }
}
