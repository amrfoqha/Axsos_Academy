
import java.util.Random;
import java.util.Scanner;

public class NumbersGame extends Exception {
    public static void main(String[] args){
        System.out.println("Hello, human. I am thinking of a number between 0 and 10.");
        System.out.println("*********************************************************");
        System.out.println("Can you guess the number?");
        System.out.println("If you are not up to the task, you can always type 'q' to quit.");
        Scanner in =new Scanner(System.in);
        int counter=0;
        while(true){
        int answer = new Random().nextInt(0,10);

        while(counter != 3){
            counter++;
            System.out.println(answer);
            String guess = in.nextLine();
            if(guess.equals("q")){
                System.out.println("I knew you didn't have it in you.");
                System.out.println("Shutting down...");
                break;
            }



            try {
            if (Integer.parseInt(guess)<0 || Integer.parseInt(guess)>10) System.out.println("enter a number between 0 and 10");
            else{

            if(Integer.parseInt(guess)==answer){
                System.out.println("Lucky guess! But can you do it again?");
                break;
            }
            else if(counter<3){
                System.out.println("Swing and a miss! Keep trying...");
            }
            }

            }
            catch (Exception e){
                System.out.println("in valid input");
            }


        }
        System.out.println("Game over.Do you want to play again ?");
            System.out.println("enter Y to play again or N to quit.");
            String c=in.nextLine();
            if (c.equalsIgnoreCase("Y")){
                counter=0;
            }
            if (c.equalsIgnoreCase("N")){
                break;
            }
            else {
                System.out.println("in valid input");
            }


    }
    }

}