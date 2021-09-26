package model;

import java.util.Objects;

public class Card {
    private User user;
    private String number;
    private int balance;
    private int pin;
    private boolean at;

    public Card(User user, String number, int balance, int pin) {
        this.user = user;
        this.number = number;
        this.balance = balance;
        this.pin = pin;
    }
    public Card() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        if (balance >= 100000) {
            System.out.println("Limit exceeded. Limit - 1000000");
        } else
            this.balance = balance;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public boolean isAt() {
        return at;
    }

    public void setAt(boolean at) {
        this.at = at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card)) return false;
        Card card = (Card) o;
        return getNumber().equals(card.getNumber());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }

    @Override
    public String toString() {
        return "Card{" +
                "number='" + number + '\'' +
                ", balance=" + balance +
                ", pin=" + pin +
                '}';
    }
}
