
public class Array {

	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5, 6 };
		String name[] = { "ram", "riya", "rita", "raju" };
		System.out.println("The length is:" + a.length);
		for (int i = 0; i <= 5; i++) {
			System.out.println(a[i]);
		}
		System.out.println("The length is:" + name.length);
		for (String i : name) {
			System.out.println(i);
		}
		

	}

}
