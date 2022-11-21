package ui.actions.card;

import model.Card;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.Scanner;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class CreateCardActions extends AbstractAction implements IAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the card number, Example:1234-4124-1231-1233");
        String number = scanner.next();
        System.out.println("Enter the PIN code");
        int pin = scanner.nextInt();
        Card card = facade.createCard(number,pin);
        System.out.println("The card is registered. Card number: " + card.getNumber() + " PIN " + card.getPin());


    }
}
