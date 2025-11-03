public class Gorilla extends Mammal{

    public void throwSomething(){
        super.energyLevel-=5;
        System.out.println("The gorilla has thrown something! (-5 energy)");
    }
    public void eatBananas(){
        super.energyLevel+=10;
        System.out.println("The gorilla eats bananas and feels satisfied! (+10 energy)");
    }
    public void climb() {
        super.energyLevel -= 10;
        System.out.println("The gorilla has climbed a tree! (-10 energy)");
    }

}