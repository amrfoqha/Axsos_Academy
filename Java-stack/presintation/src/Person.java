import com.sun.source.tree.BreakTree;

import java.lang.String;
import java.util.ArrayList;

public class Person {
    public int age;

    public String name;
    public String id;

    static ArrayList<Person> arr=new ArrayList<Person>();


    public Person() {
//        person(10,"name","123hs");
        this(10,"warrior player","123d2d");
        System.out.println("a instance of call has been instantiated");
    }

    public Person(int age, String name, String id) {
        this.age = age;
        this.name = name;
        this.id = id;
    }

    public void addPerson(){
        arr.add(this);
    }
    public void printDetails(){
        System.out.println("name= "+name+"\nage= " + age+"\nPID= "+id);
    }


}
