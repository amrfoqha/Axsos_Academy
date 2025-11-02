import java.util.ArrayList;

public class Order {
    private String name;
    private double total;
    private boolean ready;
    public ArrayList<Item> items;

    public Order(String name) {
        this.name = name;
        this.total = 0.0;
        this.ready = false;
        this.items = new ArrayList<>();
    }

    public void setReady(boolean ready) {
        this.ready = ready;
    }

    public double getTotal(){
        return this.total;
    }

    public void add(Item item){
        this.items.add(item);
        this.total += item.getPrice();
    }

    @Override
    public String toString() {
        String output= "Order{\n" +
                "name=" + name + '\n' +
                "total=" + total + '\n'+
                "ready=" + ready + '\n'+
                "items=\n" ;

        for(Item i : items) {
            output = output.concat(String.format(" %s - %f \n",i.getName(),i.getPrice()));
        }
        output+= '\n'+"}";

    return output;
    }
}
