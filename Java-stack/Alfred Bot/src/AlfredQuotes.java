import java.util.Date;
import java.text.SimpleDateFormat;
public class AlfredQuotes {

    public String basicGreeting() {
        return "Hello, lovely to see you. How are you?";
    }

    public String guestGreeting(String name) {
        return String.format("Hello %s, nice to see here",name);
    }
    public String guestGreeting(String name, String dayPeriod ) {
        return String.format("Hello %s, good %s.",name,dayPeriod);
    }
    public String guestGreeting() {
        Date date=new Date("DD,MM,YYYY");
        SimpleDateFormat x=new SimpleDateFormat("HH");
        int Hour=Integer.parseInt(x.format(date));
        String dayPeriod;
        if (Hour >= 4 && Hour < 12){
            dayPeriod="morning";
        }
        if (Hour >= 12 && Hour < 17){
            dayPeriod="afternoon";
        }
        if (Hour >= 17 && Hour < 21){
            dayPeriod="evening";
        }
        else dayPeriod="night";
        return String.format("Good %s, the  %s.",dayPeriod,date);
    }


    public String dateAnnouncement() {
        Date time =new Date();
        SimpleDateFormat f=new SimpleDateFormat("HH,mm,ss");

        return String.format("It is currently %s.",f.format(time));
    }

    public String respondBeforeAlexis(String conversation) {
        if(conversation.indexOf("Alexis")!=-1){

        return "Right away, sir. She certainly isn't sophisticated enough for that.";
        }
        if(conversation.indexOf("Alfred")!=-1){

        return  "At your service. As you wish, naturally.";
        }
        else return  "Right. And with that I shall retire.";

    }

    // NINJA BONUS
    // See the specs to overload the guestGreeting method
    // SENSEI BONUS
    // Write your own AlfredQuote method using any of the String methods you have learned!
}