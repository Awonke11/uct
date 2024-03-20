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


}