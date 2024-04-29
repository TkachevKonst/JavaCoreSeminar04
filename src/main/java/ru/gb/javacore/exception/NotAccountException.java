package ru.gb.javacore.exception;

/**
 * исключение если счет не обнаружен
 */
public class NotAccountException extends Exception{

    public NotAccountException(String message){
        super(message);
    }


}
