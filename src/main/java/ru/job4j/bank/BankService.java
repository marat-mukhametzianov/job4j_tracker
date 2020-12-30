package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();

    public void addUser (User user) {
        if (!users.keySet().contains(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount (String passport, Account account) {
        User user = findByPassport(passport);
        if ( user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    public User findByPassport (String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) return user;
        }
        return null;
    }

    public Account findByRequisite (String passport, String requisite) {
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

    public boolean moneyTransfer (String sourcePassport,
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
