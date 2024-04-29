package ru.gb.javacore.exception;

/**
 * исключение при недостаточном колличестве денег для операции
 */

public class InsufficientFundsException extends Exception{



    public InsufficientFundsException(){
        super();
    }


    @Override
    public String getMessage() {
        return "Операция не возможна, не достаточно средств на счету";
    }


}
