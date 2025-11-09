public class BSTTest {
    public static void main(String[] args){
        BST tree=new BST();
        tree.insert(100);
        tree.insert(120);
        tree.insert(105);
        tree.insert(135);
        tree.insert(95);
        tree.insert(90);
        tree.insert(85);

        tree.printTree(tree.root);

    }
}
