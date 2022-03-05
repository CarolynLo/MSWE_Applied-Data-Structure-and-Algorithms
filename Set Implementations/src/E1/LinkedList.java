// based on https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/
package E1;

public class LinkedList {
    static Node head;
    static class Node{
        String data;
        Node next;
        Node(String d){
            data=d;
            next=null;
        }
    }
    public boolean add(String word){
        Node new_node=new Node(word);
        // if LinkedList is empty
        if(head==null){
            head=new_node;
        }
        else{
            // find the last one
            Node last_node=head;
            while(last_node.next!=null){
                if(last_node.data.compareTo(word)==0){
                    return false;
                }
                last_node=last_node.next;
            }
            // compare to the last one
            if(last_node.data.compareTo(word)==0){
                return false;
            }
            last_node.next=new_node;
        }
        return true;
    }
    public boolean contains(String word){
        Node run_node=head;
        while(run_node!=null){
            if(run_node.data.compareTo(word)==0){
                return true;
            }
            run_node=run_node.next;
        }
        return false;
    }
    public int size(){
        int count=0;
        Node run_node=head;
        while(run_node!=null){
            count++;
            run_node=run_node.next;
        }
        return count;
    }
}
