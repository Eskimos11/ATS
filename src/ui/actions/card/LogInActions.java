package ui.actions.card;


import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.Scanner;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class LogInActions extends AbstractAction implements IAction {

    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Card number.Example:2332 1421 1414 4353");
        String number = scanner.nextLine();
        System.out.println("Enter Pin");
        int pin = scanner.nextInt();
        facade.logIn(pin,number);

    }
}
