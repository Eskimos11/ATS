package ui.menu;

import ui.actions.card.LogInActions;
import ui.actions.card.ReplenishActions;
import ui.actions.card.WithdrawMoneyActions;

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
        rootMenu.addMenuItem(new MenuItem("Menu", () -> {
        }, loginMenu()));
//        rootMenu.addMenuItem(new MenuItem("Exit" , ()-> { },);


    }


    public Menu getRootMenu() {
        return rootMenu;
    }

    private Menu loginMenu() {
        Menu cardMenu = new Menu();
        cardMenu.setName("Card Menu");
        cardMenu.addMenuItem(new MenuItem("Insert card", new LogInActions(), getInstance().AutMenu()));
        cardMenu.addMenuItem(new MenuItem("Back ", () -> {
        }, rootMenu));
        return cardMenu;
    }

    //
    private Menu AutMenu() {
        Menu autMenu = new Menu();
        autMenu.setName(" ");
        autMenu.addMenuItem(new MenuItem("Withdraw Money", new WithdrawMoneyActions(), autMenu));
        autMenu.addMenuItem(new MenuItem("Replenish an account", new ReplenishActions(), autMenu));
        autMenu.addMenuItem(new MenuItem("Back ", () -> {
        }, rootMenu));
        return autMenu;
    }


}
