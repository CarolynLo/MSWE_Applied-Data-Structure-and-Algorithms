// based on https://www.geeksforgeeks.org/implementing-our-own-hash-table-with-separate-chaining-in-java/
package E1;

public class HashTable {
    static HashNode[] HashList=new HashNode[100];
    HashTable(){
        for(int i=0;i<100;i++){
            HashList[i]=new HashNode("");
        }
    }
    static class HashNode {
        String value;
        HashNode next;
        HashNode(String word)
        {
            value = word;
            next=null;
        }
    }
    private int hashFunction(String word){
        int number=0;
        for(int i=0;i<word.length();i++){
            number+=word.charAt(i);
        }
        return number%100;
    }
    public boolean add(String word){
        int key=hashFunction(word);
        if(HashList[key].value==""){
            HashList[key].value=word;
            return true;
        }
        else{
            HashNode cur_node=HashList[key];
            while(cur_node.next!=null){
                if(cur_node.value.compareTo(word)==0){
                    return false;
                }
                else{
                    cur_node=cur_node.next;
                }
            }
            if(cur_node.value.compareTo(word)==0){
                return false;
            }
            else{
                cur_node.next=new HashNode(word);
                return true;
            }
        }
    }
    public boolean contains(String word){
        int key=hashFunction(word);
        if(HashList[key].value==""){
            return false;
        }
        else{
            HashNode cur_node=HashList[key];
            while(cur_node.next!=null){
                if(cur_node.value.compareTo(word)==0){
                    return true;
                }
                else{
                    cur_node=cur_node.next;
                }
            }
            if(cur_node.value.compareTo(word)==0){
                return true;
            }
            else{
                return false;
            }
        }
    }
    public int size(){
        int count=0;
        for(int i=0;i<100;i++){
            if(HashList[i].value==""){
            }
            else{
                HashNode cur_node=HashList[i];
                while(cur_node!=null){
                    count++;
                    cur_node=cur_node.next;
                }
            }
        }
        return count;
    }
}
