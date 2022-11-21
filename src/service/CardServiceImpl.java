package service;

import api.CardDao;
import api.CardService;
import dao.CardDaoImpl;
import exceptions.NotFoundCardException;
import exceptions.WrongPasswordException;
import model.Card;
import utils.IdGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class CardServiceImpl implements CardService {

    private final CardDao cardDao = CardDaoImpl.getInstance();
    private static CardServiceImpl serviceCard;

    public static CardServiceImpl getInstance() {
        if (serviceCard == null) {
            serviceCard = new CardServiceImpl();
        }

        return serviceCard;
    }

    @Override
    public Card createCard(String number, int pin) {
        int balance = 0;
        Scanner scanner = new Scanner(System.in);
        while (!validateNumberCard(number)) {
            System.out.println("Incorrect input: Example 7832-2452-3241-1234");
            number = scanner.next();
        }
        Card card = new Card(number, balance, pin);
        card.setId(IdGenerator.generateCardId());
        cardDao.save(card);
        return card;
    }

    private boolean validateNumberCard(String number) {
        Pattern numberCard = Pattern.compile("([0-9]{4}-[0-9]{4}-[0-9]{4}-[0-9]{4})");
        Matcher cardNumberMatcher = numberCard.matcher(number);
        return cardNumberMatcher.matches();
    }

    @Override
    public void cardBalance(Card card) {
        System.out.println("Your balance = " + card.getBalance());
    }

    @Override
    public Card logIn(String number, int pin) {
        Card card = null;
        try {
            numberAndPasswordVerification(number, pin);
            card = findCard(number);
            card.setAt(true);
            System.out.println("You have successfully logged in");
        } catch (NotFoundCardException e) {
            throw new NotFoundCardException();
        } catch (WrongPasswordException e) {
            throw new WrongPasswordException();
        }
        return card;

    }


    private void numberAndPasswordVerification(String n, int pin) {
        Card card = findCard(n);
        if (card == null) {
            System.err.println("Not Found Card");
            throw new NotFoundCardException();
        }
        if (card.getPin() != pin) {
            System.err.println("Wrong password");
            throw new WrongPasswordException();
        }
    }


    @Override
    public List<Card> getAllCards() {
        return cardDao.getAll();
    }

    @Override
    public void deactivateCard() {
        Card aut = findAut();
        if (aut != null) {
            aut.setAt(false);
        }
    }

    @Override
    public Card findCard(String number) {
        Card card;
        card = cardDao.getCardByNumber(number);
        return card;
    }

    public void setCard(List<Card> list) {
        cardDao.setRepository(list);
    }

    @Override
    public void replenish(Card card, int sum) {
        int limit = 1000000;
        if (sum < limit) {
            int a = card.getBalance() + sum;
            card.setBalance(a);
            System.out.println("You have replenished your balance by the amount " + sum);
        } else
            System.out.println("Limit exceeded");

    }

    @Override
    public void withdrawMoney(Card card, int sum) {
        if (card.getBalance() > sum) {
            int a = card.getBalance() - sum;
            card.setBalance(a);
            System.out.println("You withdraw money in the amount of " + sum);
        } else
            System.out.println("You try to withdraw more money that you have");
    }

    @Override
    public Card findAut() {
        List<Card> list1 = new ArrayList<>();
        for (Card card1 : cardDao.getAll()) {
            if (card1.isAt()) {
                list1.add(card1);
            }
        }
        return list1.get(0);
    }
}


