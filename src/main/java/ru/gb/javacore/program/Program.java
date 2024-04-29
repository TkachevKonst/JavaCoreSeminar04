package ru.gb.javacore.program;

import ru.gb.javacore.exception.EqualsAccountException;
import ru.gb.javacore.exception.IllegalArgumentException;
import ru.gb.javacore.exception.InsufficientFundsException;
import ru.gb.javacore.exception.NotAccountException;
import ru.gb.javacore.model.Account;
import ru.gb.javacore.model.CreditAccount;
import ru.gb.javacore.model.DebitAccount;
import ru.gb.javacore.model.Transaction;

public class Program {
    public static void main(String[] args) {


        try {
            Account account1 = new Account("Konstantin", 12, 15800);
            System.out.println(account1);
            account1.refill(0);
            System.out.println(account1);

        }catch (IllegalArgumentException e){
            e.printStackTrace();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        }

        try {
            CreditAccount [] creditAccounts = {
                    new CreditAccount("Kos", 1, 303),
                    new CreditAccount("Nos", 155, 1580),
                    new CreditAccount("Pest", 189, 9548),
                    new CreditAccount("Koz", 185, 89547),
                    new CreditAccount("Batr", 78, 85)
            };

            DebitAccount[] debitAccounts = {
                    new DebitAccount("Kos", 1, 303),
                    new DebitAccount("Nos", 155, 1580),
                    new DebitAccount("Pest", 189, 9548),
                    new DebitAccount("Koz", 185, 89547),
                    new DebitAccount("Batr", 78, 85)
            };
            Transaction.transferMoney(creditAccounts, debitAccounts, creditAccounts[0], debitAccounts[4], 50);
            System.out.println(creditAccounts[0]);
            System.out.println(debitAccounts[0]);

           // Transaction.transferMoney(creditAccounts, debitAccounts, creditAccounts[0], new DebitAccount("опврла", 88777, 8522552), 50);


        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (EqualsAccountException e) {
            e.printStackTrace();
        } catch (InsufficientFundsException e) {
            e.printStackTrace();
        } catch (NotAccountException e) {
            e.printStackTrace();
        }


    }
}
