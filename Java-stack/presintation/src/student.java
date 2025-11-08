public class student extends Person {
    int SID;
    String grade;

    public student(int SID, String grade,int age,String name,String id) {
        super(age,name,id);
        this.SID = SID;
        this.grade = grade;
    }

    public student(int age, String name, String id, int SID, String grade) {
        super(age, name, id);
        this.SID = SID;
        this.grade = grade;
    }

    public void printDetails(){
        super.printDetails();
        System.out.println("SID= "+SID+"\ngrade= "+grade);
    }
}
