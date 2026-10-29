public class Main {

    public static void main(String[] args) {

        BinarySearchTree tree = new BinarySearchTree();


        tree.addNode(10);
        tree.addNode(5);
        tree.addNode(15);
        tree.addNode(3);
        tree.addNode(7);
        tree.addNode(12);
        tree.addNode(20);
        tree.addNode(9);
        tree.addNode(22);
        tree.addNode(13);
        tree.addNode(40);
        tree.addNode(29);
        tree.addNode(19);

        System.out.println("Pre-ordem:");
        tree.preOrder();

        System.out.println("Em-ordem:");
        tree.inOrder();

        System.out.println("Pos-ordem:");
        tree.postOrder();


        System.out.println("\nExcluindo o no 15...");

        if (tree.deleteNode(15)) {
            System.out.println("No excluido com sucesso!");
        } else {
            System.out.println("No nao encontrado!");
        }

        System.out.println("\nArvore apos a exclusao:");

        System.out.println("Pre-ordem:");
        tree.preOrder();

        System.out.println("Em-ordem:");
        tree.inOrder();

        System.out.println("Pos-ordem:");
        tree.postOrder();
    }
}
