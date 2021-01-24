package ru.job4j.bank;

import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;
import static org.hamcrest.core.Is.is;

public class BankServiceTest {

    @Test
    public void addNonexistentUser() {
        BankService service = new BankService();
        User user = new User("12345", "John Smith");
        service.addUser(user);
        assertThat(service.findByPassport("12345"), is(user));
    }

    @Test
    public void addAccount() {
        BankService service = new BankService();
        User user = new User("12345", "John Smith");
        Account account = new Account("1", 100.5);
        service.addUser(user);
        service.addAccount("12345", account);
        assertThat(
                service.findByRequisite("12345", "1")
                        .get()
                        .getBalance(),
                is(100.5)
        );
    }

    @Test
    public void addAccountWhenWrongPassport() {
        BankService service = new BankService();
        User user = new User("12345", "John Smith");
        service.addUser(user);
        service.addAccount(user.getPassport(), new Account("1", 100.5));
        assertNull(service.findByRequisite("123", "1"));
    }

    @Test
    public void findByPassportExistingNumber() {
        BankService service = new BankService();
        User user = new User("12345", "Name");
        service.addUser(user);
        Optional<User> expected = service.findByPassport("12345");
        assertThat(expected.get(), is(user));
    }

    @Test
    public void findByPassportNonExistentNumber() {
        BankService service = new BankService();
        User user = new User("12345", "Name");
        service.addUser(user);
        Optional<User> expected = service.findByPassport("1");
        assertTrue(expected.isEmpty());
    }

    @Test
    public void findByRequisite() {
        BankService service = new BankService();
        User user = new User("12345", "Name");
        service.addUser(user);
        service.addAccount("12345", new Account("10", 100D));
        assertThat(
                service.findByRequisite("12345", "10")
                        .get()
                        .getBalance(),
                is(100D)
        );
    }

    @Test
    public void moneyTransferWrongSourcePassport() {
        BankService service = new BankService();
        User user1 = new User("1", "One");
        User user2 = new User("2", "Two");
        service.addUser(user1);
        service.addAccount(user1.getPassport(), new Account("11", 10.0));
        service.addUser(user2);
        service.addAccount("2", new Account("22", 20.0));
        assertFalse(service.moneyTransfer("0", "11", "2", "22", 5.0));
    }

    @Test
    public void moneyTransferWrongSourceRequisite() {
        BankService service = new BankService();
        User user1 = new User("1", "One");
        User user2 = new User("2", "Two");
        service.addUser(user1);
        service.addAccount(user1.getPassport(), new Account("11", 10.0));
        service.addUser(user2);
        service.addAccount("2", new Account("22", 20.0));
        assertFalse(service.moneyTransfer("1", "1", "2", "22", 5.0));
    }

    @Test
    public void moneyTransferWrongDestinationPassport() {
        BankService service = new BankService();
        User user1 = new User("1", "One");
        User user2 = new User("2", "Two");
        service.addUser(user1);
        service.addAccount(user1.getPassport(), new Account("11", 10.0));
        service.addUser(user2);
        service.addAccount("2", new Account("22", 20.0));
        assertFalse(service.moneyTransfer("1", "11", "0", "22", 5.0));
    }

    @Test
    public void moneyTransferWrongDestinationRequisite() {
        BankService service = new BankService();
        User user1 = new User("1", "One");
        User user2 = new User("2", "Two");
        service.addUser(user1);
        service.addAccount(user1.getPassport(), new Account("11", 10.0));
        service.addUser(user2);
        service.addAccount("2", new Account("22", 20.0));
        assertFalse(service.moneyTransfer("1", "11", "2", "0", 5.0));
    }

    @Test
    public void moneyTransferWrongAmount() {
        BankService service = new BankService();
        User user1 = new User("1", "One");
        User user2 = new User("2", "Two");
        service.addUser(user1);
        service.addAccount(user1.getPassport(), new Account("11", 10.0));
        service.addUser(user2);
        service.addAccount("2", new Account("22", 20.0));
        assertFalse(service.moneyTransfer("1", "11", "2", "22", 11.0));
    }

    @Test
    public void moneyTransfer() {
        BankService service = new BankService();
        User user1 = new User("1", "One");
        User user2 = new User("2", "Two");
        service.addUser(user1);
        service.addAccount(user1.getPassport(), new Account("11", 10.0));
        service.addUser(user2);
        service.addAccount("2", new Account("22", 20.0));
        assertTrue(service.moneyTransfer("1", "11", "2", "22", 10.0));
    }
}