package ru.job4j.bank;

import java.util.*;

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
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
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
    public Optional<User> findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(key -> key.getPassport().equals(passport))
                .findFirst();
    }

    /**
     * The method tries to find a user using received passport. If the user is not a null then
     * it checks user's account using requisite. If the account exists it is returned. Otherwise,
     * null is returned.
     * @param passport is a key to find a user.
     * @param requisite is a number to identify an account.
     * @return is either the found account or null.
     */
    public Optional<Account> findByRequisite(String passport, String requisite) {
        Optional<User> user = findByPassport(passport);
        if (user.isPresent()) {
            List<Account> accounts = users.get(user.get());
            return accounts
                    .stream()
                    .filter(a -> a.getRequisite().equals(requisite))
                    .findFirst();
        } else {
            return Optional.empty();
        }
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
        Optional<Account> sourceAccount = findByRequisite(sourcePassport, sourceRequisite);
        if (sourceAccount.isPresent()) {
            Optional<Account> destinationAccount = findByRequisite(destinationPassport, destinationRequisite);
            if (destinationAccount.isPresent()) {
                if (sourceAccount.get().getBalance() >= amount) {
                    destinationAccount.get().setBalance(destinationAccount.get().getBalance() + amount);
                    sourceAccount.get().setBalance(sourceAccount.get().getBalance() - amount);
                    result = true;
                }
            }
        }
        return result;
    }
}