import java.util.Scanner;
//~ A simple Java Program to parse an English sentence

class parseInput {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int noofalpha = 0, noofdigits = 0, noofspecial = 0, noofspaces = 0, noofwords = 0, noofcons = 0, noofvowels = 0;
    String sentence;
    char ch;
    
    System.out.print("Enter a sentence: ");
    sentence = sc.nextLine().stripTrailing();

    for(int i = 0; i < sentence.length(); i++){
      ch = sentence.charAt(i);
      //! There ARE in-built Java methods in the Character class for most of these checks, might want to take a look at it.. the other method would be regex
      if((ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z')) {
        noofalpha++;
        if(ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U' || ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u')
          noofvowels++;
        else
          noofcons++;
      }
      else if(ch >= '0' && ch <= '9')
        noofdigits++;
      else if(ch == ' ' || ch == '\t') {
        noofspaces++;
        if(sentence.charAt(i - 1) != ' ' || sentence.charAt(i - 1) != '\t')          // if the previous character is non-space 
          noofwords++;
      }
      else if((ch >= '!' && ch <= '/') || (ch >= ':' && ch <= '@') || (ch >= '[' && ch <= '`') || (ch >= '{' && ch <= '~'))     // located at different sections of the keyboard hence different ranges assigned maybe
        noofspecial++;        
    }
    if (noofwords != 0)
      noofwords++;    // to count the last word as well
    System.out.printf("\nNo. of alphabets: %d\n\tNo. of vowels: %d\n\tNo. of consonants: %d\n\nNo. of spaces: %d\nNo. of digits: %d\nNo. of special characters: %d\nNo. of words: %d", noofalpha, noofvowels, noofcons, noofspaces, noofdigits, noofspecial, noofwords);
    sc.close();
  }
}