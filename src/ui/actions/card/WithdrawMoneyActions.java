package ui.actions.card;

import model.Card;
import ui.actions.AbstractAction;
import ui.actions.IAction;


import java.util.Scanner;

public class WithdrawMoneyActions extends AbstractAction implements IAction {

    @Override
    public void execute() {
        Card card = atSfasade.findAut();
        Scanner scanner = new Scanner(System.in);
        System.out.println("amount to be issued");
        int sum = scanner.nextInt();
        atSfasade.withdrawMoney(card, sum);
        System.out.println("Your balance " + card.getBalance());
    }
}
