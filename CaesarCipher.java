//~ A simple Java program to implement Caesar substitution cipher (95 Valid characters, i.e, all typable characters)
import java.util.Scanner;

class CaesarCipher {
  
  static String caesarEncrypt(String plainText, int key) {
    String cipherText = "";
    for(int i = 0; i < plainText.length(); i++) 
      cipherText += (char)((((int)plainText.charAt(i) + key - 32) % 95) + 32);
    
    return cipherText; 
  }

  static String caesarDecrypt(String cipherText, int key) {
    String plainText = "";
    for(int i = 0; i < cipherText.length(); i++) {
      int temp = (int)cipherText.charAt(i) - key - 32;      
      while(temp < 0) { temp += 95; }                   //*  Since % works differently (read below ↓), manually making it work like modulo
      plainText += (char)((temp % 95) + 32);    
    }
    
    return plainText;
  }

  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    String plainText, cipherText;
    int key = -1;
    System.out.print("Enter your message: ");
    plainText = scan.nextLine();

    while(key < 0) {
      System.out.print("Enter the key (preferably 0 < key < 95): ");
      key = scan.nextInt();
      if(key < 0)
        System.out.println("Key cannot be negative, try again.");
    }

    cipherText = caesarEncrypt(plainText, key);
    System.out.println("Cipher Text: " + cipherText);
    
    plainText = caesarDecrypt(cipherText, key);
    System.out.println("Deciphered Text: " + plainText);

    scan.close();
  }
}


//! In Java, % works as returning remainder (normal division) as opposed to Python's % which returns modulus (euclidean division)
//! So -ve nums can be there in remainder in Java % but absolutely cannot be in Python.
// Good reads for the topic
// https://stackoverflow.com/questions/13683563/whats-the-difference-between-mod-and-remainder
// https://stackoverflow.com/questions/5385024/mod-in-java-produces-negative-numbers