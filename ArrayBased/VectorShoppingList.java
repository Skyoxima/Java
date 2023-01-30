//~ A simple Java program to explore Vectors by simulating a Shopping List and its functions 
import java.util.Scanner;
import java.util.Vector;

class VectorShoppingList {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int choice, noofitems;
    String inputString;
    Vector<String> shoppingList = new Vector<String>(5);
    
    System.out.print("Enter number of items: ");
    noofitems = sc.nextInt(); sc.nextLine();
    System.out.println("Enter Shopping List items: ");
    for(int i = 0; i < noofitems; i++) {
      inputString = sc.nextLine();
      shoppingList.addElement(inputString);
    }

    while(true) {
      System.out.println("\nEnter the choice for corresponding actions: ");
      System.out.print("1. Add item to specified location.\n2. Delete an item.\n3. Print Shopping List.\nChoice: ");
      choice = sc.nextInt(); sc.nextLine();
  
      switch(choice) {
        default:
          System.out.println("Invalid Choice!");
          sc.close();
          return;

        case 1:
          System.out.print("Enter new item: ");
          inputString = sc.nextLine();
          System.out.print("Enter position to add at: ");
          choice = sc.nextInt();
          shoppingList.insertElementAt(inputString, choice);
          System.out.println("Item added!");
        break;
          
        case 2:
          System.out.print("Enter item to delete: ");
          inputString = sc.nextLine();
          shoppingList.removeElement(inputString);
        break;

        case 3:
          System.out.println("==== Shopping List ====");
          System.out.println(shoppingList);
        break;
      }
    }
  }
}
