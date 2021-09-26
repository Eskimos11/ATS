package ui.menu;



import view.ATSfasade;

import java.util.Scanner;


public class MenuController {

    private static MenuController instance;
    private Builder builder;
    private Navigator navigator;
    public ATSfasade atSfasade = ATSfasade.getInstance();

    private MenuController() {
        builder = Builder.getInstance();
        builder.buildMenu();
        navigator = Navigator.getInstance();
    }

    public static MenuController getInstance() {
        if (instance == null)
            instance = new MenuController();

        return instance;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        navigator.setCurrentMenu(builder.getRootMenu());
        navigator.printMenu();
        Integer index = -1;
        atSfasade.importRoomsFromCSV();
        while (!index.equals(0)) {
            index = scanner.nextInt();
            if (index == 0) {
                break;
            }
            navigator.navigate(index);
            navigator.printMenu();

        }
        scanner.close();
        atSfasade.exportRoomsToCSV();
    }
}

