//~ A simple Java program to try Java's dynamic Array system
class IrregularArray {
  public static void main(String z[]) {
    int i = 0, j = 0, count = 0;
    int jaggedArr[][] = new int[3][]; // Java inherently supports dynamic arrays
    // row x column -> same as C
    
    jaggedArr[0] = new int[1];
    jaggedArr[1] = new int[2];
    jaggedArr[2] = new int[3];

    for(i = 0; i < jaggedArr.length; i++)
      for(j = 0; j < jaggedArr[i].length; j++)
        jaggedArr[i][j] = ++count;
    
    for(i = 0; i < jaggedArr.length; i++) {
      for(j = 0; j < jaggedArr[i].length; j++)
        System.out.printf("%d ", jaggedArr[i][j]);
      System.out.print("\n");
    }		
}
}
