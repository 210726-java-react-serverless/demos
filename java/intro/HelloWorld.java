public class HelloWorld {

	public static void main(String[] args) {
		
		System.out.println("Hello, world!");
		
		if (args.length == 1) {
			System.out.println("Provided argument: " + args[0]);
		} else {
			System.out.println("No arguments provided!");
		}
		
	}

}
