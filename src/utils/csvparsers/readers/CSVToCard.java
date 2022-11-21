package utils.csvparsers.readers;


import utils.Settings;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVToCard {

    private static final String CARD_CSV = Settings.getInstance().getProperty("card");

    static String[] array;

    public static String[] readCard() {
        try {
            @SuppressWarnings("resource")
            Scanner sc = new Scanner(new File(CARD_CSV));
            List<String> lines = new ArrayList<>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine().replaceAll("\"", ""));
            }
            array = lines.toArray(new String[0]);
            System.out.println("Data uploaded");
        } catch (IOException e) {
            System.out.println("Failed to read from the file!");
        }

        return array;

    }
}
