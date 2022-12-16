//~ Java program to find if a 4-digit number is a vampire number or not

import java.util.Vector;
import java.util.Scanner;

class VampireNum {
  static Vector<Object> vampCheck(int num, int[] numArr) {
    Vector<Object> toReturn = new Vector<Object>();
    Vector<Integer> twoDigitsVec = new Vector<Integer>();
    // initialising toReturn with condition fail values
    toReturn.addElement(false);
    toReturn.addElement(null);

    // making all valid 2-digit nums from the digits of the original number stored as an array 
    for(int i = 0; i < numArr.length; i++)                 
      for(int j = 0; j < numArr.length; j++)
        if(numArr[i] != 0)                              // the first digit shouldn't be 0
          if(i != j)                          
            twoDigitsVec.addElement(numArr[i] * 10 + numArr[j]);       // to make a two-digit mumber directly by int. digits (previously used characters)

    // actually checking the multiplications, but only with valid pairs -> participating members of the pair must not have common digits
    for(int i = 0; i < twoDigitsVec.size() - 1; i++) {
      int ithElement = twoDigitsVec.elementAt(i);
      for(int j = i + 1; j < twoDigitsVec.size(); j++) {
        int jthElement = twoDigitsVec.elementAt(j);
        
        // units (u) and tens(t)
        int u1 = twoDigitsVec.elementAt(i) % 10;
        int t1 = twoDigitsVec.elementAt(i) / 10;
        int u2 = twoDigitsVec.elementAt(j) % 10;
        int t2 = twoDigitsVec.elementAt(j) / 10;
  
        if((u1 != u2 && u1 != t2) && (t1 != u2 && t1 != t2)) {
          if(ithElement * jthElement == num) {
            Vector<Integer> temp = new Vector<Integer>();
            temp.add(ithElement); temp.add(jthElement);
            toReturn.set(0, true);
            toReturn.set(1, temp);
          }
        }
      }
    }

    return toReturn;
  }

  public static void main(String[] args) {
    int num;
    int[] numArr = new int[4];
    Scanner scn = new Scanner(System.in);
    Vector<Object> returned = new Vector<Object>();
    System.out.print("Enter a 4-digit number: ");
    num = scn.nextInt();
    int tempNum = num;
    for(int i = 3; i >= 0; i--) {
      numArr[i] = tempNum % 10;
      tempNum /=  10;
    }

    returned = vampCheck(num, numArr);
    if((boolean)returned.elementAt(0) == true) {
      Vector<Integer> vampFangs = new Vector<Integer>();
      vampFangs = (Vector<Integer>)returned.elementAt(1);       // warns, but no issues
      System.out.println("\u001B[38;5;202m"+ num + " \u001B[38;5;197mis a Vampire Number!\n\u001B[38;5;202m" +  vampFangs.elementAt(0) + " x " + vampFangs.elementAt(1) + " = " + num + "\u001B[0m");
    } else {
      System.out.println(num + " \u001B[38;5;189mis not a Vampire number...\u001B[0m");
    }

    scn.close();
  }
}