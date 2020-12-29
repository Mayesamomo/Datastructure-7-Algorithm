/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package creditcard;

/**
 *
 * @author itadmin
 */
public class CreditCard {

    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;
//constructor

    public CreditCard(String customer, String bank, String account, int limit, double balance) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
        this.balance = balance;
    }

    public CreditCard(String customer, String bank, String account, int limit) {
        this.customer = customer;
        this.bank = bank;
        this.account = account;
        this.limit = limit;
    }

//accessors
    public String getCustomer() {
        return customer;
    }

    public String getBank() {
        return bank;
    }

    public String getAccount() {
        return account;
    }

    public int getLimit() {
        return limit;
    }

    public double getBalance() {
        return balance;
    }
//update method

    public boolean charge(double price) { //make charge
        if (price + balance > limit) //if charge would surpase 
        {
            return false;         //refuse charge i.e do not allow spending or withdrawal
        }        //at this point , charge is successful
        balance += price;
        return true;

    }

    //make payment 
    public void makePayment(double amount) {
        balance -= amount;
    }
    //utilit method to printout card's information

    public static void printSummary(CreditCard card) {
        System.out.println("Customer = " + card.customer);
        System.out.println("Bank = " + card.bank);
        System.out.println("Account = " + card.account);
        System.out.println("Balance = " + card.balance);
        System.out.println("Limit = " + card.limit);

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        CreditCard[] wallet = new CreditCard[3];
        wallet[0] = new CreditCard("John Smith", "California Savings", "5391 0375 9387 5309", 5000);
        wallet[1] = new CreditCard("John Doe", "California Savings", "5391 0375 9387 5309", 500);
        wallet[2] = new CreditCard("Jane Smith", "California Savings", "5391 0375 9387 5309", 1500);
        for(int val =1; val <= 16; val++){
            wallet[0].charge(3*val);
            wallet[1].charge(2*val);
            wallet[2].charge(val);
        }
        for(CreditCard card : wallet){
            CreditCard.printSummary(card);
            while(card.getBalance() > 200.0){
                card.makePayment(200);
                System.out.println("New Balance = " + card.getBalance());
            }
        }

    }

}
