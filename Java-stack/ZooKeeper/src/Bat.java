public class Bat extends Mammal{
    public  Bat(){
        super.energyLevel=300;
    }
    public void fly(){
        super.energyLevel-=50;
        System.out.println("the bat is flying");
    }
    public void eatHumans(){
        super.energyLevel+=25;
        System.out.println("the bat is eating human");
    }
    public void attackTown(){
        super.energyLevel-=100;
        System.out.println("the bat is attacking town");
    }
}
