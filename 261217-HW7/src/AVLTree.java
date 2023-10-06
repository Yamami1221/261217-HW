public class AVLTree extends BTreePrinter {
    Node root;

    public void singleRotateFromLeft(Node y) {
        Node x = y.left;
        Node w = y.parent;
        if (x == null) return;
        if (w != null) {
            y.left = x.right;
            if (y.left != null) y.left.parent = y;
            x.right = y;
            y.parent = x;
            if (w.left == y) w.left = x;
            else if (w.right == y) w.right = x;
            x.parent = w;
        } else {
            y.left = x.right;
            if (y.left != null) y.left.parent = y;
            x.right = y;
            y.parent = x;
            root = x;
            x.parent = null;
        }
    }

    public void singleRotateFromRight(Node y) {
        Node x = y.right;
        Node w = y.parent;
        if (x == null) return;
        if (w != null) {
            y.right = x.left;
            if (y.right != null) y.right.parent = y;
            x.left = y;
            y.parent = x;
            if (w.left == y) w.left = x;
            else if (w.right == y) w.right = x;
            x.parent = w;
        } else {
            y.right = x.left;
            if (y.right != null) y.left.parent = y;
            x.left = y;
            y.parent = x;
            root = x;
            x.parent = null;
        }
    }

    public void doubleRotateFromLeft(Node y) {
        Node w = y.parent;
        Node x = y.left;
        if (x == null) return;
        Node z = x.right;
        if (z == null) return;
        x.right = z.left;
        if (x.right != null) x.right.parent = x;
        y.left = z.right;
        if (y.left != null) y.left.parent = y;
        z.left = x;
        z.left.parent = z;
        z.right = y;
        z.right.parent = z;
        if (w == null) {
            root = z;
            z.parent = null;
        } else {
            if (w.left == y) {
                w.left = z;
                z.parent = w;
            } else if (w.right == y) {
                w.right = z;
                z.parent = w;
            }
        }
    }

    public void doubleRotateFromRight(Node y) {
        Node w = y.parent;
        Node x = y.right;
        if (x == null) return;
        Node z = x.left;
        if (z == null) return;
        x.left = z.right;
        if (x.left != null) x.left.parent = x;
        y.right = z.left;
        if (y.right != null) y.right.parent = y;
        z.left = y;
        z.left.parent = z;
        z.right = x;
        z.right.parent = z;
        if (w == null) {
            root = z;
            z.parent = null;
        } else {
            if (w.left == y) {
                w.left = z;
                z.parent = w;
            } else if (w.right == y) {
                w.right = z;
                z.parent = w;
            }
        }
    }

    public static void rebalance(AVLTree tree, Node node){
        int balanceFactor = height(node.left) - height(node.right);
        if (balanceFactor > 1 || balanceFactor < -1) {
            if (balanceFactor > 1) {
                if (height(node.left.left) > height(node.left.right)) {
                    System.out.println("Perform SingleRotationFromLeft(Node " + node.key + ")");
                    tree.singleRotateFromLeft(node);
                    rebalance(tree, node.parent);
                } else {
                    System.out.println("Perform DoubleRotationFromLeft(Node " + node.key + ")");
                    tree.doubleRotateFromLeft(node);
                    rebalance(tree, node.parent);
                }
            } else {
                if (height(node.right.right) > height(node.right.left)) {
                    System.out.println("Perform SingleRotationFromRight(Node " + node.key + ")");
                    tree.singleRotateFromRight(node);
                    rebalance(tree, node.parent);
                } else {
                    System.out.println("Perform DoubleRotationFromRight(Node " + node.key + ")");
                    tree.doubleRotateFromRight(node);
                    rebalance(tree, node.parent);
                }
            }
        }
    }
    
    // Fix this function to have the rebalancing feature
    // There should be rebalance() function calling somewhere in the code
    public static void insert(AVLTree tree, Node node, int key) {
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        }else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            }else {
                insert(tree, node.left, key);
            }
        }else{  // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
            }else {
                insert(tree, node.right, key);
            }
        }
        rebalance(tree, node);
    }
    
    // This function is complete, no need to edit
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insert(this, root, key);
        }
    }
    
    // This function is complete, no need to edit
    public Node find(int search_key) {
        return Main.find(root, search_key);
    }

    // Use this function to check the node height
    // This function is complete, no need to edit
    public static int height(Node node){
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }

    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
            return;
        }
        Node found = find(key);
        if (found == null) {
            return;
        }
        if (found == root) {
            if (root.left == null && root.right == null) root = null;
            else if (root.left != null && root.right == null) root = root.left;
            else if (root.left == null && root.right != null) root = root.right;
            else {
                Node rightMin = findMin(root.right);
                if (rightMin.parent.right == rightMin) {
                    rightMin.parent.right = null;
                } else if (rightMin.parent.left == rightMin) {
                    rightMin.parent.left = null;
                }
                Node oldParent = rightMin.parent;
                rightMin.parent = null;
                rightMin.right = root.right;
                rightMin.left = root.left;
                if (root.right != null) root.right.parent = rightMin;
                root.left.parent = rightMin;
                root = rightMin;
                while (oldParent != null) {
                    rebalance(this, oldParent);
                    oldParent = oldParent.parent;
                }
            }
        } else {
            delete(this, found);
        }
    }
    
    // Use this function to delete non-root nodes
    // Also, fix the code to have the rebalancing feature
    public static void delete(AVLTree tree, Node node){
        if (node.left == null && node.right == null) {
            if (node.parent.left == node) {
                node.parent.left = null;
            } else if (node.parent.right == node) {
                node.parent.right = null;
            }
        } else if (node.left != null && node.right == null) {
            if (node.parent.left == node) {
                node.parent.left = node.left;
                node.left.parent = node.parent;
            } else if (node.parent.right == node) {
                node.parent.right = node.left;
                node.left.parent = node.parent;
            }
        } else if (node.left == null && node.right != null) {
            if (node.parent.left == node) {
                node.parent.left = node.right;
                node.right.parent = node.parent;
            } else if (node.parent.right == node) {
                node.parent.right = node.right;
                node.right.parent = node.parent;
            }
        } else {
            Node rightMin = findMin(node.right);
            if (node.parent.right == node) node.parent.right = rightMin;
            else if (node.parent.left == node) node.parent.left = rightMin;
            Node oldParent = rightMin.parent;
            if (rightMin.parent.right == rightMin) rightMin.parent.right = null;
            else if (rightMin.parent.left == rightMin) rightMin.parent.left = null;
            rightMin.parent = node.parent;
            rightMin.right = node.right;
            rightMin.left = node.left;
            if (node.right != null) node.right.parent = rightMin;
            node.left.parent = rightMin;
            node = oldParent;
        }
        while (node != null) {
            rebalance(tree, node);
            node = node.parent;
        }
    }

    // This function is complete, no need to edit
    public static Node findMin(Node node){
        if (node.left == null)
            return node;
        else
            return findMin(node.left);
    }

    public static Node findMax(Node node){ //ใช้ recursionในการหา โดยใช้ค้นไปทางด้านขวาสุดของต้นไม้ เพราะว่าเป็น binary search tree เเล้ว(จัดเรียงค่า)ถ้าเจอก็เเสดงค่า node นั้นออกมา
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findMax(node.right);
        } else {
            return node;
        }
    }

    public static boolean isMergeable(Node r1, Node r2){
        return findMax(r1).key < findMin(r2).key;
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t){
        if (isMergeable(r1, r2)) {
            t.left = r1;
            t.left.parent = t;
            t.right = r2;
            t.right.parent = t;
            return t;
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }

    public static void delete(Node node){
        // There should be 7 cases here
        if (node.left == null && node.right == null) { // if don't have any child
            if (node.parent.left == node) { // if is left child
                node.parent.left = null;
            } else if (node.parent.right == node) { // if is right child
                node.parent.right = null;
            }
            node.parent = null;
        } else if (node.left != null && node.right == null) { // if have left child
            if (node.parent.left == node) { // if is left child
                node.parent.left = node.left; // 
                node.left.parent = node.parent;
            } else if (node.parent.right == node) { // if is right child
                node.parent.right = node.left;
                node.left.parent = node.parent;
            }
        } else if (node.left == null && node.right != null) { // if have right child
            if (node.parent.left == node) { // if is left child
                node.parent.left = node.right;
                node.right.parent = node.parent;
            } else if (node.parent.right == node) { // if is right child
                node.parent.right = node.right;
                node.right.parent = node.parent;
            }
        } else { // find min of right sub-tree and replace node with min
            Node rightMin = findMin(node.right);
            if (node.parent.right == node) node.parent.right = rightMin;
            else if (node.parent.left == node) node.parent.left = rightMin;
            if (rightMin.parent.right == rightMin) rightMin.parent.right = null;
            else if (rightMin.parent.left == rightMin) rightMin.parent.left = null;
            rightMin.parent = node.parent;
            rightMin.right = node.right;
            rightMin.left = node.left;
            if (node.right != null) node.right.parent = rightMin;
            node.left.parent = rightMin;
        }
    }
    
    
    public void merge(BSTree tree2){
        if (isMergeable(this.root, tree2.root)){
            Node max = findMax(this.root);
            delete(max);
            this.root = mergeWithRoot(this.root, tree2.root, max);
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
        }
    }
}