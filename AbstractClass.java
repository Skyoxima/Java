//~ A simple Java program to demonstrate Abstract class implementation.
import java.util.Scanner;

abstract class CustomArea {
  Scanner sc = new Scanner(System.in);

  abstract public void calcArea();

  abstract public void input();
}

class Triangle extends CustomArea {
  int b, h;
  float area;

  public void input() {
    System.out.print("Enter the base of the Triangle: ");
    b = sc.nextInt();
    System.out.print("Enter the height of the Triangle: ");
    h = sc.nextInt();
  }

  public void calcArea() {
    area = 0.5f * b * h;
  }
}

class Circle extends CustomArea {
  int r;
  float area;

  public void input() {
    System.out.print("Enter the radius of the Circle: ");
    r = sc.nextInt();
  }

  public void calcArea() {
    area = 3.14f * r * r;
  }
}

class Rectangle extends CustomArea {
  int l, w;
  float area;

  public void input() {
    System.out.print("Enter the length of the Rectangle: ");
    l = sc.nextInt();
    System.out.print("Enter the width of the Rectangle: ");
    w = sc.nextInt();
  }

  public void calcArea() {
    area = l * w;
  }
}

class AbstractClass {
  public static void main(String[] args) {
    Triangle trikon = new Triangle();
    Rectangle aayat = new Rectangle();
    Circle vritta = new Circle();

    trikon.input();
    trikon.calcArea();
    System.out.println("Area of Triangle = " + trikon.area + "\n");
    aayat.input();
    aayat.calcArea();
    System.out.println("Area of Rectangle = " + aayat.area + "\n");
    vritta.input();
    vritta.calcArea();
    System.out.println("Area of Circle = " + vritta.area);
  }
}
