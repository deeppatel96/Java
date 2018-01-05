package apps;

public class RadixTester {

	public static void main(String[] args) {
		
		
		int radix = 16;
		String ptr = "765B";
		int pass = 3;
		int radixvalue;
		radixvalue = Character.digit(ptr.charAt(ptr.length()-pass-1), radix);

		System.out.println(radixvalue);
		
		//int radix = sc.nextInt();
		//rs.createMasterListFromInput(sc);
		//printCLL(rs.masterListRear);
		//System.out.println(rs.getMaxDigits());
		
		
		
	}

}
