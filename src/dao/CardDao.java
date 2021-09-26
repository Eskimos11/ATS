package dao;

import model.Card;

import java.util.ArrayList;
import java.util.List;

public class CardDao {

    private List<Card> cards = new ArrayList();
    private static CardDao cardDao;

    public CardDao() {
    }

    public static CardDao getInstance() {
        if (cardDao == null) {
            cardDao = new CardDao();
        }

        return cardDao;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public List<Card> getCards() {
        return this.cards;
    }

}
