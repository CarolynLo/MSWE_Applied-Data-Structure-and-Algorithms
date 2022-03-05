//ReadFile, based on https://www.journaldev.com/709/java-read-file-line-by-line
//Tokenize, based on https://howtodoinjava.com/java/string/4-ways-to-split-tokenize-strings-in-java/
// based on https://www.programiz.com/java-programming/bufferedwriter
package E1;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Exercise1 {
    public static void main(String[] args0){
        // build a LinkedList
        LinkedList list=new LinkedList();
        // build a BinaryTree
        BinaryTree tree=new BinaryTree();
        // build a HashTable
        HashTable hash=new HashTable();
        // read input file
        BufferedReader reader, reader1;
        try{
            // read a file
            reader= new BufferedReader(new FileReader("C:/Users/user/IdeaProjects/241P-Exercise 1/src/pride-and-prejudice.txt"));
            //reader= new BufferedReader(new FileReader("C:/Users/user/IdeaProjects/241P-Exercise 1/src/test1.txt"));
            String line=reader.readLine();


            while(line!=null){
                // tokenize each line
                String delimiters="[^a-zA-Z0-9]";
                String[] tokens=line.split(delimiters);
                for(String token: tokens){
                        // add to LinkedList
                        list.add(token);
                        // add to tree
                        tree.add(token);
                        // add to hash
                        hash.add(token);
                }
                // read next line
                line=reader.readLine();
            }
            reader.close();

            System.out.println("list size: "+list.size());
            System.out.println("tree size: "+tree.size());
            System.out.println("hash size: "+hash.size());
        }catch(IOException e){
            e.printStackTrace();
        }

        // read another file to find whether the data structure contains
        int listNotContain=0, treeNotContain=0, hashNotContain=0;
        try{
            // read a file
            reader1= new BufferedReader(new FileReader("C:/Users/user/IdeaProjects/241P-Exercise 1/src/words-shuffled.txt"));
            //reader= new BufferedReader(new FileReader("C:/Users/user/IdeaProjects/241P-Exercise 1/src/test1.txt"));
            String line=reader1.readLine();

/*
            // write a file
            FileWriter file = new FileWriter("hash_search.txt");
            BufferedWriter output = new BufferedWriter(file);
            long start = System.nanoTime();
            long finish ;
            long time;
*/
            while(line!=null){
                // tokenize each line
                String delimiters="[^a-zA-Z0-9]";
                String[] tokens=line.split(delimiters);


                for(String token: tokens){
                    // to find whether the data structure contains
/*                    boolean containsornot=hash.contains(token);
                    finish = System.nanoTime();
                    time=finish-start;
                    output.write(String.valueOf(time+"\r\n"));
*/
                    if(!list.contains(token)){
                        listNotContain++;
                    }
                    if(!tree.contains(token)){
                        treeNotContain++;
                    }
                    if(!hash.contains(token)){
                        hashNotContain++;
                    }
                }
                // read next line
                line=reader1.readLine();
            }
            reader1.close();
/*            output.close();
*/
            System.out.println("list not contain: "+listNotContain);
            System.out.println("tree not contain: "+treeNotContain);
            System.out.println("hash not contain: "+hashNotContain);

        }catch(IOException e){
            e.printStackTrace();
        }

        try {
            // Creates a FileWriter
            FileWriter file = new FileWriter("output.txt");
            // Creates a BufferedWriter
            BufferedWriter output = new BufferedWriter(file);
            // Writes the string to the file
            output.write("hello");
            // Closes the writer
            output.close();
        }
        catch (Exception e) {
            e.getStackTrace();
        }
    }
}
