import java.util.HashMap;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        HashMap<Integer,String> trackList=new HashMap<Integer,String>();
        trackList.put(111,"amr");
        trackList.put(123,"ahmad");
        trackList.put(333,"ameer");
        trackList.forEach((s, s2) -> System.out.println(s+" "+s2));

    }
}