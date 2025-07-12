import java.util.*;
public class studentgrade {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("wecome to student grade claculator");
        //Take number of subjects
        System.out.println("Enter number of subjects ");
        int numsubjects = sc.nextInt();

        int[] marks = new int[numsubjects];
        int totalmarks = 0;

        //Input marks for each subject
        for (int i = 0; i<numsubjects;i++){
            System.out.println("enter marks for subject " + (i + 1) + "(out of 100)");
            marks[i] = sc.nextInt();

            //validate marks
            while (marks[i] < 0 || marks[i] > 100){
                System.out.println("invalid marks ! please enter the marks between 0 and  100");
                marks[i] = sc.nextInt();

            }
            totalmarks += marks[i];

        }

        //calculate average percentage
        double average = (double) totalmarks / numsubjects;

        //Determine grades

        char grade;
        if (average >= 90){
            grade = 'A';
        } else if (average >=80) {
            grade = 'B';
        } else if (average >= 70) {
            grade = 'C';
        } else if (average >= 60) {
            grade = 'D';
        } else if (average >= 50) {
            grade = 'E';
        }else {
            grade = 'F';
        }

        //Display Results
        System.out.println(" Result summary");
        System.out.println("Total marks  = " + totalmarks + " out of " + (numsubjects * 100 ));
        System.out.println("Average percentage  = %.2f%%\n" );
        System.out.println("Grade = "+ grade);
        sc.close();
    }
}
