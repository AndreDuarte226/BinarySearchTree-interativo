import java.util.Stack;

public class BinarySearchTree {

    private Node root;


    public void addNode(int value) {

        Node newNode = new Node(value);

        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (current != null) {
            parent = current;

            if (value < current.value) {
                current = current.left;
            } else if (value > current.value) {
                current = current.right;
            } else {
                return;
            }
        }

        if (value < parent.value) {
            parent.left = newNode;
        } else {
            parent.right = newNode;
        }
    }


    public void preOrder() {

        if (root == null) {
            System.out.println();
            return;
        }

        Stack<Node> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {

            Node current = stack.pop();

            System.out.print(current.value + " ");

            if (current.right != null) {
                stack.push(current.right);
            }

            if (current.left != null) {
                stack.push(current.left);
            }
        }

        System.out.println();
    }

    public void inOrder() {

        Stack<Node> stack = new Stack<>();
        Node current = root;

        while (current != null || !stack.isEmpty()) {

            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();

            System.out.print(current.value + " ");

            current = current.right;
        }

        System.out.println();
    }


    public void postOrder() {

        if (root == null) {
            System.out.println();
            return;
        }

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.push(root);

        while (!stack1.isEmpty()) {

            Node current = stack1.pop();

            stack2.push(current);

            if (current.left != null) {
                stack1.push(current.left);
            }

            if (current.right != null) {
                stack1.push(current.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().value + " ");
        }

        System.out.println();
    }

  
    public boolean deleteNode(int value) {

        Node parent = null;
        Node current = root;

   
        while (current != null && current.value != value) {

            parent = current;

            if (value < current.value) {
                current = current.left;
            } else {
                current = current.right;
            }
        }

   
        if (current == null) {
            return false;
        }

    
        if (current.left != null && current.right != null) {

            Node successorParent = current;
            Node successor = current.right;

         
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }

     
            current.value = successor.value;

    
            parent = successorParent;
            current = successor;
        }

        Node child;

        if (current.left != null) {
            child = current.left;
        } else {
            child = current.right;
        }


        if (parent == null) {
            root = child;
        } else if (parent.left == current) {
            parent.left = child;
        } else {
            parent.right = child;
        }

        return true;
    }
}
