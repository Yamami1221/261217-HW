public class Tree extends BTreePrinter{
    Node root;
      
    public Tree(Node root){
        this.root = root;
    }
    
    public void printTree(){
        if (root != null) {
            super.printTree(root);
        } else {
            System.out.println("Empty tree!!!");
        }
    }

    public Node find(int search_key){
        return find(root, search_key);
    }
    
    public static Node find(Node node, int search_key){
        if (node == null) {
            System.out.println("Key not found!!!");
            return null;
        }
        if (node.key == search_key) {
            return node;
        } else if (search_key < node.key) {
            return find(node.left, search_key);
        } else {
            return find(node.right, search_key);
        }
    }
    
    public Node findMin(){
        return findMin(root);
    }
    
    public static Node findMin(Node node){
        if (node == null) {
            return null;
        }
        if (node.left != null) {
            return findMin(node.left);
        } else {
            return node;
        }
    }
    
    public Node findMax(){
        return findMax(root);
    }
    
    public static Node findMax(Node node){
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return findMax(node.right);
        } else {
            return node;
        }
    }
    
    public Node findClosestLeaf(int search_key){
        return findClosestLeaf(root, search_key);
    }
    
    public static Node findClosestLeaf(Node node, int search_key){
        if (search_key < node.key && node.left != null) {
            return findClosestLeaf(node.left, search_key);
        } else if (search_key > node.key && node.right != null) {
            return findClosestLeaf(node.right, search_key);
        } else {
            return node;
        }
    }
    
    public Node findClosest(int search_key){
        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;
        
        // Use while loop to traverse from root to the closest leaf
        while (current != null || current != null) {
            if (search_key == current.key) {
                closest = current;
                break;
            } else if (Math.abs(search_key - current.key) < min_diff) {
                min_diff = Math.abs(search_key - current.key);
                closest = current;
            }
            if (search_key < current.key) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        
        return closest;
    }
    
    public void insert(int key) {
        if (root == null) {
            root = new Node(key);
            return;
        }
        Node closest = findClosestLeaf(root, key);
        if (closest.key == key) {
            System.out.println("Duplicated key!!!");
        } else if (closest.key > key) {
            closest.left = new Node(key);
        } else {
            closest.right = new Node(key);
        }
    }
    
    public void printPreOrderDFT(){
        System.out.print("PreOrder DFT node sequence [ ");
        printPreOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPreOrderDFT(Node node){
        if (node == null) return;
        System.out.print(node.key + " ");
        printPreOrderDFT(node.left);
        printPreOrderDFT(node.right);
    }
    
    public void printInOrderDFT(){
        System.out.print("InOrder DFT node sequence [ ");
        printInOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printInOrderDFT(Node node){
        if (node == null) return;
        printInOrderDFT(node.left);
        System.out.print(node.key + " ");
        printInOrderDFT(node.right);
    }
    
    public void printPostOrderDFT(){
        System.out.print("PostOrder DFT node sequence [ ");
        printPostOrderDFT(root);
        System.out.println("]");
    }
    
    public static void printPostOrderDFT(Node node){
        if (node == null) return;
        printPostOrderDFT(node.left);
        printPostOrderDFT(node.right);
        System.out.print(node.key + " ");
    }

    public static int height(Node node){
        if (node == null) return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }
    
    public static int size(Node node){
        if (node == null) return 0;
        return size(node.left) + size(node.right) + 1;
    }
    
    public static int depth(Node root, Node node){
        if (node == root) return 0;
        return 1 + depth(root, node.parent);
    }
    
    public int height(){
        return height(root);
    }
    
    public int size(){
        return size(root);
    }
    
    public int depth(){
        return height(root);
    }
    
    public Node findKthSmallest(int k){
        return findKthSmallest(root, k);
    }
    
    public static Node findKthSmallest(Node node, int k){
        if (size(node.left) + 1 == k) return node;
        else if (size(node.left) + 1 > k) return findKthSmallest(node.left, k);
        else return findKthSmallest(node.right, k - size(node.left) - 1);
    }

    public static Node findNext(Node node){
        if (node.right != null) {
            return leftDescendant(node.right);
        } else {
            return rightAncestor(node);
        }
    }
    
    public static Node leftDescendant(Node node) {
        if (node.left == null) return node;
        else return leftDescendant(node.left);
    }
    
    public static Node rightAncestor(Node node) {
        if (node.parent == null) return null;
        if (node.parent.left == node) return node.parent;
        else return rightAncestor(node.parent);
    }
    
    public List rangeSearch(int x, int y){
        List list = new List(100);
        Node current = findClosest(x);
        if (current.key < x) current = findNext(current);
        while (current != null && current.key <= y) {
            list.append(current);
            current = findNext(current);
        }
        return list;
    }

    public void delete(int key) {
        if (root == null) {
            System.out.println("Empty Tree!!!");
            return;
        }
        Node found = find(root, key);
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
                rightMin.parent = null;
                rightMin.right = root.right;
                rightMin.left = root.left;
                if (root.right != null) root.right.parent = rightMin;
                root.left.parent = rightMin;
                root = rightMin;
            }
        } else {
            delete(found);
        }
    }
    
    public static void delete(Node node){
        // There should be 7 cases here
        if (node.left == null && node.right == null) {
            if (node.parent.left == node) {
                node.parent.left = null;
            } else if (node.parent.right == node) {
                node.parent.right = null;
            }
            node.parent = null;
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
            if (rightMin.parent.right == rightMin) rightMin.parent.right = null;
            else if (rightMin.parent.left == rightMin) rightMin.parent.left = null;
            rightMin.parent = node.parent;
            rightMin.right = node.right;
            rightMin.left = node.left;
            if (node.right != null) node.right.parent = rightMin;
            node.left.parent = rightMin;
        }
    }
    
    // Print node's key
    public static void printNode(Node node){
        if (node == null) return;
        System.out.println(node.key);
    }
    
    public Tree(){} // Dummy constructor (No need to edit)
}