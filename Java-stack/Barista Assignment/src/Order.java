import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean isReady;
    private ArrayList<Item> items;

    public Order() {
        this.name="Guest";
        this.items=new ArrayList<Item>();
        this.total=0.0;
        this.isReady=false;
    }

    public Order(String name) {
        this.name = name;
        this.items=new ArrayList<Item>();
        this.total=0.0;
        this.isReady=false;
    }

    public void addItem(Item item){
//        Item newitem=new Item(name,price);
//        this.items.add(item);
        this.items.add(item);
        this.total+=item.getPrice();
    }

    public void setName(String name){
        this.name=name;
    }
    public void setIsReady(boolean isReady){
        this.isReady=isReady;
    }
    public String getName(){
        return  this.name;
    }
    public boolean getIsReady(){
        return this.isReady;
    }
    public double getOrderTotal(){
        return this.total;
    }

    public void getStatusMessage(){
        System.out.print("Dear "+getName()+" ");
        if(getIsReady())
            System.out.println("The order is ready");

        else System.out.println("Your order still need time");
    }
    public void display(){
        System.out.println("Customer name: "+getName());
        for(Item item:items){
            System.out.println(item.getName()+" - $"+item.getPrice());
        }
        System.out.println("Total: "+getOrderTotal());
    }

}
