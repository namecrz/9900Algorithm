package test.selfstarter.algorithm.A0000.gcd.greatest_common_divisor;

public class A0000Caller {

	public static void main(String[] args) {
		
		int a = 486721269;
		int b = 481245436;
		int mod = 2;
		A0000Util u =new A0000Util(a, b, mod);
		//A0000Util [a=486721269, b=481245436, gcd=1, mod=3, timer=243360634]
		//A0000Util [a=486721269, b=481245436, gcd=1, mod=2, timer=15]
		System.out.println(u.toString());
			
	}
	
}
