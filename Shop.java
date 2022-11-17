import java.util.Scanner;

public class Shop {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your quantity:");
		int pur=sc.nextInt();
		if(pur>1000) {
			System.out.println("the discount for your purchase is:"+(pur-(pur/100)*10));
			
		}
		else {
			System.out.println("the total cost is:"+pur);
		}
		 
	}

}
