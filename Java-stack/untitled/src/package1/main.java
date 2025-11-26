package package1;

public class main {
    public static void main(String[] args){

    LinkedList lls=new LinkedList();
    lls.addAtIndex(0,1);
    lls.addAtIndex(1,2);
    lls.addAtIndex(2,3);
    lls.addAtIndex(3,4);
    lls.print();
    lls.reverse();
        System.out.println();
    lls.print();
        System.out.println();
//        lls.printReverse();
        for (int i=0;i<10;i++){
            if (i%2==0) System.out.println("even number "+i);
            else System.out.println("odd number "+i);
        }


    }
}
