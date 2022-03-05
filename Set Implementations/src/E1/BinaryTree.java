// based on https://www.baeldung.com/java-binary-tree
// based on https://www.geeksforgeeks.org/insert-a-node-in-binary-search-tree-iteratively/
package E1;
public class BinaryTree {
    static Node root;
    static class Node{
        String data;
        Node right,left;
        Node(String d){
            data=d;
            right=null;
            left=null;
        }
    }
    public boolean add(String word)
    {
        Node new_node=addRecursive(root,word);
        if(root==null){
            root=new_node;
            return  true;
        }
        else {
            if (new_node == root) {
                return true;
            } else if (new_node == null)
                return false;
            else {
                return true; // meaningless
            }
        }
    }
    public Node addRecursive(Node cur_node,String word){
        if(cur_node==null){
            cur_node=  new Node(word);
            return cur_node;
        }
        if(cur_node.data.compareTo(word)>0){
            Node new_node=addRecursive(cur_node.left,word);
            if(new_node==null) return null;
            else cur_node.left=new_node;
        }
        else if(cur_node.data.compareTo(word)<0){
            Node new_node=addRecursive(cur_node.right,word);
            if(new_node==null) return null;
            else cur_node.right=new_node;
        }
        else{ // for repetition
            return null;
        }
        return cur_node;
    }

    public boolean contains(String word){
        if(root==null) return false;
        if(root.data.compareTo(word)==0){
            return true;
        }else if(root.data.compareTo(word)>0){
            return findRecursive(root.left,word);
        }
        else{
            return findRecursive(root.right,word);
        }
    }
    static boolean findRecursive(Node root_node, String word){
        if(root_node==null){
            return false;
        }
        else if(root_node.data.compareTo(word)==0){
            return true;
        }
        else if(root_node.data.compareTo(word)>0){
                return findRecursive(root_node.left,word);
        }
        else{
                return findRecursive(root_node.right,word);
        }
    }
    public int size(){
            return countRecursive(root);
    }
    static  int countRecursive(Node root_node){
        if(root_node==null){
            return 0;
        }
        else{
            return countRecursive(root_node.left)+countRecursive(root_node.right)+1;
        }
    }
}
