import java.util.HashMap;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        HashMap<String,String> trackList=new HashMap<String,String>();
        trackList.put("Someone Like You","Never Mind I'll find someone like you");
        trackList.put("Shape of You","I’m in love with the shape of you");
        trackList.put("Demons","This is my kingdom Come");
        trackList.put("Summertime Sadness","Summertime sadness");

        System.out.println(trackList.get("Demons"));
        trackList.forEach((s, s2) -> System.out.println("Title: "+s+"\t"+"| Lyrics: "+s2));

    }
}