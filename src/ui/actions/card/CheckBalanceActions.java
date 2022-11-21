package ui.actions.card;

import model.Card;
import ui.actions.AbstractAction;
import ui.actions.IAction;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class CheckBalanceActions extends AbstractAction implements IAction {
    @Override
    public void execute() {
        Card aut = facade.findAut();
        facade.cardBalance(aut);
    }
}
