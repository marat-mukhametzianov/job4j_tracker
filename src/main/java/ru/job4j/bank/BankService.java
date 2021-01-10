package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This class has three methods: creating a hash map based on a User as a key, and List of an
 * Accounts, corresponding to this user.
 * @author Marat. M.
 * @version 1.0.
 */
public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * This method adds received instance of the User class into HashMap if there is no
     * matching element. As a value is used an empty ArrayLis of Account.
     * @param user is an instance of the User class to be added into HashMap
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * The method adds a new account in case if there is no the same account belongs this user.
     * Before adding it checks that the user with the received passport.
     * Existence of the user with received passport is checked using the findByPassport() method.
     * @param passport is a number to check the user existence.
     * @param account is an instance of the class Account, passed to the user to add.
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
     * The method checks the HashMap in order to try to find a user with the received passport. If
     * the user has been found then is returned.
     * @param passport is a key to try to find a user.
     * @return a value of either the found user or null.
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
     * The method tries to find a user using received passport. If the user is not a null then
     * it checks user's account using requisite. If the account exists it is returned. Otherwise,
     * null is returned.
     * @param passport is a key to find a user.
     * @param requisite is a number to identify an account.
     * @return is either the found account or null.
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            for (Account account : accounts) {
                if (account.getRequisite().equals(requisite)) {
                    return account;
                }
            }
        }
        return null;
    }

    /**
     * The method performs a money transfer from one account to another, using their passports and
     * requisites. The source is a giving side, the destination is receiving one.
     * @param sourcePassport is a number to identify a giving user.
     * @param sourceRequisite is a number to determine an account to transfer money from.
     * @param destinationPassport is a number of receiving user.
     * @param destinationRequisite is a number of an account of the receiving user.
     * @param amount is a money quantity.
     * @return is a state of a result of the transfer.
     */
    public boolean moneyTransfer(String sourcePassport,
                                  String sourceRequisite,
                                  String destinationPassport,
                                  String destinationRequisite,
                                  double amount) {
        boolean result = false;
        Account sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sourceAccount != null) {
            Account destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
            if (destinationAccount != null) {
                if (sourceAccount.getBalance() >= amount) {
                    destinationAccount.setBalance(destinationAccount.getBalance() + amount);
                    sourceAccount.setBalance(sourceAccount.getBalance() - amount);
                    result = true;
                }
            }
        }
        return result;
    }
}
