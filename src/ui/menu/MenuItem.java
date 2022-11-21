package ui.menu;


import ui.actions.IAction;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class MenuItem {

    private String title;
    private IAction action;
    private Menu nextMenu;

    public MenuItem(String title, IAction action, Menu nextMenu) {
        this.title = title;
        this.action = action;
        this.nextMenu = nextMenu;
    }

    public MenuItem(String title, IAction action) {
        this.title = title;
        this.action = action;
    }


    public String getTitle() {
        return title;
    }


    public void doAction() {
        action.execute();
    }

    public Menu getNextMenu() {
        return nextMenu;
    }
}
