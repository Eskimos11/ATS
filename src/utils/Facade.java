package utils;

import model.Card;
import service.CardServiceImpl;
import utils.csvparsers.readers.CSVToCard;
import utils.csvparsers.writers.CardToCSV;

import java.util.List;

public class Facade {

    private final CardServiceImpl cardService = CardServiceImpl.getInstance();

    private static Facade instance;

    public Facade() {
    }
    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }
    public void withdrawMoney(Card card, int sum) {
        cardService.withdrawMoney(card, sum);
    }

    public void logIn(int pin, String number) {
        cardService.logIn(number, pin);
    }
    public Card createCard(String number,int pin){
        return cardService.createCard(number,pin);
    }

    public Card findAut() {
        return cardService.findAut();

    }
    public void deactivateCard(){
        cardService.deactivateCard();
    }

    public void exportRoomsToCSV() {
        try {
            CardToCSV.writeCarsToCSV();
        } catch (Exception var2) {
            System.out.println("Failed to export cards data to CSV file");
        }

    }
    public void cardBalance(Card card){
       cardService.cardBalance(card);
    }
    public void replenish(Card card, int sum) {
        cardService.replenish(card, sum);
    }
    public void setCard(List<Card> card) {
        this.cardService.setCard(card);
    }
    public List<Card> getCard() {
        return this.cardService.getAllCards();
    }


    public void importRoomsFromCSV() {
        try {
            this.setCard(FileParser.stringToCard(CSVToCard.readCard()));
        } catch (Exception var2) {
            System.out.println("Cards were not imported!");
        }
    }


}
