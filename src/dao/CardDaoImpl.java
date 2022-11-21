package dao;

import api.CardDao;
import model.Card;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class CardDaoImpl extends AbstractDao<Card> implements CardDao {

    private static CardDaoImpl cardDao;

    public static CardDaoImpl getInstance() {
        if (cardDao == null) {
            cardDao = new CardDaoImpl();
        }

        return cardDao;
    }

    @Override
    public Card getCardByNumber(String number) {
        for (Card card : cardDao.getAll()) {
            if (number.equals(card.getNumber())) {
                return card;
            }
        }
        return null;
    }
}
