public class ZooKeeper {
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Gorilla Test");
        Gorilla g=new Gorilla();
        g.throwSomething();
        g.throwSomething();
        g.throwSomething();
        g.eatBananas();
        g.eatBananas();
        g.climb();
        g.displayEnergy();
        System.out.println("Bat test");

        Bat b=new Bat();
        b.attackTown();
        b.attackTown();
        b.eatHumans();
        b.eatHumans();
        b.fly();
        b.fly();
        b.displayEnergy();
    }
}