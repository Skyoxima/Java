import java.util.Scanner;

class pivotIndex {
    static int pivottIndex(int[] nums) {
      int noofnums = nums.length, leftSum = 0, totalSum = 0;
      if(noofnums == 0) return -1;
      if(noofnums == 1) return 0;
  
      for(int num: nums) { totalSum += num; }
      for(int i = 0; i < noofnums; i++) {
        if(leftSum == totalSum - leftSum - nums[i])
          return i;
        leftSum += nums[i];
      }    
      return -1;
    }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter the number of elements in the array: ");
    int noofele = sc.nextInt();
    int[] arr = new int[noofele];
    System.out.print("Enter the elements: ");
    for(int i = 0; i < noofele; i++) 
      arr[i] = sc.nextInt();

    int response = pivottIndex(arr);
    System.out.println("Output: " + response);
  }
}