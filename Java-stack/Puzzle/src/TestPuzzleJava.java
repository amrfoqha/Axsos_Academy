import java.util.ArrayList;
import java.util.Random;
public class TestPuzzleJava {

    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        int[] randomRolls = generator.getTenRolls();

        for(int roll:randomRolls) {
            System.out.print(roll+" ");
        }

        char x =generator.getRandomLetter();
        System.out.println(x);

        String Password=generator.generatePassword();
        System.out.println(Password);


        ArrayList<String> PasswordSets=generator.getNewPasswordSet(10);
        System.out.println(PasswordSets);

//        ArrayList<String> ShuffeldPassword=generator.shufflePassword(Password);
//        System.out.println(ShuffeldPassword);

    }
}