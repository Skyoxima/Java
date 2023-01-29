//~ Simple Java program to implement some array operations (search, descending sort, delete duplicates)

import java.util.Scanner;
import java.util.Arrays;

class arrayOps {
  static int searchElement(int[] arr, int toSearch) {
    for(int i = 0; i < arr.length; i++) {
      if(arr[i] == toSearch) {
        return i;
      }
    }
    return -1;
  }

  static void descendingArray(int[] arr) {
    int temp;
    for(int i = 0; i < arr.length / 2; i++) {
      temp = arr[i];
      arr[i] = arr[arr.length - 1 - i];
      arr[arr.length - 1 - i] = temp;
    }
  }

  static int[] deleteDuplicate(int[] arr) {
    int arr2[] = new int[arr.length];
    
    // to allow 0 to be searched in this array and be added atleast once, since default initialization of a new numeric array makes all elements 0 
    for(int i = 0; i < arr2.length; i++) {
      arr2[i] = -999;
    }

    int j = 0;
    for(int i = 0; i < arr.length; i++) {
      if(searchElement(arr2, arr[i]) == -1) {
        arr2[j++] = arr[i];
      }
    }

    return arr2;
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int n = 0;
    int arr[];
    System.out.print("Enter the number of values required in the array: ");
    n = scan.nextInt();
    arr = new int[n];
    
    System.out.print("Enter the array elements: ");
    for(int i = 0; i < n; i++)
    arr[i] = scan.nextInt();
    
    System.out.print("Entered array: ");
    for(int i = 0; i < n; i++)
      System.out.print(arr[i] + " ");

    System.out.println("\n\n========== ARRAY MENU ===========");
    int choice = 0;
    while(choice != -1) {
      System.out.print("\n\n1. Search an element in the array.\n2. Sort array in descending order.\n3. Delete duplicates from the array.\nChoice: ");
      choice = scan.nextInt();
  
      switch(choice) {
        case 1:
          System.out.print("Enter the number to be searched in the array: ");
          int toSearch = scan.nextInt();
          int psn = searchElement(arr, toSearch);
          if(psn != -1)
            System.out.println(toSearch + " found in the array at position " + (psn + 1));
          else
            System.out.print("Number not found...");
        break;
  
        case 2:
          Arrays.sort(arr);
          descendingArray(arr);
          System.out.println("Reverse Array: " + Arrays.toString(arr));
        break;
        
        case 3:
        int arr2[] = deleteDuplicate(arr);
        System.out.println("Unique Array: " + Arrays.toString(arr2));       // while printing -999 ones should be ignored
        break;
        
        case -1:
          break;

        default:
          System.out.println("Invalid choice!");
      }
    }
    scan.close();
  }
}