package addressdata;
public class AddressEntry {
    private String firstName;
    private String lastName;
    private String street;
    private String city;
    private String state;
    private String postalCode;
    private String email;
    private String phoneNumber;
    
    // Constructor to initialize an AddressEntry object with provided informationn
    public AddressEntry(String firstName, String lastName, String street,
        String city, String state, String postalCode, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
    
    // Getter method to retrieve the last name of the AddressEntry
    public String getlastName() {
        return lastName;
    }
    
    // Override the toString() method to provide a string representation of the AddressEntry
    @Override
    public String toString() {
        return "Nombre: " + firstName + " " + lastName + "\n" +
                "Direccion: " + street + ", " + city + ", " + state + ", " + postalCode + "\n" +
                "Correo Electronico: " + email + "\n" +
                "Numero de Telefono: " + phoneNumber;
    }
    
}