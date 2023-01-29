//~ A simple Java program to demonstrate Upcasting and Downcasting in Java 

import java.util.Scanner;

class Account {
  private int userID;
  private String username;
  private double balance;

  Account(int uID, String un, double amt) {
    userID = uID;
    username = un;
    balance = amt;
  }

  public int deposit(double amt) {
    if(amt <= 0)
      return -1;
    balance += amt;
    return 0;

  }

  public int withdraw(double amt) {
    if(amt <= 0)
      return -1;
    balance -= amt;
    return 0;
  }

  public double checkBalance() {
    return balance;
  }

  public int checkUserID() {
    return userID;
  }

  public String checkUserName() {
    return username;
  }
}

class SavingsAccount extends Account {
  private double interest;

  SavingsAccount(int uID, String un, double amt, double interest) {
    super(uID, un, amt);
    this.interest = interest;
  }
  
  public void addInterest() {
    deposit(interest * checkBalance());
  }
}

class CurrentAccount extends Account {
  private double overdraftLimit;
  
  CurrentAccount(int uID, String un, double amt) {
    super(uID, un, amt);
    overdraftLimit = 12000.0;
  }

  public void sendODNotice() {
    if(checkBalance() < 0)
      System.out.println("Account Balance in overdraft, please pay your dues.");
  }

  public int withdraw(double amt) {
    if(amt <= 0)
      return -1;

    double temp = checkBalance();
    temp -= amt;

    if (temp <= -overdraftLimit) {
      System.out.println("Overdraft Limit exceeded, Withdrawal CANCELLED!");
      return -1;
    }
    return super.withdraw(amt);
  }
}

class Bank {
  public static void accountsUpdate(Account[] accs) {
    Scanner sc = new Scanner(System.in);
    for(int i = 0; i < accs.length; i++) {
      if(accs[i] instanceof SavingsAccount) {
        SavingsAccount sa = (SavingsAccount)accs[i];                   //! Since upcasting was automatically done, we need to manually downcast, 'sa' will refer to accs[i] which itself refers to instance of SavingsAccount -> this is covered in polymorphism
        System.out.println("UserID: " + sa.checkUserID() + "\nUsername: " + sa.checkUserName() + "\nBalance: " + sa.checkBalance());
        System.out.print("Enter amount to Deposit: ");
        if(sa.deposit(sc.nextDouble()) != -1) {
          System.out.println("Deposited, Balance: " + sa.checkBalance());
        } else {
          System.out.println("Incorrect input...");
        }
        
        sa.addInterest();
        System.out.println("Interest Added: " + sa.checkBalance());
        
        System.out.print("Enter amount to Withdraw: ");
        if(sa.withdraw(sc.nextDouble()) != -1) {
          System.out.println("Withdrawn, Balance: " + sa.checkBalance());
        } else {
          System.out.println("Incorrect input...");
        }
      } else {
        CurrentAccount ca = (CurrentAccount)accs[i];
        System.out.println("\nUserID: " + ca.checkUserID() + "\nUsername: " + ca.checkUserName() + "\nBalance: " + ca.checkBalance());
          System.out.print("Enter amount to Deposit: ");
          if(ca.deposit(sc.nextDouble()) != -1) {
            System.out.println("Deposited, Balance: " + ca.checkBalance());
          } else {
            System.out.println("Incorrect input...");
          }

          System.out.print("Enter amount to Withdraw: ");
          if(ca.withdraw(sc.nextDouble()) != -1) {
            System.out.println("Withdrawn, Balance: " + ca.checkBalance());
          } else {
            System.out.println("Incorrect input...");
          }
          System.out.println("Balance: " + ca.checkBalance());
      }
    }
    sc.close();
  }
  public static void main(String[] args) {
    Account[] accs = new Account[2];
    accs[0] = new SavingsAccount(121, "Sam", 120000.0, 0.1);       // automatic upcasting is done
    accs[1] = new CurrentAccount(122, "Mas", 120000.0);  

    accountsUpdate(accs);
  }
}