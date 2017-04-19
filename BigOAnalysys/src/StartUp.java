import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StartUp {

    public static void main(String[] args) {
        System.out.println("                ------------------ Hello! ------------------");
        System.out.println("------------------ Building list of words! Please wait :) ------------------");
        ArrayList<String> names = new ArrayList<String>();
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("loadsOfWords.txt"));

            while (sc.hasNext()) {
                String cur = sc.nextLine();
                names.add(cur);
            }
        } catch (FileNotFoundException ex){
            //except it
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        System.out.println();
        System.out.println("What Data Structure would you like to test?");
        System.out.println("[Press 1 for Hash Table length at 1 second]");
        System.out.println("[Press 2 for Linked List at 1 second]");
        System.out.println("[Press 3 for Linked List at 1 minute]");
        System.out.println("[Press 4 for 10 000 operations in a Linked List at varied sizes]");
        System.out.println("[Press 5 for 10 000 operations in a Hash Table at varied sizes]");

        Scanner scan = new Scanner(System.in);
        int command = scan.nextInt();
        Runner run = new Runner();
        while(command != 6) {
            if (command == 1) {
                HashTable table = new HashTable();
                run.addingHash(table, names);
            } else if (command == 2) {
                LinkedList list = new LinkedList();
                run.addingList(list, names, 1000);
            } else if (command == 3) {
                LinkedList list = new LinkedList();
                run.addingList(list, names, 60000);
            } else if (command == 4) {
                LinkedList list = new LinkedList();
                run.timeForTen(list, names);
            } else if (command == 5) {
                HashTable table = new HashTable();
                run.timeForTen(table, names);
            }

            command = scan.nextInt();
        }
        scan.close();

    }
}
