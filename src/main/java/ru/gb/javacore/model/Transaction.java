package ru.gb.javacore.model;


import ru.gb.javacore.exception.EqualsAccountException;
import ru.gb.javacore.exception.IllegalArgumentException;
import ru.gb.javacore.exception.InsufficientFundsException;
import ru.gb.javacore.exception.NotAccountException;

public class Transaction {
    /**
     *
     * @param creditAccounts список счетов на которые будут произведены начисления средств
     * @param debitAccounts список счетов с которых будут произведены списания средтв
     * @param creditAccount счет на который начислят средства
     * @param debitAccount счет с которого произведут списание средств
     * @param sum сумма списания и начисления
     * @throws InsufficientFundsException исключение при недостаточном колличестве денег для операции
     * @throws NotAccountException исключение если счет не обнаружен
     * @throws EqualsAccountException Исключение если счета одинаковые
     * @throws IllegalArgumentException Исключение если число на балансе или при переводе отрицательное
     */
    public static void transferMoney(CreditAccount[] creditAccounts, DebitAccount[] debitAccounts, CreditAccount creditAccount, DebitAccount debitAccount, int sum) throws
            InsufficientFundsException, NotAccountException, EqualsAccountException, IllegalArgumentException {
        if (!isInArray(creditAccounts, creditAccount) || !isInArray(debitAccounts, debitAccount)) {
            throw new NotAccountException("Данный счет не существует. Операция отменена.");
        } else if (equalsAccount(creditAccount,debitAccount)) {
            throw new EqualsAccountException("Это один и тот же счет. Операция отменена.");
        }
        debitAccount.debiting(sum);
        creditAccount.refill(sum);


        System.out.println("Операция прошла успешно");

    }

    /**
     * Поиск счета в списке счетов
     * @param arr список счетов
     * @param o счет
     * @return
     */
    private static boolean isInArray(Object[] arr, Object o) {
        for (Object value : arr) if (value.equals(o)) return true;
        return false;
    }

    private static boolean equalsAccount(CreditAccount account, DebitAccount account1){
        if (account.getId() == account1.getId()) return true;
        return false;
    }

}
