import java.util.Scanner;
// Imp standing for implementation
class ComplexNumberImp {
  private double realPart, imaginaryPart;

  public ComplexNumberImp() {
    realPart = 0;
    imaginaryPart = 0;
  }

  public ComplexNumberImp(double rp, double ip) {
    realPart = rp;
    imaginaryPart = ip;
  }
  
  public void setRealPart(double rp) {
    realPart = rp;
  }

  public void setImaginaryPart(double ip) {
    imaginaryPart = ip;
  }

  public double getRealPart() {
    return realPart;
  }

  public double getImaginaryPart() {
    return imaginaryPart;
  }
}

class ComplexNumber {
  public static void main(String[] args) {
    double rp, ip;
    Scanner sc = new Scanner(System.in);
    ComplexNumberImp c1 = new ComplexNumberImp();
    ComplexNumberImp c2 = new ComplexNumberImp(20.2, 18.4);
    ComplexNumberImp c3 = new ComplexNumberImp(1, 1);
  
    // Getting
    System.out.println("\nComplex number in object c1: " + c1.getRealPart() + " + " + c1.getImaginaryPart() + "i");
    System.out.println("Complex number in object c2: " + c2.getRealPart() + " + " + c2.getImaginaryPart() + "i");
    System.out.println("Complex number in object c3: " + c3.getRealPart() + " + " + c3.getImaginaryPart() + "i");

    // Setting
    System.out.print("\nEnter Real Part for C1: ");
    rp = sc.nextDouble();
    System.out.print("Enter Imaginary Part for C1: ");
    ip = sc.nextDouble();
    c1.setRealPart(rp);
    c1.setImaginaryPart(ip);
    
    System.out.print("\nEnter Real Part for C2: ");
    rp = sc.nextDouble();
    System.out.print("Enter Imaginary Part for C2: ");
    ip = sc.nextDouble();
    c2.setRealPart(rp);
    c2.setImaginaryPart(ip);
    
    System.out.print("\nEnter Real Part for C3: ");
    rp = sc.nextDouble();
    System.out.print("Enter Imaginary Part for C3: ");
    ip = sc.nextDouble();
    c3.setRealPart(rp);
    c3.setImaginaryPart(ip);
    
    System.out.println("\nComplex number in object c1: " + c1.getRealPart() + " + " + c1.getImaginaryPart() + "i");
    System.out.println("Complex number in object c2: " + c2.getRealPart() + " + " + c2.getImaginaryPart() + "i");
    System.out.println("Complex number in object c3: " + c3.getRealPart() + " + " + c3.getImaginaryPart() + "i");
    sc.close();
  }
}
