package api;

import model.Card;

public interface IATSfasade {
    Card logIn(String number, int pin);

    Card findAut();

    void withdrawMoney(Card card,int sum);

    void replenish(Card card,int sum);
}
