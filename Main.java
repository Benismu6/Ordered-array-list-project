import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        OrderedArrayList list1 = new OrderedArrayList();
        OrderedArrayList list2 = new OrderedArrayList();
        OrderedArrayList result = new OrderedArrayList();

        list1 = getNums(scanner, "list1");
        list2 = getNums(scanner, "list2");

        System.out.println("First list is:\n");
        list1.print();
        System.out.println("\nSecond list is:\n");
        list2.print();

        result = list1.merge(list2);
        System.out.println("The merged list is:\n"); 
        result.print();
        
        int key = getInt(scanner, "Enter key for split:" );
        OrderedArrayList[] splitResult = result.split(key);

      System.out.println("The first list is:\n");
      splitResult[0].print();
      
      System.out.println("The second list is:\n"); 
      splitResult[1].print();
      
    }

        

    public static OrderedArrayList getNums(Scanner sc, String file) {
        OrderedArrayList list = new OrderedArrayList();
        boolean found = false;

        while (!found) {
            try { 
                System.out.println("Please input the name of the file to be opened for " + file + ":");
                String fileName = sc.nextLine();
                Scanner fileSc = new Scanner(new File(fileName));
                
                while (fileSc.hasNext()) {
                    if (fileSc.hasNextInt()) {
                        list.insert(fileSc.nextInt());
                    } else {
                        fileSc.next();
                    }
                }
                fileSc.close();
                found = true;
            } catch (FileNotFoundException e) {
                System.out.println("File not found");
            } 
        }
        return list;
    }

    public static int getInt(Scanner sc, String prompt) {
          System.out.println(prompt);
          while (!sc.hasNextInt()) {
            sc.next();
            System.out.print("Not an integer! try again: ");
          }
          return sc.nextInt();

    }

  
}