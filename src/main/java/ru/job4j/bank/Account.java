package ru.job4j.bank;

import java.util.Objects;

public class Account {
    private String requisite;
    private double balance;

    public Account(String requisite, double balance) {
        this.requisite = requisite;
        this.balance = balance;
    }

    public String getRequisite() {
        return requisite;
    }

    public void setRequisite(String requisite) {
        this.requisite = requisite;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || object.getClass() == this.getClass()) return false;
        Account account = (Account) object;
        return Objects.equals(account.requisite, this.requisite);
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisite);
    }
}
