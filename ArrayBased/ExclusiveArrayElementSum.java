import java.util.Scanner;

class ExclusiveArrayElementSum {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int i, j, k, nooftestcases, noofelements;
    
    System.out.print("Enter the number of Test Cases: ");
    nooftestcases = sc.nextInt();
    // Applying constraints
    nooftestcases = nooftestcases < 1 ? 1 : nooftestcases;
    nooftestcases = nooftestcases > 100 ? 100 : nooftestcases;
    
    for(i = 0; i < nooftestcases; i++) {
      System.out.println("\nTest Case " + (i + 1) + ":");
      System.out.print("Enter the number of elements to be in the array: ");
      noofelements = sc.nextInt(); 
      // Applying constraints 
      noofelements = noofelements < 1 ? 1 : noofelements;
      noofelements = noofelements > 105 ? 105 : noofelements;
      int numArr[] = new int[noofelements];
      int sumArr[] = new int[noofelements];
      System.out.print("Enter the " + noofelements + " numbers: ");
      for(j = 0; j < noofelements; j++) {
        numArr[j] = sc.nextInt();
        if(i == nooftestcases - 1 && j == noofelements - 1) // resource leak prevention warning by Scanner, it wasn't evaded when this was written outside the for loop
          sc.close();
      }
      
      //~ Main mechanism
      for(k = 0; k < noofelements; k++) 
      for(j = 0; j < noofelements; j++)
        if(j != k)
        sumArr[k] += numArr[j];
      
      System.out.print("Desired Sum: ");
      for(j = 0; j < noofelements; j++) {
        System.out.printf("%d ", sumArr[j]);
        sumArr[j] = 0;
      }
      System.out.println("");
    }
  }
}
