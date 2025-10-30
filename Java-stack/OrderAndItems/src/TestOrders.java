public class TestOrders {

    public static void main(String[] args){
        Item item1 = new Item("mocha", 19.99);
        Item item2 = new Item("latte", 29.99);
        Item item3 = new Item("drip coffee", 39.99);
        Item item4 = new Item("cappuccino", 49.99);

        Order order1 = new Order("Rami");
//        order1.add(item1);
        Order order2 = new Order("Jimmy");
        Order order3 = new Order("Noah");
        Order order4 = new Order("Sam");
        order2.add(item1);
        System.out.println(order2.getTotal());
        order3.add(item4);
        order4.add(item2);
        order1.setReady(true);
        order4.add(item2);
        order4.add(item2);
        order2.setReady(true);

    }

}
