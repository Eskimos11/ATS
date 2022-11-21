package model;

import java.util.Objects;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class Card extends AEntity {
    private String number;
    private int balance;
    private int pin;
    private boolean at;

    public Card(String number, int balance, int pin) {
        this.number = number;
        this.balance = balance;
        this.pin = pin;
    }

    public Card() {
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

    public void setBalance(int balance) {
        this.balance = balance;
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

