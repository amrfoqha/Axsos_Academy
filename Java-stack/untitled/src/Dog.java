public class Dog extends Animal {

    private String type;
    private double weight;

    public Dog(java.lang.String name, int age, java.lang.String type, double weight) {
        super(name, age);
        this.type = type;
        this.weight = weight;
    }
    @Override
    public void makeSound(){
        System.out.println("Dog make a sound");
    }

    public void setType(String type){
        this.type=type;
    }
    public String getType(){
        return this.type;
    }

    public void setWeight(double weight){
        this.weight=weight;
    }
    public double getWeight(){
        return this.weight;
    }
}
