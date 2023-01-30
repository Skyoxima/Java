import java.util.Scanner;
import java.util.Vector;

class MetaStrings {
  static boolean checkSteps(String s1, String s2) {
    StringBuffer s = new StringBuffer();
    // char temp;
    Vector<Integer> unmatchedIndx = new Vector<Integer>();
    
    if (s1.length() != s2.length()) {
      return false;
    } else {
      for (int i = 0; i < s1.length(); i++) {
        if (s1.charAt(i) != s2.charAt(i)) {
          unmatchedIndx.add(i);
          // System.out.println(unmatchedIndx);
          if (unmatchedIndx.size() > 2) {
            return false;
          }
        }
      }

      s.append(s1);
      //swapping the characters at the 2 indices, there is no direct way
      s.setCharAt(unmatchedIndx.elementAt(0), s2.charAt(unmatchedIndx.elementAt(0)));
      s.setCharAt(unmatchedIndx.elementAt(1), s2.charAt(unmatchedIndx.elementAt(1)));
      if(s.toString().equalsIgnoreCase(s2))
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String s1, s2;

    System.out.print("Enter String s1: ");
    s1 = sc.nextLine();
    System.out.print("Enter String s2: ");
    s2 = sc.nextLine();

    if (!checkSteps(s1, s2))
      System.out.println(s1 + " and " + s2 + " are not Meta strings.");
    else
      System.out.println(s1 + " and " + s2 + " are Meta strings.");
    sc.close();
  }
}
