package ru.gb.javacore.model;

import ru.gb.javacore.exception.IllegalArgumentException;
import ru.gb.javacore.exception.InsufficientFundsException;

/**
 * Класс счета
 */
public class Account {

    /**
     * имя пользователя счета
     */
    private String name;

    /**
     * уникальный номер счета
     */
    private int id;

    /**
     * баланс счета
     */
    private int balance;


    private Account() {
        name = "";
        id = 0;
        balance = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) throws IllegalArgumentException {
        this.balance = checkBalance(balance);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    /**
     * Конструктор счета
     * @param name имя клиента
     * @param id уникальный номер счета
     * @param balance баланс счета
     * @throws IllegalArgumentException Исключение если число на балансе или при переводе отрицательное
     */
    public Account(String name, int id, int balance) throws IllegalArgumentException {
        this.name = name;
        this.id = checkId(id);
        this.balance = checkBalance(balance);
    }

    /**
     * проверка уникального номера счета
     * @param id
     * @return
     */
    private int checkId(int id) {
        if (id<=0){
            return id*(-1)+1;
        }
        return id;
    }

    /**
     * проверка баланса
     * @param balance
     * @return
     * @throws IllegalArgumentException Исключение если число на балансе или при переводе отрицательное
     */
    private int checkBalance(int balance) throws IllegalArgumentException {
        if (balance < 0) {
            throw new IllegalArgumentException(balance);
        }
        return balance;
    }

    public void refill(int sum) throws IllegalArgumentException, InsufficientFundsException {
        if (sum < 0) {
            throw new IllegalArgumentException(sum);
        }
        balance = balance + sum;
        System.out.printf("Счет пополнен на %d руб. На счету находятся: %d руб \n",sum,balance);
    }


    public void debiting(int sum) throws IllegalArgumentException, InsufficientFundsException {
        if (sum < 0) {
            throw new IllegalArgumentException(sum);
        } else if (sum>balance) {
            throw new InsufficientFundsException();
        }
        balance = balance-sum;
        System.out.printf("С вашего счета сняли сумму - %d руб.На счету находятся: %d руб\n",sum,balance);
    }

    @Override
    public String toString() {
        return "Счет[" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", balance=" + balance +
                ']';
    }
}