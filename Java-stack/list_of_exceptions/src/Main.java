
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<Object> myList = new ArrayList<Object>();
        myList.add("13");
        myList.add("hello world");
        myList.add(48);
        myList.add("Goodbye World");


        for (int i = 0; i < myList.size(); i++) {
            try {
                Integer CastValue=(Integer) myList.get(i);
            }
            catch (Exception e){
                System.out.println(String.format("error happened at index %d, where the value = %s",i,myList.get(i)));
            }
        }
    }
}