import java.util.Random;
import java.util.Scanner;
public class numberGame{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int chances = 5;
        int score=0;
        boolean playAgain=true;
        System.out.println("Lets's start to play!!!!!");
        System.out.println("You have the   "+chances+"  to win the game");

        Random randomNum = new Random();  
        while(playAgain){
            int random = randomNum.nextInt(100);
            boolean guess=false;
            for(int i =0;i<chances;i++){
                System.out.println("chance " +(i+1)+" Enter your guess within range 1 to 100 :");
                int userNum = sc.nextInt();
                if(userNum==random){
                    guess=true;
                    score= score+1;
                    System.out.println("Congratulations!!!You won it.");
                    break;
                }else if(userNum>random){
                    System.out.println("Too High");
                }else{
                    System.out.println("Too Low");
                }
            }
            if(guess==false){
                System.out.println("Oops!!!You lost the chances . The number is "+random);
            }
            System.out.println("Do You Want To Play Again(Y/N)");
            String want = sc.next();
            playAgain=want.equalsIgnoreCase("y");   
        }
        System.out.println("+++++Hope you enjoyed it++++");
        System.out.println("+++++Here is your Score "+score+" ++++");
    }
}