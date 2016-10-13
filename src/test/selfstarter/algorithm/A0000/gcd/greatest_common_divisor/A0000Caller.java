package test.selfstarter.algorithm.A0000.gcd.greatest_common_divisor;

public class A0000Caller {

	public static void main(String[] args) {
		
		int a = 953245256;
		int b = 612416;
		int mod = 0;
		
		A0000Util u =new A0000Util(a, b,mod);

		System.out.println("Gcd: "+u.getGcd());
			
	}
	
}
