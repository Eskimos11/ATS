package utils.csvparsers.writers;

import utils.FileParser;
import utils.Printer;
import utils.Settings;
import view.ATSfasade;

import java.io.PrintWriter;

public class CardToCSV {


	private static final String CARD_CSV = Settings.getInstance().getProperty("card");

	public static void writeCarsToCSV() {
		try {
			PrintWriter pr = new PrintWriter(CARD_CSV);
			String[] array = FileParser.cardToString(ATSfasade.getInstance().getCard());
			pr.println("      Number Card,PIN,Balance" );
			for (int i = 0; i < array.length; i++) {
				pr.println(array[i]);
			}
			Printer.print("ok");
			pr.close();
		} catch (Exception e) {
			System.out.println("No such file!");
		}
	}
}
