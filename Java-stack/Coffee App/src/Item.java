public class Item {
    private String name;
    private double price;
    int index;

    public Item(String name, double price) {
        this.price = price;
        this.name = name;
    }


    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }


}
