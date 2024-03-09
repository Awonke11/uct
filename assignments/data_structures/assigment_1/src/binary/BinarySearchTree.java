package src.binary;

import src.Field;

/**
 * author:: Awonke Mnotoza
 * version:: 1.0.0
 * description:: Binary search tree with traversals
 */

public class BinarySearchTree {
    private Field root = null;
    private BinarySearchTree left = null;
    private BinarySearchTree right = null;

    /**
     * Constructs an empty BinarySearchTree.
     */
    public BinarySearchTree() {}

    /**
     * Constructs a BinarySearchTree with a specified root field.
     * <br />
     * Updates the root field of the binary search tree.
     *
     * @param root The Field object to be set as the root of the tree.
     */
    public BinarySearchTree(Field root) {
        this.root = root;
    }

    /**
     *  Right child<br />
     * Retrieves the right child of the current binary search tree.
     *
     * @return The right child of the current binary search tree.
     */
    public BinarySearchTree getRightChld() {
        return right;
    }

    /**
     *  Left child<br />
     * Retrieves the left child of the current binary search tree.
     *
     * @return The left child of the current binary search tree.
     */
    public BinarySearchTree getLeftChld() {
        return left;
    }

    /**
     *  Root<br />
     * Retrieves the root field of the current binary search tree.
     * <br />
     * The root is of type Field.
     * @see src.Field
     *
     * @return The right child of the current binary search tree.
     */
    public Field getRoot() {
        return root;
    }

    /**
     *  Insert fields<br />
     * Inserts an array of fields into the binary search tree.
     * @see src.Field
     *
     * @param fields An array of Field objects to be inserted into the tree.
     * @return The modified binary search tree after inserting the fields.
     */
    public BinarySearchTree insertFields(Field[] fields) {
        for (Field field : fields) {
            insertField(this, field);
        }
        return this;
    }

    /**
     *  Insert field<br />
     * Inserts a field into the binary search tree.
     * 
     * <h4>Time complexity:</h4>
     * ⌛ | O(logn)
     *
     * @param parent The parent node where the field will be inserted.
     * @param field The Field object to be inserted into the tree.
     * @see src.Field
     */
    public void insertField(BinarySearchTree parent, Field field) {
        Integer keyValue = field.getKey();

        if (parent.root == null) {
            parent.root = field;
            return;
        } 

        Integer rootKey = parent.root.getKey();
        if (keyValue > rootKey) {
            if (parent.right == null) {
                parent.right = new BinarySearchTree(field);
            } else {
                insertField(parent.right, field);
            }
        } else {
            if (parent.left == null) {
                parent.left = new BinarySearchTree(field);
            } else {
                insertField(parent.left, field);
            }
        }
    }

    /**
     *  Pre-Order Traverse<br />
     * Performs a pre-order traversal of the binary search tree and prints each node's key.
     *
     * @param tree The binary search tree to be traversed.
     */
    public void preTraverse(BinarySearchTree tree) {
        if (tree != null) {
            System.out.println(tree.root);
            preTraverse(tree.left);
            preTraverse(tree.right);
        } else {
            System.out.println("null");
        }
    }

    /**
     *  In-Order Traverse<br />
     * Performs an in-order traversal of the binary search tree and prints each node's key.
     *
     * @param tree The binary search tree to be traversed.
     */
    public void inTraverse(BinarySearchTree tree) {
        if (tree != null) {
            inTraverse(tree.left);
            System.out.println(tree.root);
            inTraverse(tree.right);
        } else {
            System.out.println("null");
        }
    }

    /**
     *  Post-Order Traverse<br />
     * Performs a post-order traversal of the binary search tree and prints each node's key.
     *
     * @param tree The binary search tree to be traversed.
     */
    public void postTraverse(BinarySearchTree tree) {
        if (tree != null) {
            postTraverse(tree.left);
            postTraverse(tree.right);
            System.out.println(tree.root);
        } else {
            System.out.println("null");
        }
    }

    /**
     *  Find Node<br />
     * Finds a node with a specific key in the binary search tree.
     *
     * @param key The key to search for.
     * @param tree The binary search tree to be searched.
     * @return The node with the specified key, or null if not found.
     */
    public BinarySearchTree findNode(Integer key, BinarySearchTree tree) {
        if (tree == null || tree.root == null) {
            return null;
        }
    
        Integer keyValue = tree.root.getKey();
        if (keyValue.equals(key)) {
            return tree;
        } else if (keyValue > key && tree.left != null) {
            return findNode(key, tree.left);
        } else if (keyValue < key && tree.right != null) {
            return findNode(key, tree.right);
        }
    
        return null;
    }

    /**
     *  Find Node with Sentence<br />
     * Finds a node with a specific key and sentence in the binary search tree.
     *
     * @param key The key to search for.
     * @param tree The binary search tree to be searched.
     * @param sentence The sentence to match.
     * @return The node with the specified key and sentence, or null if not found.
     */
    public BinarySearchTree findNode(Integer key, BinarySearchTree tree, String sentence) {
        if (tree == null || tree.root == null) {
            return null;
        }
    
        Integer keyValue = tree.root.getKey();
        String nodeSentence = tree.root.getSentence();
    
        if (keyValue.equals(key) && nodeSentence.equals(sentence)) {
            return tree;
        }
    
        if (keyValue > key && tree.left != null) {
            return findNode(key, tree.left, sentence);
        } else if (keyValue < key && tree.right != null) {
            return findNode(key, tree.right, sentence);
        }
    
        return null;
    }

    /**
     *  Update Field<br />
     * Updates a field in the binary search tree with a specified key.
     *
     * @param key The key of the field to be updated.
     * @param newField The new Field object to replace the existing field.
     */
    public void updateField(Integer key, Field newField) {
        BinarySearchTree nodeToUpdate = findNode(key, this);
        if (nodeToUpdate != null) {
            nodeToUpdate.root = new Field(nodeToUpdate.root.getTerm(), newField.getSentence(), newField.getConfidenceScore());
            updateWholeTree(nodeToUpdate);
        }
    }
    
    /**
     *  Update Whole Tree<br />
     * Updates the entire binary search tree starting from a specific node.
     * 
     * <h4>Note:</h4>
     * This methods updates the entire binary search tree after a field has been updated.
     *
     * @param tree The root node of the subtree to be updated.
     */
    private void updateWholeTree(BinarySearchTree tree) {
        if (tree != null) {
            updateWholeTree(tree.left);
            updateWholeTree(tree.right);
        }
    }

    /**
     *  Convert to string<br />
     * Overrides the toString method to generate a string representation of the binary search tree.
     * <br /><br />
     * For more information, see the <a href="https://docs.oracle.com/javase/8/docs/api/java/lang/Object.html#toString--">documentation</a>.
     *
     * @return A string representation of the binary search tree.
     */
    @Override
    public String toString() {
        return generateTreeString("");
    }

    private String generateTreeString(String indentation) {
        String formattedOutput = "";
        if (root != null) {
            formattedOutput += "Root: " + root.getKey() + "\n";

            if (left != null || right != null) {
                if (left != null) {
                    formattedOutput += indentation + "  Left: " + left.generateTreeString(indentation + " ");
                } else {
                    formattedOutput += indentation + "  Left: null\n";
                }

                if (right != null) {
                    formattedOutput += indentation + "  Right: " + right.generateTreeString(indentation + " ");
                } else {
                    formattedOutput += indentation + "  Right: null\n";
                }
            }
        } else {
            formattedOutput += "Root: null\n" + indentation + "  Left: null\n" + indentation + "  Right: null\n";
        }

        return formattedOutput;
    }

}
