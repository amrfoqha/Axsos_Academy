import java.util.HashMap;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

                HashMap<String, String> countryCapitals = new HashMap<String, String>();
                // Add five countries and capitals to the 'countryCapitals' map
        countryCapitals.put("Palestine","Jerusalem");
        countryCapitals.put("Jordan","Amman");
        countryCapitals.put("AlSaudiah","Jaddah");
        countryCapitals.put("Lebanon","Beirut");
        countryCapitals.put("Egypt","Alqhira");
                // Print all keys from the map
        Set<String>Countries=countryCapitals.keySet();
        for (String country:Countries){
            System.out.println(country);
        }
                // Print two countries and their capitals ('The capital of Oman is Muscat.')
        System.err.println("The Capital of Lebanon is :"+countryCapitals.get("Lebanon"));
        System.err.println("The Capital of Jordan is :"+countryCapitals.get("Jordan"));

    }
}