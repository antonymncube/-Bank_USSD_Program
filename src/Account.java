public class Account {
    // Instance variables to store balance, PIN, and account number.
    private double balance;
    private int pin;
    private int accountNumber;

    // Parameterized constructor for the Account class.
    public Account(double balance, int pin, int accountNumber) {
        this.balance = balance;
        this.pin = pin;
        this.accountNumber = accountNumber;
    }

    // Default constructor for the Account class.
    public Account() {
    }

    // Getter method to retrieve the account balance.
    public double getBalance() {
        return balance;
    }

    // Getter method to retrieve the account PIN.
    public int getPin() {
        return pin;
    }

    // Getter method to retrieve the account number.
    public int getAccountNumber() {
        return accountNumber;
    }

    // Protected method to set the account balance. Can be accessed by subclasses.
    protected void setBalance(double balance) {
        this.balance = balance;
    }
}
 