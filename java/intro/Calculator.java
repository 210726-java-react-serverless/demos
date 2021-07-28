public class Calculator {

	public static void main(String[] args) {
	
		if (args.length != 3) {
			System.err.println("You must provide three parameters to this application! (e.g. an operation and two operands)");
			return;
		}
		
		String operator = args[0];
		int operand1 = Integer.parseInt(args[1]);
		int operand2 = Integer.parseInt(args[2]);
		
		switch (operator) {
		
		case "+":
			System.out.println("The result of the operation is: " + (operand1 + operand2));
			break;
			
		case "-":
			System.out.println("The result of the operation is: " + (operand1 - operand2));
			break;
			
		default:
			System.err.println("Provided operator not supported!");
		
		}
		
		
	
	}

}
