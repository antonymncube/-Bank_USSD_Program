import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TransactionImplementation transaction = new TransactionImplementation();

        boolean run = true;

        // Create a new Bank instance to manage clients' accounts.
        Bank clients = new Bank();

        // Variable to control the access code verification loop.
        boolean conditionCode = false;

        // Loop to verify the access code before proceeding.
        do {
            System.out.println("Enter the access code:");
            String accessCode = input.nextLine();
            if (accessCode.equals("*120*37#")) {
                // Loop to handle user interactions after successful access code verification.
                do {
                    try {
                        System.out.println("Enter your account number:");
                        int accountNumber = input.nextInt();
                        System.out.println("Please enter your PIN:");
                        int pin = input.nextInt();
                        input.nextLine();  // Consume the remaining newline character.

                        // Attempt to log in the client with the provided account number and PIN.
                        Client loggedInClient = clients.login(accountNumber, pin);

                        if (loggedInClient != null) {
                            System.out.println("Enter a command (1-4, 999 to exit):");
                            System.out.println("1. Buy");
                            System.out.println("2. Check Balance");
                            System.out.println("3. Send Money");
                            System.out.println("999. Exit");

                            String option = input.nextLine();

                            // Process the selected option based on user input.
                            if ("1".equals(option)) {
                                transaction.buy(loggedInClient);
                            } else if ("2".equals(option)) {
                                System.out.println(transaction.checkBalance(loggedInClient));
                            } else if ("3".equals(option)) {
                                // Confirm the receiver's account and proceed with the money transfer.
                                Client receiverClient = clients.confirmAccount();
                                if (receiverClient != null) {
                                    transaction.sendMoney(loggedInClient, receiverClient);
                                } else {
                                    System.out.println("You have entered a wrong account.");
                                }
                            } else if ("999".equals(option)) {
                                run = false; // Exit the program.
                            } else {
                                System.out.println("Invalid command");
                            }
                        } else {
                            System.out.println("Invalid login. Please try again.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input");
                        input.nextLine(); // Consume the remaining invalid input.
                    }

                } while (run);

                System.out.println("Application closed");
            } else {
                System.out.println("Access code is incorrect. Please enter the correct code");
                conditionCode = true;
            }
        } while (conditionCode);

        System.out.println("To continue with the service, please login again.");
    }
}
