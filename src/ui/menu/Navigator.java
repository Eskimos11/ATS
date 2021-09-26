package ui.menu;


import utils.Printer;

import java.util.List;


public class Navigator {


    private static Navigator instance;

    public Menu getCurrentMenu() {
        return currentMenu;
    }

    private Menu currentMenu;

    private Navigator() {

    }

    public static Navigator getInstance() {
        if (instance == null) {
            instance = new Navigator();
        }
        return instance;
    }

    public void printMenu() {
        Printer.print(currentMenu.getName());
        List<MenuItem> items = currentMenu.getMenuItems();
        for (int i = 0; i < items.size(); i++) {
            MenuItem item = items.get(i);
            Printer.print((i + 1) + ". " + item.getTitle());
        }
    }

    public void navigate(int index) {
        try {
            if (currentMenu != null) {
                MenuItem menuItem = currentMenu.getMenuItems().get(index - 1);
                menuItem.doAction();
                currentMenu = menuItem.getNextMenu();
            }
        } catch (Exception e) {

        }
    }

    public void setCurrentMenu(Menu currentMenu) {
        this.currentMenu = currentMenu;
    }
}
