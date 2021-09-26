package api;

import model.Card;
import model.User;

import java.util.List;

public interface ICardService {

    Card createCard(User user, String number, int pin);

    void getBalance(Card card);

    void replenish(Card card, int sum);

    void withdrawMoney(Card card, int sum);

    Card logIn(String number, int pin);

    Card findCard(String number);

    Card findAut();

}
