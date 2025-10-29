public class CafeJava {
    public static void main(String[] args){
        int[] numbers = {5, 10, 50, 0, 2};
        // Use a for loop to divide 100 by each number and print the quotient
        // Use a try/catch block to prevent a crash due to a zero division error (ArithmeticException)
        // Handle the exception by printing 'Cannot divide by zero.'
        try {
            for(int num:numbers){
                System.out.println(100/num);
            }

        }
        catch (Exception e){
            System.out.println("can't divided by zero ");
        }
    }
}