package test.selfstarter.algorithm.A0000.gcd.greatest_common_divisor;

/*
 * greatest_common_divisor:
 * @parameter mod:�㷨ģʽ
 * 
 */
/*
 * 
 *
 @author ������
 @date ����
 @version �汾��ʶ
 @parameter ������������
 @since ����ʹ�ø÷���/��/�ӿڵ�JDK�汾
 @return ����ֵ
 @throws �쳣�༰�׳�����
 @deprecated �����Ƽ�ʹ�õľ���
 @see reference �鿴����
 @override ��д
 */
public class A0000Util {
	
	private String desc;

	private int a;

	private int b;

	private int smaller;

	private int larger;

	private int gcd;

	private int mod;

	private int timer = 0;

	public A0000Util(int a, int b) {

		init(a, b, 0);
		gcdCal();

	}

	/*
	 * @parameter mod :1
	 */
	public A0000Util(int a, int b, int mod) {

		init(a, b, mod);
		gcdCal();

	}

	private void init(int a, int b, int mod) {

		// to-do ������֤

		// to-do ������֤
		this.a = a;
		this.b = b;
		this.gcd = 1;
		this.mod = mod;
		order();

	}

	private void order() {

		this.smaller = Math.min(a, b);
		this.larger = Math.max(a, b);

	}

	private void timer() {
		timer += 1;
	}

	/*
	 * ���ݹ����mod������ͬ����㷨
	 */
	private void gcdCal() {

		if (mod == 0) {
			// statistics
			statistics();
		} else if (mod == 1) {
			// stein:���������+λ��1
			gcdCal_LoopMinusNew();
		} else if (mod == 2) {
			// շת���
			gcdCal_LoopDivisor();
		} else if (mod == 3) {
			// ѭ����С��
			gcdCal_LoopSmaller();
		} else if (mod == 4) {
			// շת���+RightMove1
			gcdCal_LoopDivisorNew();
		} else if (mod == 5) {
			// ���������
			gcdCal_LoopMinus();
		} else {
			// ��ʼ���쳣����ӡmod����
		}

	}

	/*
	 * ͳ��
	 * 
	 */
	
	private void statistics(){
		for (int i=1;i<=5;i++){
			gcd =1;
			mod =i;
			timer=0;
			gcdCal();
		}
	}
	
	/*
	 * ѭ����С�������Լ�� mod3 ԭ����С�������ÿһ�ֿ��� Loop: i>min(ceil(larger)/2,smaller)
	 */
	private void gcdCal_LoopSmaller() {
		this.desc = "�����㷨";
		int j = (int) ((Math.ceil(larger >> 1) < smaller) ? Math
				.ceil(larger >> 1) : smaller);
		for (int i = 1; i <= j; i++) {
			if (smaller % i == 0 && larger % i == 0) {
				gcd = i;
			}
			timer();
		}
		System.out.println(this.toString());

	}

	/*
	 * շת��������Լ�� mod2 ԭ��y%x=k...b; y=kx+b; gcd(y,x)=gcd(x,b) Loop:Recursion
	 * x%b==0
	 */
	private void gcdCal_LoopDivisor() {
		this.desc = "շת����㷨";
		gcdCal_LoopDivisor(larger, smaller);
		System.out.println(this.toString());

	}

	/*
	 * λ��շת��������Լ�� mod4 ԭ��y%x=k...b; y=kx+b; gcd(y,x)=gcd(x,b) Loop:Recursion
	 * x%b==0
	 */
	private void gcdCal_LoopDivisorNew() {
		this.desc = "λ��շת����㷨";
		gcdCal_LoopDivisorNew(larger, smaller);
		System.out.println(this.toString());

	}

	/*
	 * ��������� mod5 ԭ��y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
	 */
	private void gcdCal_LoopMinus() {
		this.desc = "����������㷨";
		gcdCal_LoopMinus(larger, smaller);
		System.out.println(this.toString());

	}

	/*
	 * ���������λ�� mod1 ԭ��y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
	 */
	private void gcdCal_LoopMinusNew() {
		this.desc = "stein�㷨";
		gcdCal_LoopMinusNew(larger, smaller);
		System.out.println(this.toString());
	}

	/*
	 * շת��������Լ�� mod2
	 */
	private void gcdCal_LoopDivisor(int l, int s) {

		int m;

		if (l % s == 0) {
			timer();
			gcd *= s;

		} else {

			timer();

			m = l % s;

			// ��Ϊ����<����
			gcdCal_LoopDivisor(s, m);

		}
	}

	/*
	 * շת���λ�������Լ�� mod4
	 */
	private void gcdCal_LoopDivisorNew(int l, int s) {

		int m;
		int ll;
		int ss;

		if (l % s == 0) {
			timer();
			gcd *= s;

		} else {

			if (l % 2 == 0 && s % 2 == 0) {

				gcd *= 2;

				gcdCal_LoopDivisorNew(l >> 1, s >> 1);

			} else if (l % 2 == 0 && s % 2 != 0) {

				ll = Math.max(l >> 1, s);
				ss = Math.min(l >> 1, s);

				gcdCal_LoopDivisorNew(ll, ss);

			} else if (l % 2 != 0 && s % 2 == 0) {

				gcdCal_LoopDivisorNew(l, s >> 1);

			} else if (l % 2 != 0 && s % 2 != 0) {

				timer();
				m = l % s;

				// ��Ϊ����<����
				gcdCal_LoopDivisorNew(s, m);

			}

		}

	}

	/*
	 * ��������������Լ�� mod5 ԭ��y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
	 */
	private void gcdCal_LoopMinus(int l, int s) {

		int mi = l - s;
		int ll;
		int ss;

		if (mi == 0) {
			timer();
			gcd = s;

		} else if (s == mi) {
			timer();
			gcd = mi;

		} else {

			timer();
			ll = Math.max(s, mi);
			ss = Math.min(s, mi);

			gcdCal_LoopMinusNew(ll, ss);
		}

	}

	/*
	 * ���������λ�������Լ�� mod1 ԭ��y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
	 */
	private void gcdCal_LoopMinusNew(int l, int s) {

		int mi = l - s;
		int ll;
		int ss;

		if (mi == 0) {
			timer();
			gcd *= s;

		} else if (s == mi) {
			timer();
			gcd *= mi;

		} else {

			if (l % 2 == 0 && s % 2 == 0) {
				gcd *= 2;
				gcdCal_LoopMinusNew(l >> 1, s >> 1);
			} else if (l % 2 != 0 && s % 2 == 0) {
				gcdCal_LoopMinusNew(l, s >> 1);
			} else if (l % 2 == 0 && s % 2 != 0) {
				ll = Math.max(l >> 1, s);
				ss = Math.min(l >> 1, s);
				gcdCal_LoopMinusNew(ll, ss);
			} else if (l % 2 != 0 && s % 2 != 0) {

				timer();
				ll = Math.max(s, mi);
				ss = Math.min(s, mi);
				gcdCal_LoopMinusNew(ll, ss);

			}
		}

	}

	/**
	 * @return the a
	 */
	public int getA() {
		return a;
	}

	/**
	 * @param a
	 *            the a to set
	 */
	public void setA(int a) {
		this.a = a;
	}

	/**
	 * @return the b
	 */
	public int getB() {
		return b;
	}

	/**
	 * @param b
	 *            the b to set
	 */
	public void setB(int b) {
		this.b = b;
	}

	/**
	 * @return the b
	 */
	public int getGcd() {
		return gcd;
	}

	public String toString() {
		return "A0000Util [a=" + a + ", b=" + b + ", gcd=" + gcd + ", mod="
				+ mod + ", timer=" + timer +", desc="+desc+"]";
	}

}
