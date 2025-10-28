public class CaffeJava {
    public static void main(String[] args) {
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ", your order will be ready shortly";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";

        // Menu variables (add yours below)
        double mochaPrice = 3.5;
        double dripCoffee=5.2;
        double latte=11.5;
        double cappuccino=21.8;

        // Customer name variables (add yours below)
        String customer1 = "Shatha";
        String customer2 ="Ahmad";
        String customer3 ="Sali";
        String customer4 ="Adam";

        // Order completions (add yours below)
        boolean isReadyOrder1 = false;//shatha
        boolean isReadyOrder2 = true;//ahmad
        boolean isReadyOrder3 = true;//sali
        boolean isReadyOrder4 = false;//adam


        // APP INTERACTION SIMULATION (Add your code for the challenges below)
        // Example:
        System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Shatha"
        // ** Your customer interaction print statements will go here ** //

        if (isReadyOrder3) {
            System.out.println(customer3+readyMessage+" "+displayTotalMessage+dripCoffee);
        }
        else System.out.println(customer3+pendingMessage);

        if (isReadyOrder2){
            System.out.println(customer2+readyMessage+" "+displayTotalMessage+cappuccino);

        }
        else System.out.println(customer2+pendingMessage);

        double saliTotal=2*latte;
        if (isReadyOrder3){
            System.out.println(customer3+displayTotalMessage+saliTotal);
        }
        else System.out.println(customer3+pendingMessage);

        double adamTotal=latte-dripCoffee;
        if (isReadyOrder4){
            System.out.println(customer4+readyMessage);
            System.out.println(displayTotalMessage+adamTotal);
        }
        else System.out.println(customer4+pendingMessage+' '+displayTotalMessage+adamTotal);
    }


}