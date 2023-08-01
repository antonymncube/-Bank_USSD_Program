public class Client {
    // Instance variables for the client's name, surname, and account details.
    private String name;
    private String surName;
    private Account accountName;

    // Default constructor for the Client class.
    public Client() {
    }

    // Parameterized constructor for the Client class.
    public Client(String name, String surName, Account accountName) {
        this.name = name;
        this.surName = surName;
        this.accountName = accountName;
    }

    // Getter method to retrieve the client's name.
    public String getName() {
        return name;
    }

    // Getter method to retrieve the client's surname.
    public String getSurName() {
        return surName;
    }

    // Getter method to retrieve the client's account details.
    public Account getAccountName() {
        return accountName;
    }
}
 