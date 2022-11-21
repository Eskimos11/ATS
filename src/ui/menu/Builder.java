package ui.menu;

import ui.actions.card.*;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class Builder {

    private static Builder instance;
    private Menu rootMenu;

    public Builder() {
    }

    public static Builder getInstance() {
        if (instance == null) {
            instance = new Builder();
        }
        return instance;
    }

    public void buildMenu() {
        rootMenu = new Menu();
        rootMenu.setName("ATS");
        rootMenu.addMenuItem(new MenuItem("Admin menu", () -> {},adminMenu()));
        rootMenu.addMenuItem(new MenuItem("User menu", () -> {}, loginMenu()));
        rootMenu.addMenuItem(new MenuItem("Exit",() -> {}));
    }

    public Menu adminMenu() {
        Menu adminMenu = new Menu();
        adminMenu.setName("Admin menu");
        adminMenu.addMenuItem(new MenuItem("Create card", new CreateCardActions(), rootMenu));
        adminMenu.addMenuItem(new MenuItem("Back", () -> {}, rootMenu));
        return adminMenu;
    }


    public Menu getRootMenu() {
        return rootMenu;
    }

    private Menu loginMenu() {
        Menu cardMenu = new Menu();
        cardMenu.setName("Card Menu");
        cardMenu.addMenuItem(new MenuItem("Insert card", new LogInActions(),getInstance().AutMenu()));
        cardMenu.addMenuItem(new MenuItem("Back ", () -> {}, rootMenu));
        return cardMenu;
    }

    private Menu AutMenu() {
        Menu autMenu = new Menu();
        autMenu.setName("User menu");
        autMenu.addMenuItem(new MenuItem("CheckBalance", new CheckBalanceActions(), autMenu));
        autMenu.addMenuItem(new MenuItem("Withdraw Money", new WithdrawMoneyActions(), autMenu));
        autMenu.addMenuItem(new MenuItem("Replenish an account", new ReplenishActions(), autMenu));
        autMenu.addMenuItem(new MenuItem("Back ",new DeactivateCardActions(), rootMenu));
        return autMenu;
    }



}
