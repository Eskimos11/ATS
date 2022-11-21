package utils.csvparsers.writers;

import utils.Facade;
import utils.FileParser;
import utils.Printer;
import utils.Settings;

import java.io.PrintWriter;

public class CardToCSV {


	private static final String CARD_CSV = Settings.getInstance().getProperty("card");

	public static void writeCarsToCSV() {
		try {
			PrintWriter pr = new PrintWriter(CARD_CSV);
			String[] array = FileParser.cardToString(Facade.getInstance().getCard());
			pr.println("   Number Card,Balance,PIN" );
			for (int i = 0; i < array.length; i++) {
				pr.println(array[i]);
			}
			System.out.println("Data updated");
			pr.close();
		} catch (Exception e) {
			System.out.println("No such file!");
		}
	}
}
