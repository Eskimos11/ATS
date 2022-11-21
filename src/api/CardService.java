package api;

import model.Card;

import java.util.List;
/**
 * @author Павел Курило
 * @version 1.0
 */
public interface CardService {
    Card createCard(String number, int pin);

    void cardBalance(Card card);

    Card logIn(String number, int pin);

    void deactivateCard();

    Card findCard(String number);

    List<Card> getAllCards();

    Card findAut();

    void replenish(Card card, int sum);

    void withdrawMoney(Card card, int sum);
}
