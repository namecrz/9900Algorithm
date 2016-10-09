package test.selfstarter.algorithm.A0000.gcd.greatest_common_divisor;

public class A0000Caller {

	public static void main(String[] args) {
		int a = 100000;
		int b = 501;
		int mod = 3;
		int gcd;
		A0000Util u =new A0000Util(a, b, mod);
		gcd = u.getGcd();
		System.out.println("a: "+a+"\n"+"b: "+b+"\n"+"mod: "+mod+"\n"+"gcd:"+gcd);
		System.out.println("Hello Git !");
		
	}
	
}
