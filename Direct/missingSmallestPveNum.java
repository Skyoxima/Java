import java.util.Arrays;
import java.util.Scanner;

//~ Simple Java program to find the smallest missing positive number in a given array

class missingSmallestPveNum {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int[] numArr;

    System.out.print("Enter the number of elements present in the array: ");
    numArr = new int[scan.nextInt()];
  
    System.out.print("Enter the array elements: ");
    for(int i = 0; i < numArr.length; i++)
      numArr[i] = scan.nextInt();
    
    Arrays.sort(numArr);
    int j = 1;
    for(int i = 0; i < numArr.length; i++)
      if(numArr[i] == j)
        j++;
    
    System.out.println("Smallest positive number missing from the array is: " + j);
    scan.close();
  }
}
