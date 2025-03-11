package menu;

import java.util.Objects;

public class Menu {
    public void displayMenu(String menu){
        if (Objects.equals(menu, "main")){
            System.out.print("\n1. Supplier\n2. Category\n=> ");
        } else if (Objects.equals(menu, "supplier")) {
            System.out.print("\n1. Show supplier list\n2. Add new supplier\n3. Edit supplier data\n4. Search supplier\n5. Delete supplier data\n=> ");
        } else if (Objects.equals(menu, "category")){
            System.out.print("\n1. Show category list\n2. Add new Category\n3. Edit category\n4. Delete category\n=> ");
        }
    }
}
