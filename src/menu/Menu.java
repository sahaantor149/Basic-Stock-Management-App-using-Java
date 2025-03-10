package menu;

import java.util.Objects;

public class Menu {
    public void displayMenu(String menu){
        if (Objects.equals(menu, "main")){
            System.out.print("\n1. Supplier\n=> ");
        } else if (Objects.equals(menu, "supplier")) {
            System.out.print("\n1. Show supplier list\n2. Add new supplier\n3. Edit supplier data\n4. Search supplier\n5. Delete supplier data\n=> ");
        }
    }
}
