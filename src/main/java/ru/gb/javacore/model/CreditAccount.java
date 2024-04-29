package ru.gb.javacore.model;

import ru.gb.javacore.exception.IllegalArgumentException;

/**
 * Класс счета на который приходят средства
 */
public class CreditAccount extends Account{

    public CreditAccount(String name, int id, int balance) throws IllegalArgumentException {
        super(name, id, balance);
    }
}
