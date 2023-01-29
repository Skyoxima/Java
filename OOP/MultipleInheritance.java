class Student {
  int rollNo;

  Student(int rn) {
    rollNo = rn;
  }
}

class Test extends Student {
  int sem1Marks, sem2Marks;

  Test(int rn, int s1, int s2) {
    super(rn);
    sem1Marks = s1;
    sem2Marks = s2;
  }
}

interface Sports {
  public int score(int x);
}

class Result extends Test implements Sports { // Multiple inheritance used using interfaces (no need of MRO, this class itself will implement the inherited function thereby having no need to look further above)
  int total;
  int sp;

  Result(int rn, int s1, int s2, int sp) {
    super(rn, s1, s2);
    this.sp = sp;
  }

  public int score(int x) {
    return x + 10;
  }

  int calcResult() {
    total = sem1Marks + sem2Marks + score(sp);
    return total;
  }

  void showResult() {
    System.out.println("\u001B[38;5;223mStudent ID: 6K92K" + rollNo + "\u001B[0m");
    System.out.println("Sem 1 Marks: " + sem1Marks);
    System.out.println("Sem 2 Marks: " + sem2Marks);
    System.out.println("Sports Marks: " + score(sp));
    System.out.println("\u001B[38;5;148mTotal Marks: " + calcResult() + "\u001B[0m");
  }
}

class MultipleInheritance {
  public static void main(String[] args) {
    Result r = new Result(15, 90, 90, 85);
    r.showResult();
  }
}
