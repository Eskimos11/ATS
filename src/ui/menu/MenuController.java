package ui.menu;

import utils.Facade;

import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * @author Павел Курило
 * @version 1.0
 */
public class MenuController {

    private static MenuController instance;
    private Builder builder;
    private Navigator navigator;
    public Facade facade = Facade.getInstance();

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
        facade.importRoomsFromCSV();
        while (!index.equals(0)) {
            try {
                index = scanner.nextInt();
                navigator.navigate(index);
            }catch (InputMismatchException e){
                System.err.println("Incorrect number format");
                scanner.next();
            }

            if(!navigator.printMenu()){
                break;
            }

        }
        scanner.close();
        facade.exportRoomsToCSV();
    }
}

