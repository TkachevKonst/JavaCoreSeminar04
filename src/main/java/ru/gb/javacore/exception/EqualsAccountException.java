package ru.gb.javacore.exception;

/**
 * Исключение если счета одинаковые
 */
public class EqualsAccountException extends Exception{


    public EqualsAccountException(String message){
        super(message);
    }

}
