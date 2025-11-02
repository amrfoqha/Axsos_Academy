import java.util.ArrayList;
import java.util.Scanner;

public class CoffeeKiosk {
    ArrayList<Item> menu;
    ArrayList<Order> orders;
    public CoffeeKiosk(){
        menu=new ArrayList<Item>();
        orders=new ArrayList<Order>();
    }
    public void addMenuItem(String name,double price){
        Item it=new Item(name,price);
        menu.add(it);
        it.index= menu.size()-1;
    }
    public void addMenuItem(){
        String name;
        double price;
        Scanner in =new Scanner(System.in);
        while(true){
            System.out.println("Please enter a item name and item price or q to quit:");
            System.out.print("Item name :");
            String input=in.nextLine();
            if (input.equalsIgnoreCase("q"))
                break;
            name=input;
            System.out.print("ITem price :");
            price=Double.parseDouble(in.nextLine());
            Item it=new Item(name,price);
            menu.add(it);
            it.index= menu.size()-1;
        }
    }
    public void displayMenu(){
        for(Item i:menu) System.out.println(i.index+" "+i.getName()+"--$"+i.getPrice());
    }

    public void newOrder(){
        String name;
        Scanner in =new Scanner(System.in);
        System.out.println("Please enter customer name for new order:");
        name=in.nextLine();
        Order order1=new Order(name);
        displayMenu();
        while (true){
        System.out.println("Please enter a menu item index or q to quit:");
        String itemNumber=in.nextLine();
            if (itemNumber.equalsIgnoreCase("q")) {
                break;
            }
            int index=Integer.parseInt(itemNumber);
            if(index>=0 && index <menu.size())
           order1.add(menu.get(index));
        }
        System.out.println(order1.toString());

    }
}
