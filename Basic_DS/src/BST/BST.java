package BST;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import Stack.DynamicStack;

public class BST<T extends Comparable<T>> {

    static class Node<T> {
        private T data;
        private Node<T> left;
        private Node<T> right;
        private boolean visited;

        public Node(T data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.visited = false;
        }

    }

    private Node<T> root;

    public BST() {
        this.root = null;
    }

    public boolean isBSTEmpty() {
        return (root == null);
    }

    public void addNode(T data) {// Non recursive
        Node<T> newNode = new Node<T>(data);
        if (isBSTEmpty()) {
            root = newNode;
        } else {
            Node<T> trav = root;
            while (true) {
                if (data.compareTo(trav.data) < 0) {
                    if (trav.left == null) {// traverse till end of tree
                        trav.left = newNode;
                        break; // get out of loop when element added
                    } else {
                        trav = trav.left;// increment
                    }
                } else {
                    if (trav.right == null) {
                        trav.right = newNode;
                        break;
                    } else
                        trav = trav.right;
                }

            }

        }
    }

    public void recAddNode(T data, Node<T> trav) {
        if (trav == null)
            return;
        else {

            if (data.compareTo(trav.data) < 0) {
                if (trav.left == null)
                    trav.left = new Node<T>(data);
                else
                    recAddNode(data, trav.left);
            } else {
                if (trav.right == null)
                    trav.right = new Node<T>(data);
                else
                    recAddNode(data, trav.right);
            }
        }
    }

    public void recAddNode(T data) {// wrapper method since every time new base node(trav) has to be passed to
                                    // method
        // if BST is empty then a create a newnode and attach it to the root
        if (isBSTEmpty()) {
            root = new Node<T>(data);
        } else {// if BST is not empty
            recAddNode(data, root);// initialization
        }
    }

    public void preOrder(Node<T> trav) {
        // base condition
        if (trav == null)
            return;

        // VLR
        System.out.printf("%4d", trav.data);// visit data of cur node
        preOrder(trav.left);// goto visit its left subtree
        preOrder(trav.right);// goto visit its right subtree
    }

    public void preOrder() {
        if (!isBSTEmpty()) {
            System.out.print("preorder traversal is : ");
            ;
            preOrder(root);// initialization
            System.out.println();
        } else
            System.out.println("bst is empty !!!");
    }

    public void inOrder(Node<T> trav) {
        // base condition
        if (trav == null)
            return;

        // LVR
        inOrder(trav.left);// goto visit its left subtree
        System.out.printf("%4d", trav.data);// visit data of cur node
        inOrder(trav.right);// goto visit its right subtree
    }

    public void inOrder() {
        if (!isBSTEmpty()) {
            System.out.print("inorder traversal is  : ");
            ;
            inOrder(root);// initialization
            System.out.println();
        } else
            System.out.println("bst is empty !!!");
    }

    public void postOrder(Node<T> trav) {
        // base condition
        if (trav == null)
            return;

        // LRV
        postOrder(trav.left);// goto visit its left subtree
        postOrder(trav.right);// goto visit its right subtree
        System.out.printf("%4d", trav.data);// visit data of cur node
    }

    public void postOrder() {
        if (!isBSTEmpty()) {
            System.out.print("postorder traversal is: ");
            ;
            postOrder(root);// initialization
            System.out.println();
        } else
            System.out.println("bst is empty !!!");
    }

    // for non recursive DSF order just store nodes which you are leaving behine in
    // stack
    public void nonRecInorder() {

        if (!isBSTEmpty()) {
            DynamicStack<Node<T>> stack = new DynamicStack<>(); // stack is used to store nodes temporarily to fetch
                                                                // later at req time
            Node<T> trav = root;
            System.out.print("Inorder traversal is : ");
            while (trav != null || !stack.isStackEmpty()) {// traverse till end and push required nodes into stack
                while (trav != null) {
                    stack.push(trav); // becasue we will need to fetch root nodes after we finish all left nodes
                    trav = trav.left;
                } // reached at end of left....now we have stack with nodes to go back
                if (!stack.isStackEmpty()) {
                    trav = stack.pop(); // last left node will be poped first and printed
                    System.out.printf("%4d", trav.data.toString());
                    trav = trav.right; // and then goto right branch(at first it will be null )
                                       // and loop will continue to pop elements from stack.
                }

            }
            System.out.println();
        } else {
            System.out.println("bst is empty !!!");
        }
    }

    public void nonRecPreOrder() {
        if (!isBSTEmpty()) {
            DynamicStack<Node<T>> stack = new DynamicStack<>();
            Node<T> trav = root;
            System.out.print("preorder traversal is : ");
            while (trav != null || !stack.isStackEmpty()) {
                while (trav != null) {
                    System.out.println(trav.data.toString());
                    if (trav.right != null) {
                        stack.push(trav.right);
                    }
                    trav = trav.left;
                }
                if (!stack.isStackEmpty()) {
                    trav = stack.pop();
                    // trav = trav.right; -- not needed as we are goig to save right nodes in
                    // previous while loop
                }
            }

        } else {
            System.out.println("bst is empty !!!");
        }

    }

    public void nonRecPostOrder() {
        if (!isBSTEmpty()) {
            DynamicStack<Node<T>> stack = new DynamicStack<>();
            Node<T> trav = root;

            while (trav != null || !stack.isStackEmpty()) {
                while (trav != null) {
                    stack.push(trav);

                    trav = trav.left;
                }

                if (!stack.isStackEmpty()) {
                    trav = stack.pop();
                    if (trav.right != null && trav.right.visited == false) {
                        stack.push(trav);
                        trav = trav.right;
                    } else {
                        System.out.println(trav.data.toString());
                        trav.visited = true;
                        trav = null; // since this node has been fetched and to pop next node from stack
                    }

                }
            }
            System.out.println();
        } else {
            System.out.println("bst is empty !!!");
        }
    }

    public void dfsTraversal() { // similar to preorder
        if (!isBSTEmpty()) {
            DynamicStack<Node<T>> stack = new DynamicStack<>();
            Node<T> trav = root;
            stack.push(trav);

            while (!stack.isStackEmpty()) {
                trav = stack.pop();
                System.out.println(trav.data);

                if (trav.right != null) {
                    stack.push(trav.right); // pushed right first so that we ca pop it after left is poped
                }
                if (trav.left != null) {
                    stack.push(trav.left);
                }

            }
            System.out.println();

        } else {
            System.out.println("bst is empty !!!");
        }
    }

    public void bfsTraversal() {// same as dfs queue instead of stack
        if (!isBSTEmpty()) {
            Queue<Node<T>> q = new LinkedList<Node<T>>();
            // step-1: push root node into the queue
            q.offer(root);// enqueue
            System.out.print("bfs traversal is : ");
            while (!q.isEmpty()) {
                // step-2: pop the node from the queue and visit it
                Node<T> trav = q.poll();// dequeue
                System.out.printf("%4d", trav.data);

                // step-3: if cur node is having left child push it into the queue
                if (trav.left != null)
                    q.offer(trav.left);

                // step-4: if cur node is having right child push it into the queue
                if (trav.right != null)
                    q.offer(trav.right);

            } // step-5: repeat step-2, step-3 & step-4 till queue is not empty
            System.out.println();
        } else
            System.out.println("bst is empty !!!");
    }

    public boolean searchNode(T data, List<Node<T>> list) {

        Node<T> trav = root;

        list.add(0, null);// parent node

        while (trav != null) {
            if (data.equals(trav.data)) {
                list.add(1, trav); // node found
                return true;
            }

            list.add(0, trav);
            if (data.compareTo(trav.data) < 0) { // if less search in left
                trav = trav.left;
            } else {
                trav = trav.right;
            }
        }
        list.add(0, null); // node not found then make 0th element null

        return false;

    }

    public boolean deleteNode(T data) {
        List<Node<T>> list = new ArrayList<>();
        if (!searchNode(data, list)) {
            return false;
        }
        // after calling search method we have parent and node top deleted in list
        Node<T> temp = list.get(0);
        Node<T> parent = list.get(1);
        if (parent == null)
            System.out.println("node is found at root position => temp.data : " + temp.data);
        else
            System.out.println("parent.data : " + parent.data + "\ttemp.data : " + temp.data);

        // CASE - 1....................................................................
        if (temp.left != null && temp.right != null) {
            // get an addr of an inorder succ of node which we want to delete
            // usually inorder successer node will be found at leftmost node of right branch
            // of that node
            // hence
            Node<T> succ = temp.right;
            parent = temp;
            while (succ.left != null) {
                parent = succ;
                succ = succ.left;
            }
            // replace data part of temp by data part of succ
            temp.data = succ.data;
            // assign succ as a temp which is to be deleted now
            temp = succ;
        }

        // CASE - 2....................................................................
        // if node which is to be deleted is having empty left subtree or no child
        if (temp.left == null) {

            // case a:
            if (temp == root)// if node that we want to delete is a root node
                root = temp.right;// its right right child becomes root

            // case b:
            else if (temp == parent.left)// if node that we want to delete is a left child of its parent
                parent.left = temp.right;

            // case c:
            else// node that we want to delete is a right child of its parent
                parent.right = temp.right;
        } else {

            // CASE - 3....................................................................
            // if node which is to be deleted is having empty right subtree : if( temp.right
            // == null )

            // case a:
            if (temp == root)// if node that we want to delete is a root node
                root = temp.left;// its right right child becomes root

            // case b:
            else if (temp == parent.left)// if node that we want to delete is a left child of its parent
                parent.left = temp.left;

            // case c:
            else// node that we want to delete is a right child of its parent
                parent.right = temp.left;
        }

        return true;

    }

    // these methods will be req for balancing
    public int max(int n1, int n2) {
        return ((n1 > n2) ? n1 : n2);
    }

    public int height(Node<T> trav) {
        // base condition
        if (trav == null)
            return -1;

        return (max(height(trav.left), height(trav.right)) + 1);
    }

    // wrapper function
    public int height() {
        if (isBSTEmpty())
            return -1;
        else
            return (height(root));// initialization
    }

    public Node<T> leftRotation(Node<T> axis, Node<T> parent) {
        if (axis == null || axis.right == null)
            return null;

        Node<T> newaxis = axis.right; // rotation
        axis.right = newaxis.left; // transfer existing left child to right of old axis
        newaxis.left = axis; // make old axis left child of new axis

        // CASES:
        if (axis == root)// if axis is root
            root = newaxis;
        else if (axis == parent.left)// if axis is left child of its parent
            parent.left = newaxis; // replace
        else//// if axis is right child of its parent
            parent.right = newaxis;

        return newaxis;
    }

    public Node<T> rightRotation(Node<T> axis, Node<T> parent) {
        if (axis == null || axis.left == null)
            return null;

        Node<T> newaxis = axis.left;// rotation
        axis.left = newaxis.right;// shift existing right child of new axis to left of old axis
        newaxis.right = axis;// attach old axis to right of new axis // prev step is to make place for old
                             // axis

        if (axis == root)// if axis is root
            root = newaxis;
        else if (axis == parent.left)// if axis is left child of its parent
            parent.left = newaxis;
        else// if axis is right child of its parent
            parent.right = newaxis;

        return newaxis;
    }

    public void balance(Node<T> trav, Node<T> parent) {
        // base condition
        if (trav == null)
            return;
        // calculate balance factor of cur node
        int bf = height(trav.left) - height(trav.right);

        // if node is imbalanced
        while (bf < -1 || bf > +1) {

            // -ve means left imbalance and vice versa
            if (bf < -1) {// if node is left imbalanced => apply left rotation
                trav = leftRotation(trav, parent);
                bf += 2;// increment balance factor of a node by 2 ......because after each rotation bf
                        // changes by 2
            } else {
                // if( bf > +1 ) => if node is right imbalanced => apply right rotation
                trav = rightRotation(trav, parent);
                bf -= 2;//// decrement balance factor of a node by 2
            }
        }

        // control comes here only if cur node is balanced i.e. if bf is either -1 OR 0
        // Or +1.
        balance(trav.left, trav);// balance left subtree of cur node
        balance(trav.right, trav);// balance right subtree of cur node

    }

    // warpper function
    public void balance() {
        if (!isBSTEmpty())
            balance(root, null);// initialization
    }
}
