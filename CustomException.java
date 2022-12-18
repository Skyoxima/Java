//~ A simple Java to implement custom exception 
import java.util.Scanner;

class MarksOutOfBoundException extends Throwable {
  public MarksOutOfBoundException(String s) {
      System.out.println(s);
  }
}

class CustomException {
  int rollNo, seatNo, centreNum, marks;
  String objName, name, doe;                 // date of exam -> doe
  Scanner sc = new Scanner(System.in);
  void checkMarks() {
    try {
      if(marks < 0 || marks > 100)
        throw new MarksOutOfBoundException("Invalid Marks!");
    } catch (MarksOutOfBoundException e) {
        // System.out.println(e);
        System.out.print("Enter New Marks: ");
        marks = sc.nextInt();
    }
  }

  CustomException(String objName, String name, int rollNo, int seatNo, String doe,  int centreNum, int marks) {
    this.name = name;
    this.rollNo = rollNo;
    this.seatNo = seatNo;
    this.doe = doe;
    this.centreNum = centreNum;
    this.marks = marks;
    this.objName = objName;
    System.out.println("Student-" + objName);
    checkMarks();         // check for invalidation as soon as the assignment is done so that the rectification can happen immediately if needed. 
                          // If I were not using pre-loaded values then it would have been better to validate marks as soon as the input is taken i.e before the assignment
  }

  void showDetails() {
    System.out.println("Name: " + name);
    System.out.println("Roll No: " + rollNo);
    System.out.println("Seat No: " + seatNo);
    System.out.println("Date of Examination: " + doe);
    System.out.println("Centre No.: " + centreNum);
    System.out.println("Marks: " + marks);
  }
  public static void main(String[] args) {
    CustomException s1 = new CustomException("s1", "Samarth", 15, 999, "24/11/2022", 9, 80);
    s1.showDetails();
    System.out.println("");
    CustomException s2 = new CustomException("s2", "Skyoxima", 99, 40, "24/11/2022", 9, 120);
    s2.showDetails();
  }  
}
