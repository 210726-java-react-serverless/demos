public class IntegerPoolDemo {

	public static void main(String[] args) {
	
		Integer i1 = 127; // autoboxing; the primitive int value "127" is automatically "boxed" into the Integer object
		Integer i2 = 127;
		Integer i3 = new Integer(127);
		Integer i4 = 128;
		Integer i5 = 128;
		Integer i6 = -128;
		Integer i7 = -128;
		
		System.out.println(i1 == i2); // true
		System.out.println(i1 == i3); // false
		System.out.println(i1.equals(i3)); // true
		System.out.println(i4 == i5); // false, because the Integer pool does not store values greater than 127
		System.out.println(i6 == i7); // true, the Integer Pool holds values -128 to +127
		
	}

}
