package ru.gb.javacore.exception;

/**
 * Исключение если число на балансе или при переводе отрицательное
 */

public class IllegalArgumentException extends Exception{

    private int balance;

    public IllegalArgumentException(int balance){
        super();
        this.balance = balance;

    }


    @Override
    public String getMessage() {
        return String.format("Данная сумма %d руб не корректна (отрицательное значение)", balance);
    }
}
