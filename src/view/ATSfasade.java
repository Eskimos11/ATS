package view;

import api.IATSfasade;
import model.Card;
import service.СardService;
import utils.FileParser;
import utils.csvparsers.readers.CSVToCard;
import utils.csvparsers.writers.CardToCSV;

import java.util.List;

public class ATSfasade implements IATSfasade {

    private СardService serviceCard = СardService.getInstance();
    private static ATSfasade atsfasade;

    private ATSfasade() {
    }

    public static ATSfasade getInstance() {
        if (atsfasade == null) {
            atsfasade = new ATSfasade();
        }

        return atsfasade;
    }


    public List<Card> getCard() {
        return this.serviceCard.getCard();
    }

    public void setCard(List<Card> card) {
        this.serviceCard.setCard(card);
    }

    @Override
    public Card logIn(String number, int pin) {
        Card card = serviceCard.logIn(number, pin);
        return card;
    }

    @Override
    public Card findAut() {
        Card card = serviceCard.findAut();
        return card;
    }

    @Override
    public void withdrawMoney(Card card, int sum) {
        serviceCard.withdrawMoney(card, sum);
    }

    @Override
    public void replenish(Card card, int sum) {
        serviceCard.replenish(card, sum);
    }

    public void exportRoomsToCSV() {
        try {
            CardToCSV.writeCarsToCSV();
        } catch (Exception var2) {
            System.out.println("Failed to export cards data to CSV file");
        }

    }

    public void importRoomsFromCSV() {
        try {
            this.setCard(FileParser.stringToCard(CSVToCard.readCard()));
        } catch (Exception var2) {
            System.out.println("Cards were not imported!");
        }

    }


}


