import java.util.Scanner;

public class CricketScore {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the team name:");
		String team1=sc.next();
		System.out.println("enter another team name:");
		String team2=sc.next();
		System.out.println("enter team1 score:");
		int score1=sc.nextInt();
		System.out.println("enter team2 score:");
		int score2=sc.nextInt();
		if(score1>score2) {
			System.out.println(team1+" wins the game");
		}
		else {
			System.out.println(team2+" wins the game");
		}

	}

}
