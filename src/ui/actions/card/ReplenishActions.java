package ui.actions.card;

import model.Card;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.Scanner;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class ReplenishActions  extends AbstractAction implements IAction {

    @Override
    public void execute() {
        Card card = facade.findAut();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Amount for replenishment");
        int sum = scanner.nextInt();
        facade.replenish(card,sum);

    }
}
