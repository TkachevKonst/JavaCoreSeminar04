package ru.gb.javacore.model;

import ru.gb.javacore.exception.IllegalArgumentException;

/**
 * Класс счета с которого списываются средства
 */
public class DebitAccount extends Account{


    public DebitAccount(String name, int id, int balance) throws IllegalArgumentException {
        super(name, id, balance);
    }
}
