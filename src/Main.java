import menu.Menu;
import supplier.Supplier;

import java.util.Scanner;

public class Main {
    public final Scanner scanner = new Scanner(System.in);

    public final int maxLimit = 999;
    public int supplierCurrentIndex = 0;

    public final Supplier[] suppliers = new Supplier[maxLimit];
    public final Menu menu = new Menu();

    public static void main(String[] args){
        Main mainApp = new Main();

        while (true){
            mainApp.run();
        }
    }

    public void run(){
        menu.displayMenu("main");
        int mainMenuInput = scanner.nextInt();

        switch (mainMenuInput){
            case 1:
                menu.displayMenu("supplier");
                int supplierMenuInput = scanner.nextInt();

                if (supplierMenuInput == 1){
                    displayAllSupplier();
                } else if (supplierMenuInput == 2) {
                    addNewSupplier();
                    supplierCurrentIndex++;
                } else if (supplierMenuInput == 3) {
                    editSupplier();
                } else if (supplierMenuInput == 4) {
                    searchSupplier();
                } else if (supplierMenuInput == 5) {
                    deleteSupplier();
                } else {
                    System.out.println("\nInvalid input!");
                }
                break;
            default:
                System.out.println("\nInvalid input!");
        }
    }

    public void displayAllSupplier(){
        System.out.println("+------------+----------------------+");

        System.out.printf("| %-10s | %-20s|\n", "Supplier ID", "Supplier Name");

        System.out.println("+------------+----------------------+");

        boolean supplierFound = false;

        for (int i = 0; i < supplierCurrentIndex; i++) {
            if (suppliers[i] != null) {
                System.out.printf("| %-10d | %-20s |\n", suppliers[i].id, suppliers[i].name);
                supplierFound = true;
            }
        }

        if (!supplierFound) {
            System.out.printf("|%-8s%-27s|\n", "", "No data found");
        }

        System.out.println("+------------+----------------------+");
    }

    public void addNewSupplier(){
        System.out.print("\nSupplier Id: ");
        int id = scanner.nextInt();

        scanner.nextLine();

        System.out.print("Supplier Name: ");
        String name = scanner.nextLine();

        suppliers[supplierCurrentIndex] = new Supplier(name, id);

        supplierCurrentIndex++;

        System.out.println("\nNew supplier added successfully.");
    }

    public void editSupplier() {
        System.out.print("\nEnter supplier id: ");
        int id = scanner.nextInt();

        boolean supplierFound = false;

        scanner.nextLine();

        for (int i = 0; i < supplierCurrentIndex; i++) {
            if (suppliers[i] != null && suppliers[i].id == id) {
                System.out.print("Enter new name: ");
                suppliers[i].name = scanner.nextLine();

                System.out.print("Enter new id: ");
                suppliers[i].id = scanner.nextInt();

                System.out.println("\nSupplier updated successfully.");
                supplierFound = true;
                break;
            }
        }

        if (!supplierFound) {
            System.out.println("\nSupplier id not found!");
        }
    }

    public void searchSupplier() {
        System.out.print("\nEnter supplier id: ");
        int id = scanner.nextInt();

        System.out.println("+------------+----------------------+");

        System.out.printf("| %-10s | %-20s|\n", "Supplier ID", "Supplier Name");

        System.out.println("+------------+----------------------+");

        boolean supplierFound = false;

        scanner.nextLine();

        for (int i = 0; i < supplierCurrentIndex; i++) {
            if (suppliers[i] != null && suppliers[i].id == id) {
                System.out.printf("| %-10d | %-20s |\n", suppliers[i].id, suppliers[i].name);
                supplierFound = true;
            }
        }

        if (!supplierFound) {
            System.out.printf("|%-6s%-29s|\n", "", "Supplier not found");
        }

        System.out.println("+------------+----------------------+");
    }

    public void deleteSupplier() {
        System.out.print("Enter supplier id: ");
        int id = scanner.nextInt();

        boolean supplierFound = false;

        // Iterate through the array to find the supplier with the given ID
        for (int i = 0; i < supplierCurrentIndex; i++) {
            if (suppliers[i] != null && suppliers[i].id == id) {
                // Supplier found, remove it by shifting the elements
                for (int j = i; j < supplierCurrentIndex - 1; j++) {
                    suppliers[j] = suppliers[j + 1];  // Shift suppliers down
                }

                // Set the last element to null (since it's now shifted)
                suppliers[supplierCurrentIndex - 1] = null;

                // Update the current supplier index
                supplierCurrentIndex--;

                System.out.println("\nSupplier deleted successfully.");
                supplierFound = true;
                break;
            }
        }

        // If the supplier with the given ID was not found
        if (!supplierFound) {
            System.out.println("\nSupplier id not found!");
        }
    }


}
