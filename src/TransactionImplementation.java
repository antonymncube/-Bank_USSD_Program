import java.util.InputMismatchException;
import java.util.Scanner;

public class TransactionImplementation extends Account implements Transactions {
    // Scanner object to read input from the user.
    private Scanner input = new Scanner(System.in);

    // Constructor for the TransactionImplementation class.
    public TransactionImplementation() {
        // No initialization or setup required in the constructor.
    }

    // Method to send money from one client's account to another client's account.
    @Override
    public boolean sendMoney(Client sender, Client receiver) {
        // Get the current balance of the sender and receiver accounts.
        double senderBalance = sender.getAccountName().getBalance();
        double receiverCurrentAmount = receiver.getAccountName().getBalance();
        
        // Prompt the user to enter the amount to send.
        System.out.println("How much do you want to Deposit?");
        try {
            double sendAmount = input.nextDouble();

            // Check if the sender has sufficient balance to perform the transaction.
            if (senderBalance >= sendAmount) {
                // Deduct the amount from the sender and add it to the receiver's account.
                sender.getAccountName().setBalance(senderBalance - sendAmount);
                receiver.getAccountName().setBalance(receiverCurrentAmount + sendAmount);
                System.out.println("Transaction Successful: R" + sendAmount);
                System.out.println("Available Balance: R" + sender.getAccountName().getBalance());
                return true;
            } else {
                System.out.println("You have insufficient funds");
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return false;
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
            return false;
        } catch (Exception e) {
            System.out.println("Other exception occurred.");
            return false;
        }
    }

    // Method to perform a buy transaction for a client.
    @Override
    public boolean buy(Client client) {
        // Prompt the user to enter the amount to buy.
        System.out.println("How much do you want to buy");
        try {
            double amount = input.nextDouble();
            double clientAmount = client.getAccountName().getBalance();

            // Check if the client has sufficient balance to perform the buy transaction.
            if (clientAmount >= amount) {
                // Deduct the amount from the client's account balance.
                setBalance(clientAmount - amount);
                System.out.println("New balance: " + getBalance());
                return true;
            } else {
                System.out.println("You have insufficient funds");
                return false;
            }
        } catch (InputMismatchException e) {
            System.out.println("You have entered an invalid value");
            return false;
        }
    }

    // Method to check the balance of a client's account.
    @Override
    public double checkBalance(Client client) {
        // Return the current balance of the client's account.
        return client.getAccountName().getBalance();
    }
}
 