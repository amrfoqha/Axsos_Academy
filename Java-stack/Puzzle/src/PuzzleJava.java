import java.util.ArrayList;
import java.util.Random;
import java.lang.String;
public class PuzzleJava {
    Random random=new Random();
    public int[] getTenRolls(){

    int arr[]=new int[10];
        for (int i = 0; i < 10; i++) {
            arr[i]=random.nextInt(20)+1;
        }
        return arr;
    }
    public char getRandomLetter(){
        String alphs="abcdefghijklmnopqrstuvwxyz";
        return alphs.charAt(random.nextInt(26));
    }
    public String generatePassword(){
        String password="";
        String alphs="abcdefghijklmnopqrstuvwxyz";
        for (int i = 0; i < 8; i++) {
            password= password.concat(String.valueOf(alphs.charAt(random.nextInt(26))));
        }

        return password;
    }

    public ArrayList<String> getNewPasswordSet(int length){
        ArrayList<String> PasswordSets = new ArrayList<String>();
        for (int i = 0; i < length; i++) {

        String password="";
        String alphs="abcdefghijklmnopqrstuvwxyz";
        for (int j = 0; j < 8; j++) {
            password=password.concat(String.valueOf(alphs.charAt(random.nextInt(26))));
        }
            PasswordSets.add(password);
        }
        return PasswordSets;
    }
//    public ArrayList<String> shufflePassword(String Password){
//        ArrayList<String> arr= new ArrayList<String>();
//        arr=Password;
//
//        for (int i = 0; i < Password.length; i++) {
//            int z = random.nextInt(Password.length);
//            int y = random.nextInt(Password.length);
//            Char temp = arr.get(z);
//            arr.set(z, y);
//            arr.set(y, temp);
//        }
//
//
//        return arr;
//    }

}
