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
        return "Order{" +
                "name='" + name + '\'' +
                ", total=" + total +
                ", ready=" + ready +
                ", items=" + items +
                '}';
    }
}
