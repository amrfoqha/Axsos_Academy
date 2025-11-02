public class BankTest {
    public static void main(String[] args){
        // Create 3 bank accounts
        BankAccount acc1=new BankAccount();
        BankAccount acc2=new BankAccount();
        BankAccount acc3=new BankAccount();

        acc1.deposit("saving",511.5);
        acc2.deposit("checking",827.2);
        acc3.deposit("saving",127.2);

        acc2.deposit("saving",511.5);
        acc1.deposit("checking",827.2);
        acc3.deposit("checking",127.2);

        acc1.withdraw("saving",250.1);
        acc2.withdraw("saving",310.12);
        acc3.withdraw("checking",650.1);


        System.out.println("accounts numbers = " + BankAccount.getAccounts() +"\n"+"The Total Money ="+BankAccount.getTotalMoney());

        // Deposit Test
        // - deposit some money into each bank account's checking or savings account and display the balance each time
        // - each deposit should increase the amount of totalMoney

        // Withdrawal Test
        // - withdraw some money from each bank account's checking or savings account and display the remaining balance
        // - each withdrawal should decrease the amount of totalMoney

        // Static Test (print the number of bank accounts and the totalMoney)

    }
}