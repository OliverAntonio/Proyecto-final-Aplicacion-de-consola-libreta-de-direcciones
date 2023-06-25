package addressdata;
import java.util.List;
import java.util.Scanner;

public class AddressBookApplication {
    private final AddressBook addressBook;
    private final Scanner entrada;

    public AddressBookApplication() {
        addressBook = new AddressBook();
        entrada = new Scanner(System.in);

    } 
    
    // Method to start the address book application
    public void start() {
        boolean on = true;
     
        while (on) {
            Menu menu = new Menu();
            menu.displayMenu();
            String decision = option();
            
            // Perform actions based on the user's decision
            if (decision.equals("1")) {
                addEntry();
            } else if (decision.equals("2")) {
                removeEntry();
            } else if (decision.equals("3")) {
                searchEntries();
            } else if (decision.equals("4")) {
                showEntries();
            } else if (decision.equals("5")) {
                on = false;
            } else if (!"1".equals(decision) && !"2".equals(decision) && !"3".equals(decision) && !"4".equals(decision) && !"5".equals(decision)) {
                System.out.println("Introduzca una opcion valida.");
            }
        }
    }
    
    // Method to prompt the user for an option
    private String option() {
        System.out.println("Elija la opcion que desee usar: ");
        System.out.print("\033[31m"); // Print text in red color
        return entrada.nextLine();

    }
    
    // Method to add an entry to the address book
    private void addEntry() {
        System.out.println("Ingrese los datos del nuevo registro:");
        
        System.out.print("Nombre: ");
        String firstName = entrada.nextLine();
        
        System.out.print("Apellido: ");
        String lastName = entrada.nextLine();
        
        System.out.print("Calle: ");
        String street = entrada.nextLine();
        
        System.out.print("Ciudad: ");
        String city = entrada.nextLine();
        
        System.out.print("Estado: ");
        String state = entrada.nextLine();
        
        System.out.print("Codigo Postal: ");
        String postalCode = entrada.nextLine();
        
        System.out.print("Correo Electronico: ");
        String email = entrada.nextLine();
        
        System.out.print("Numero de Telefono: ");
        String phoneNumber = entrada.nextLine();
        
        // Create an AddressEntry object with the entered details and add it to the address book
        AddressEntry entry = new AddressEntry(firstName, lastName, street, city, state, postalCode, email, phoneNumber);
        addressBook.addEntry(entry);
    }

    private void removeEntry() {
        System.out.println("Ingrese el apellido del registro que va eliminar: ");
        String lastName = entrada.nextLine();
        
        // Search for entries with the given last name
        List<AddressEntry> searchResults = addressBook.searchEntries(lastName);
        if (!searchResults.isEmpty()) {
            System.out.println("Se encontraron los siguientes registros: ");
            
            // Display the search results
            for (int i = 0; i < searchResults.size(); i++) {
                System.out.println((i + 1) + ". " + searchResults.get(i));
            }
            
            System.out.print("Selecciona el numero del registro a eliminar: ");
            
            int decision = Integer.parseInt(entrada.nextLine());
            
            if (decision >= 1 && decision <= searchResults.size()) {
                // Remove the selected entry from the address book
                AddressEntry entryToRemove = searchResults.get(decision - 1);
                addressBook.removeEntry(entryToRemove);
                System.out.println("Registro eliminado.");
            } else {
                System.out.println("Opcion invalida.");
            }
        } else {
            System.out.println("No se encontraron registros con esos datos.");
        }
    }

    private void searchEntries() {
        System.out.println("Ingrese el apellido a buscar: ");
        String lastName = entrada.nextLine();
        
        // Search for entries with the given last name
        List<AddressEntry> searchResults = addressBook.searchEntries(lastName);
        if (!searchResults.isEmpty()) {
            System.out.println("Se encontraron los siguientes registros: ");
            
            // Display the search results
            for (AddressEntry entry : searchResults) {
                System.out.println(entry);
                System.out.println("-----------------");
            }
            
        } else {
            System.out.println("No se encontraron registros con ese apellido.");
        }
    }

    private void showEntries() {
        // Sort the entries by last name
        addressBook.ordinationEntries();
        List<AddressEntry> entries = addressBook.getAllEntries();
        if (!entries.isEmpty()) {
            System.out.println("Lista de registros:");
            // Display the entries
            for (AddressEntry entry : entries) {
                System.out.println(entry);
                System.out.println("------------------------------------");
            }
            
        } else {
            System.out.println("No hay registros guardados anteriormente.");
        }
    }

    public static void main(String[] args) {
        // Create an instance of AddressBookApplication
        AddressBookApplication application = new AddressBookApplication();
        // Start the application
        application.start();
    }
}