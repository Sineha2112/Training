import java.util.Scanner;

public class MedicalCause {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the number of classes held:");
		int numOfClassesHeld=sc.nextInt();
		System.out.println("enter the number of classes you attended:");
		int numOfClassesAttended=sc.nextInt();
		float percentage=(float)((numOfClassesAttended*100)/numOfClassesHeld);
		System.out.println("percentage of class attended:"+percentage+"%");
		System.out.println("enter if you have any medical cause:");
		String cause=sc.next();
		if(percentage>=75) {
			System.out.println("you can write the exam");
			if(cause.equals("yes")) {
				System.out.println("you can sit in the exam");
			}
			else {
				System.out.println("you can't sit in the exam");
			}	
		
		}
		else {
			System.out.println("you can't write the exam");
		}
	}
}

