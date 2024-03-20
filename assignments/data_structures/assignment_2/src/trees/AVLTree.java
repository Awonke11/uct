public class AVLTree<DataType> {
    private DataType root = null;
    private AVLTree<DataType> left = null;
    private AVLTree<DataType> right = null;

    /** 
     * General constructor with no arguments
    */
    public AVLTree() {}

    /**
     * Constructor function that initializes the root
     * @param root The defined root to initialize the tree
     */
    public AVLTree(DataType root) {
        this.root = root;
    }

    /**
     * This method will return the left child from the node
     * @return the left child
     */
    public AVLTree<DataType> getLeftChild() {
        return this.left;
    } 

    /**
     * This method will return the right child from the node
     * @return the right child
     */
    public AVLTree<DataType> getRightChild() {
        return this.right;
    } 

    /**
     * This gives returns the height of the root
     * @return the root node height
     */
    public int getTreeHeight(AVLTree<DataType> node) {
        if (node.root == null) {
            return -1;
        }
        return 1 + Math.max(getTreeHeight(node.left) + getTreeHeight(node.right), 0);
    }

    /**
     * This method calculated the balance factor of the root node.
     * 
     * The formula: 
     * balance_factor = height_of_left_subtree - height_of_right_subtree
     * @return the balance factor
     */
    public int balanceFactor(AVLTree<DataType> node) {
        return (this.getTreeHeight(node.left) - this.getTreeHeight(node.right));
    }

    public AVLTree<DataType> leftRotation(AVLTree<DataType> node) {
        AVLTree<DataType> temp = node.left;
    
        // Apply rotation
        node.right = temp.left;
        temp.left = node;

        return temp;
    }

}