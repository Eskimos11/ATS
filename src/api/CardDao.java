package api;

import model.Card;
/**
 * @author Павел Курило
 * @version 1.0
 */
public interface CardDao extends GenericDao<Card> {

    Card getCardByNumber(String number);
}
