package ui.actions.card;

import ui.actions.AbstractAction;
import ui.actions.IAction;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class DeactivateCardActions extends AbstractAction implements IAction {
    @Override
    public void execute() {
        facade.deactivateCard();
    }
}
