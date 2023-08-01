public interface Transactions {
    boolean sendMoney(Client sender ,Client receiver);
    boolean buy(Client client);
    double checkBalance(Client client);

}

 