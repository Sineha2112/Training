import java.util.Scanner;

public class Check {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter length:");
		int length=sc.nextInt();
		System.out.println("enter breadth:");
		int breadth=sc.nextInt();
		if(length==breadth) {
			System.out.println("It's a square");
		}
		else {
			System.out.println("It's a rectangle");
		}

	}

}
