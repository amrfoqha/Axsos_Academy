public class Phone extends Device {


     private void checkBattery(){
        if(super.battery<10)
            System.err.println("the battery is low %"+super.battery+"\n please charge the phone");
     }


    public void makeACall(){
        super.battery-=5;
        System.out.println("this phone make an call\n The remaining battery level %"+super.battery);
        checkBattery();
    }
    public void playAGame(){
         if(super.battery<25) System.err.println("You can't play a game \nyour battery below %25");
       else {
           super.battery-=20;
        System.out.println("Game is running on this phone\n The remaining battery level %"+super.battery);
        checkBattery();
         }
     }
    public void charge(){
            super.battery+=50;
            System.out.println("this phone is charging\n  The remaining battery level %"+super.battery);
    }

}
