package ui.actions.card;

import model.Card;
import ui.actions.AbstractAction;
import ui.actions.IAction;

import java.util.Scanner;

public class ReplenishActions  extends AbstractAction implements IAction {
    @Override
    public void execute() {
        Card card = atSfasade.findAut();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Amount for replenishment");
        int sum = scanner.nextInt();
        atSfasade.replenish(card,sum);
        System.out.println("Balance " + card.getBalance());
    }
}
