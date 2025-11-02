public class BankAccount {
    private double checkingBalance;
    private double savingsBalance;
    private static int accounts;
    private static double totalMoney;

    public BankAccount(){
    accounts++;
    }
    public static double getTotalMoney(){
        return  totalMoney;
    }
    public static int getAccounts(){
        return  accounts;
    }
    public double getSavingsBalance(){
        return  savingsBalance;
    }
    public double getCheckingBalance(){
        return  checkingBalance;
    }
    public void deposit(String account , double amount){
        if(account.equalsIgnoreCase("checking")){
            checkingBalance+=amount;
            totalMoney+=amount;
            displayBalance(account);

        }
        if(account.equalsIgnoreCase("saving")){
            savingsBalance+=amount;
            totalMoney+=amount;
            displayBalance(account);

        }

    }
    public void withdraw(String account , double amount){
        if(account.equalsIgnoreCase("checking")){
            if (checkingBalance < amount) {
                System.out.println("there's no enough money inside the checking account");
            }
            else {
            checkingBalance-=amount;
            totalMoney-=amount;
            displayBalance(account);

            }
        }

        if(account.equalsIgnoreCase("saving")  ){
            if (savingsBalance < amount) {
                System.out.println("there's no enough money inside the saving account");

            }
            else {
            savingsBalance-=amount;
            totalMoney-=amount;
            displayBalance(account);
            }
        }

    }
    public void displayBalance(String account ){
        if(account.equalsIgnoreCase("checking"))
            System.out.println("checkingBalance = " + getCheckingBalance());
        if(account.equalsIgnoreCase("saving")  )
            System.out.println("savingsBalance = " + getSavingsBalance());
    }



}
