public class BST {
    Node root;

    public BST() {
        this.root = null;
    }
    public void insert(int val){
        Node newnode=new Node(val);
        if(this.root==null){
            this.root=newnode;
        }
        else
            this.insertNode(root,newnode);
        }


    private void insertNode(Node root, Node newnode) {
        if (newnode.val > root.val) {
            if (root.right == null) {
                root.right=newnode;
            }
            else insertNode(root.right,newnode);
        }
        else {
            if (root.left == null) {
                root.left=newnode;
            }
            else insertNode(root.left,newnode);
        }
    }

    public void printTree(Node root){
        if (root==null)return;
        System.out.println(root.val);
        if (root.right != null) {
            printTree(root.right);
        }
        if (root.left != null) {
            printTree(root.left);
        }

    }
}
