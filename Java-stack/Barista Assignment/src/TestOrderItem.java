public class TestOrderItem {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Order order1=new Order();
        Order order2=new Order();
        Order order3=new Order("ahmad");
        Order order4=new Order("amr");
        Order order5=new Order("ameer");

        Item item1=new Item("coffee",3.2);
        Item item2=new Item("latte",2.1);
        Item item3=new Item("mojitoXl",5.9);
        Item item4=new Item("BlueAngle",7.2);
        Item item5=new Item("IceCoffee",5.2);
        Item item6=new Item("IceTea",9.2);
        Item item7=new Item("HotChocolate",7.2);
        Item item8=new Item("MilkShakeOreo",7.5);
        Item item9=new Item("MilkShakeLouts",7.5);
        Item item10=new Item("SpanishLatte",6.3);

        order1.addItem(item1);
        order1.addItem(item2);
        order2.addItem(item3);
        order2.addItem(item4);
        order3.addItem(item5);
        order3.addItem(item6);
        order4.addItem(item7);
        order4.addItem(item8);
        order5.addItem(item9);
        order5.addItem(item10);
        order5.addItem(item3);
        order5.addItem(item4);
        order5.addItem(item5);

        order5.setIsReady(true);
        order5.getStatusMessage();
        order5.display();
        order4.display();
        order3.display();
        order2.display();
        order1.display();



    }
}