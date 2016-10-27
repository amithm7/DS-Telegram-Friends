/**
*Author: @amithm7
*
*Q: Second year Computer Engineering class of M students, set A of students play
*cricket and set B of students play badminton. Write program to find and display-
*i. Set of students who play either cricket or badminton or both
*ii. Set of students who play both cricket and badminton
*iii. Set of students who play only cricket
*iv. Set of students who play only badminton
*v. Number of students who play neither cricket nor badminton.
*(Note- While realizing the set duplicate entries are to avoided)
**/


public class Student {
  private int RollNo;
  private int Activity;       // 0=None; 1=Cricket; 2=badminton; 3 = Both;
  public void readStudent(int roll) {
    java.util.Scanner scan = new java.util.Scanner(System.in);
    RollNo = roll;
    System.out.println(" Activity involved :\n 0 : None\n 1 : Cricket only\n 2: Badminton only\n 3. Both\n Enter the choice Number - ");
    Activity = scan.nextInt();
  }

  public int activityStatus() {
    return Activity;
  }

  public void print() {
    System.out.println(" RollNo : " + RollNo);
  }

  public static void main(String[] args) {
    java.util.Scanner scan = new java.util.Scanner(System.in);
    System.out.println("Enter the number 2nd year Computer Engineering class students-");
    int n = scan.nextInt();
    int roll;

    Student[] student = new Student[n];  // Creating an array for obejcts

    for (int i = 0; i < n; i++) {        // Creating objects and assigning them to the array
      student[i] = new Student();
    }

    for(int i = 0; i < n; i++) {
      System.out.println("Enter the details of " + (i+1) + " student.");
      System.out.println(" RollNo : ");
      roll = scan.nextInt();

      for(int j = 0; j < i; j++) {         // this loop checks duplicates
        if(roll == student[j].RollNo) {
          System.out.println(" Duplicate RollNo, enter a new one : ");
          roll = scan.nextInt();
          j = -1;              // to run this loop again for new roll number
        }
      }
      student[i].readStudent(roll);
    }

    System.out.println("Enter the Activity set you would like to see : ");
    System.out.println(" Activity sets :");
    System.out.println(" 1 : Who play either cricket or badminton or both");
    System.out.println(" 2 : who play both cricket and badminton");
    System.out.println(" 3 : Who play only badminton");
    System.out.println(" 4 : Who play only cricket");
    System.out.println(" 5 : Who play neither cricket nor badminton");
    System.out.println("Enter the choice Number - ");
    int choice = scan.nextInt();

    for (int i = 0 ; i < n; i++) {
      switch (choice) {
        case 1 :
        if(student[i].activityStatus() == 1 || student[i].activityStatus() == 2) {
          student[i].print();
        } break;
        case 2 :
        if(student[i].activityStatus() == 3) {
          student[i].print();
        } break;
        case 3 :
        if(student[i].activityStatus() == 1) {
          student[i].print();
        } break;
        case 4 :
        if(student[i].activityStatus() == 2) {
          student[i].print();
        } break;
        case 5 :
        if(student[i].activityStatus() == 0) {
          student[i].print();
        } break;
      }
    }
  }
}
