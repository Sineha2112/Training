import java.util.Scanner;

public class LoanCalculator {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter Account user name:");
		String name=sc.next();
		System.out.println("enter the principle amount:");
		int prin=sc.nextInt();
		System.out.println("enter the interest percentage:");
		int inte=sc.nextInt();
		System.out.println("enter the term:");
		int term=sc.nextInt();
		int rate=(prin/inte)*term;
		System.out.println("Rate os interest:"+rate);
		int total=prin+rate;
		System.out.println("total amount to be paid:"+total);
		int month=total/(term*12);
		System.out.println("paid per month:"+month);
		for(int i=total;i>=0;) {
			System.out.println(""+i);
			i=i-month;
		}
	}
}
