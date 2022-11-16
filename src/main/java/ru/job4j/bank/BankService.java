package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис, с помощью которого можно регистрировать пользователя,
 * удалять пользователя из системы, добавлять пользователю банковские счета,
 * переводить деньги с одного банковского счета на другой счет.
 * @author Alexandr
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение информации о пользователях сервиса и их счетах осуществляется в интерфейсе типа map.
     * По своей сути - это банк информации о пользователях сервиса.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

     /**
     * Метод добавляет пользователя в систему.
     * Если информация о таком пользоваетеле уже есть в банке, то добавление не происходит.
     * @param user - информация о пользователе.
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод, который позволяет удалить пользователя из системы.
     * @param passport - паспортные данные пользователя.
     * @return - возвращает true если пользовтель удален,
     * либо false если пользовтеля с такими паспортными данными нет в банке информации.
     */
    public boolean deleteUser(String passport) {
        return users.remove(new User(passport, null)) != null;
    }

    /**
     * Метод добавляет новый счет к пользователю.
     * Если счет с такими данными уже есть у пользователя, то добавление не происходит.
     * @param passport - паспортные данные пользователя.
     * @param account - добавляемый счет.
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        List<Account> accounts = getAccounts(user);
        if (user != null && !accounts.contains(account)) {
            accounts.add(account);
        }
    }

    /**
     * Метод позволяет выполнить поиск пользователя банке информации по номеру паспорта.
     * @param passport - паспортные данные пользователя.
     * @return - возвращает данные о пользователе если такой есть в банке информации,
     * возвращает null если пользователь с такими паспортными данными не найден.
     */
    public User findByPassport(String passport) {
        User rsl = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                rsl = user;
                break;
            }
        }
        return rsl;
    }

    /**
     * Метод позволяет выполнить поиск счета у пользователя по реквизитам.
     * @param passport - паспортные данные пользователя.
     * @param requisite - реквизиты счета пользователя.
     * @return - возвращает данные о счете пользователя если такой у него имеется,
     * возвращает null если такой счет у пользователя отсутствует.
     */
    public Account findByRequisite(String passport, String requisite) {
        Account rsl = null;
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : getAccounts(user)) {
                if (account.getRequisite().equals(requisite)) {
                    rsl = account;
                    break;
                }
            }
        }
        return rsl;
    }

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой.
     * @param srcPassport - паспортные данные пользователи, которые перечисляет деньги.
     * @param srcRequisite - реквизиты счета, с которого перечисляются деньги.
     * @param destPassport - паспортные данные пользователи, которму перечисляются деньги.
     * @param destRequisite - реквизиты счета, на который перечисляются деньги.
     * @param amount - перчисляемая сумма.
     * @return - возвращает true если операция перечисленя прошла успешно.
     * Если остутствует счет-источник и/или счет назанчение,
     * либо паспортные данные пользователя-отправителя и/или пользователя-получателя неверные,
     * либо на счете-источнике недостаточно средств, метод возвращает false.
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод позволяет получить список счетов пользователя
     * @param user - информация о пользователе.
     * @return - возвращает список счетов, которые есть у пользователя.
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
