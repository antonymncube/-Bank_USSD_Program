import java.util.Scanner;
import java.util.InputMismatchException;

public class Bank {
    // Instance variables for branch code and bank name.
    protected int BranchCode;
    protected String bankName;
    
    // Scanner object to read input from the user.
    Scanner input = new Scanner(System.in);

    // Parameterized constructor for the Bank class.
    public Bank(int branchCode, String bankName, Client[] clients) {
        this.BranchCode = branchCode;
        this.bankName = bankName;
        this.clients = clients;
    }

    // Default constructor for the Bank class.
    public Bank() {
    }

    // Creating Account objects for sample clients.
    Account accAntony = new Account(24315, 3524, 112345);
    Account accsila = new Account(1625, 8372, 326123);
    Account accXolani = new Account(4429, 2873, 6382684);
    Account accSkhulu = new Account(267, 3672, 665293);
    Account accthaba = new Account(8936, 2384, 467622);

    // Creating Client objects for sample clients and storing them in an array.
    Client Antony = new Client("Antony", "Mncube", accAntony);
    Client Xolani = new Client("Xolani", "Mncube", accXolani);
    Client Skhulu = new Client("Sbusiso", "Khumalo", accSkhulu);
    Client Thaba = new Client("Thaba", "Mncube", accthaba);
    Client Silas = new Client("Silas", "Maluleke", accsila);
    Client[] clients = {Antony, Xolani, Skhulu, Thaba, Silas};

    // Method to log in a client by verifying account number and PIN.
    public Client login(int accountNumber, int pin) {
        System.out.println("please enter your Account number");

        // Loop through the clients array to find the matching account and PIN.
        for (Client client : clients) {
            if (client.getAccountName().getPin() == pin && client.getAccountName().getAccountNumber() == accountNumber) {
                System.out.println("welcome you are now logged in " + client.getName());
                return client;
            }
        }

        return null;
    }

    // Method to confirm if an account exists by account number.
    public Client confirmAccount() {
        Scanner input = new Scanner(System.in);
        System.out.println("Deposit Account ");
        try {
            int accountNumber = input.nextInt();

            // Loop through the clients array to find the matching account number.
            for (Client client : clients) {
                if (client.getAccountName().getAccountNumber() == accountNumber) {
                    System.out.println("you can proceed " + client.getName());
                    return client;
                }
            }

            System.out.println("Account not found. Please enter a valid account number.");
            return null;
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid account number.");
            String r = input.next(); // Consume the invalid input
            return null;
        }
    }
}
