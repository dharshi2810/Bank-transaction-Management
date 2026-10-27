package demo.bankaop;

import org.springframework.stereotype.Service;

@Service
public class BankService {
	private double balance = 1000.0;

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be positive");
        }

        balance += amount;
        System.out.println("Deposited: " + amount
                + ", Balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException(
                "Amount must be positive");
        }

        if (amount > balance) {
            throw new IllegalArgumentException(
                "Insufficient balance");
        }

        balance -= amount;
        System.out.println("Withdrawn: " + amount
                + ", Balance: " + balance);
    }

    public double getBalance() {
        return balance;
    }
}
