package ru.job4j.bank;

import ru.job4j.bank.Account;
import ru.job4j.bank.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс BankService осуществляет логику работы над пользователями в MAP и их аккаунтами
 *
 * @autor Юсупов Эдуард
 * @version 1.0
 */
public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Осуществляет добавление пользователя в MAP
     * @param user пользователь который будет добавлен в MAP
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Осущетвляет удаление пользователя из MAP по паспорту
     * @param passport номер паспорта по которому будет удалено пользователь
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Осуществляет добавление аккаунта для пользователя, если данного аккаунта у пользователя нет
     * @param passport номер паспорта, по которому осуществляется поиск пользователя
     * @param account аккаунт, который будет добавлен пользователю в случае его отсутствия
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
               accounts.add(account);
            }
        }
    }

    /**
     * Осуществляет поиск и возврат пользователя по паспорту
     * @param passport номер паспорта, по которому осуществляется поиск
     * @return найденный пользователь
     */
    public User findByPassport(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод осуществляет поиск и возврат аккаунта пользователя
     * @param passport номер паспорта, по которому осуществляется поиск пользователя
     * @param requisite номер реквизитов для нахождения аккаунта пользователя
     * @return аккаунта найденный у пользователя
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            for (Account account : users.get(user)) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * Метод производит трансфер денег с одного счета на другой
     * @param sourcePassport номер паспорта для определения пользователя, со счета которого будет производиться перечисление
     * @param sourceRequisite номер реквизитов для нахождения аккаунта источника перевода
     * @param destinationPassport номера паспорта для определения пользователя, кому будет производиться перечисление
     * @param destinationRequisite номер реквизитов для определения аккаунта, куда будет производиться перечисление
     * @param amount количество денег, которое будет снято с одного аккаунта и переведено на другой
     * @return возвращает булево значение в зависимости от успешности операции
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
        if (sourceAccount == null || destinationAccount == null) {
            return false;
        }
        double sourceBalance = sourceAccount.getBalance();
        if (sourceBalance >= amount) {
            destinationAccount.setBalance(sourceBalance + destinationAccount.getBalance());
            sourceAccount.setBalance(sourceBalance - amount);
            return true;
        }
        return false;
    }

    /**
     * Метод возвращает массив аккаунтов определенного пользователя
     * @param user пользователя массив аккаунтов которого будет возращен
     * @return возвращает массив аккаунтов переданного пользователя
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}