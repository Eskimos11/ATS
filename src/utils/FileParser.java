package utils;

import model.Card;

import java.util.ArrayList;
import java.util.List;

public class FileParser {

    private static final String SEPARATOR = " ";

    public static String[] cardToString(List<Card> CardList) {
        String[] serviceStrings = new String[CardList.size()];
        for (int i = 0; i < CardList.size(); i++) {

            Card newCard = CardList.get(i);

            StringBuilder s = new StringBuilder();
            s.append(newCard.getNumber());
            s.append(SEPARATOR);
            s.append(newCard.getBalance());
            s.append(SEPARATOR);
            s.append(newCard.getPin());
            s.append(SEPARATOR);

            serviceStrings[i] = s.toString();
        }
        return serviceStrings;
    }

    public static List<Card> stringToCard(String[] array) {

        List<Card> loadedCard = new ArrayList<>();

        for (int i = 1; i < array.length; i++) {

            String[] parsedString = array[i].split(" ");

            Card newCard = new Card();

            newCard.setNumber(parsedString[0]);
            newCard.setBalance(Integer.parseInt(parsedString[1]));
            newCard.setPin(Integer.parseInt(parsedString[2]));

            loadedCard.add(newCard);

        }
        return loadedCard;
    }

}
