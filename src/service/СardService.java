package service;

import api.ICardService;
import dao.CardDao;
import model.Card;
import model.User;


import java.util.ArrayList;
import java.util.List;

public class СardService implements ICardService {

    CardDao cardDao = CardDao.getInstance();

    private static СardService serviceCard;

    public static СardService getInstance() {
        if (serviceCard == null) {
            serviceCard = new СardService();
        }

        return serviceCard;
    }
    @Override
    public Card createCard(User user, String number, int pin) {
        int balance = 0;
        Card card = new Card(user, number, balance, pin);
        cardDao.addCard(card);
        return card;
    }

    @Override
    public void getBalance(Card card) {
        if (card.isAt()) {
            System.out.println("Your balance = " + card.getBalance());
        } else
            System.out.println("You are not logged into your account");
    }

    @Override
    public void replenish(Card card, int sum) {
        if (card.isAt()) {
            int a = card.getBalance() + sum;
            card.setBalance(a);
        } else
            System.out.println("You are not logged into your account");
    }

    @Override
    public void withdrawMoney(Card card, int sum) {
        if (card.isAt() & sum < card.getBalance()) {
            int a = card.getBalance() - sum;
            card.setBalance(a);
        } else
            System.out.println("You are not logged into your account ");
    }

    @Override
    public Card findAut() {
        List<Card> list1 = new ArrayList<>();
        for (Card card1 : cardDao.getCards()) {
            if (card1.isAt()) {
                list1.add(card1);
            }

        }
        Card card1 = list1.get(0);
        return card1;
    }


    @Override
    public Card logIn(String number, int pin) {
        Card card1 = findCard(number);
        if (card1.getPin() == pin) {
            card1.setAt(true);
            System.out.println("You have successfully logged in");
        } else
            System.out.println("Wrong password ");

        return card1;
    }

    @Override
    public Card findCard(String number) {
        List<Card> newlist = new ArrayList<>();

        for (Card card : cardDao.getCards()) {
            if (card.getNumber().equals(number)) {
                newlist.add(card);
            }

        }
        if (newlist.isEmpty()) {
            System.out.println("Card not found");
        }
        Card card1 = newlist.get(0);
        return card1;
    }


    public List<Card> getCard() {
        return CardDao.getInstance().getCards();
    }

    public void setCard(List<Card> cards) {
        CardDao.getInstance().setCards(cards);
    }
}
