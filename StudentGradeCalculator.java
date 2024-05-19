import java.util.Scanner;

public class StudentGradeCalculator{
    public static void AveragePercentageCalculation(int totalSub){
        Scanner sc=new Scanner(System.in);
        float totalMarks=0;
        float avgPercentage=0;
        for(int i=0;i<totalSub;i++){
            System.out.println("Enter the marks of subject " + (i+1));
            totalMarks += sc.nextInt();
        }
        avgPercentage = (totalMarks/(totalSub*100))*100;
        String grade ="";
        if(avgPercentage>95){
            grade="A+";
        }
        else if(avgPercentage>90){
            grade="A";
        }
        else if(avgPercentage>85){
            grade="B+";
        }
        else if(avgPercentage>80){
            grade="B";
        }
        else if(avgPercentage>75){
            grade="C+";
        }
        else if(avgPercentage>70){
            grade="C";
        }
        else if(avgPercentage>65){
            grade="D+";
        }
        else if(avgPercentage>60){
            grade="D";
        }
        else{
            grade="F";
        }
        
        System.out.println("Total marks = " + totalMarks + "\nAverage Percentage = " + avgPercentage + "\nGrade = " + grade);
    }

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the total number of subjects.");
        int totalSubject=sc.nextInt();
        AveragePercentageCalculation(totalSubject);
    }
}