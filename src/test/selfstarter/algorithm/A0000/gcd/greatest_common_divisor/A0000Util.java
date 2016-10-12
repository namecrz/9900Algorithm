package test.selfstarter.algorithm.A0000.gcd.greatest_common_divisor;

/*
 * greatest_common_divisor:
 * @parameter mod:算法模式
 * 
 */
/*
 * 
 *
 @author 作者名
 @date 日期
 @version 版本标识
 @parameter 参数及其意义
 @since 最早使用该方法/类/接口的JDK版本
 @return 返回值
 @throws 异常类及抛出条件
 @deprecated 引起不推荐使用的警告
 @see reference 查看引用
 @override 重写
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

		// to-do 数据验证

		// to-do 数据验证
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
	 * 根据构造的mod，走向不同求解算法
	 */
	private void gcdCal() {

		if (mod == 0) {
			// statistics
			statistics();
		} else if (mod == 1) {
			// stein:更相减损数+位移1
			gcdCal_LoopMinusNew();
		} else if (mod == 2) {
			// 辗转相除
			gcdCal_LoopDivisor();
		} else if (mod == 3) {
			// 循环最小数
			gcdCal_LoopSmaller();
		} else if (mod == 4) {
			// 辗转相除+RightMove1
			gcdCal_LoopDivisorNew();
		} else if (mod == 5) {
			// 更相减损术
			gcdCal_LoopMinus();
		} else {
			// 初始化异常，打印mod设置
		}

	}

	/*
	 * 统计
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
	 * 循环较小数求最大公约数 mod3 原理：从小到大便利每一种可能 Loop: i>min(ceil(larger)/2,smaller)
	 */
	private void gcdCal_LoopSmaller() {
		this.desc = "遍历算法";
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
	 * 辗转相除求最大公约数 mod2 原理：y%x=k...b; y=kx+b; gcd(y,x)=gcd(x,b) Loop:Recursion
	 * x%b==0
	 */
	private void gcdCal_LoopDivisor() {
		this.desc = "辗转相除算法";
		gcdCal_LoopDivisor(larger, smaller);
		System.out.println(this.toString());

	}

	/*
	 * 位移辗转相除求最大公约数 mod4 原理：y%x=k...b; y=kx+b; gcd(y,x)=gcd(x,b) Loop:Recursion
	 * x%b==0
	 */
	private void gcdCal_LoopDivisorNew() {
		this.desc = "位移辗转相除算法";
		gcdCal_LoopDivisorNew(larger, smaller);
		System.out.println(this.toString());

	}

	/*
	 * 更相减损术 mod5 原理：y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
	 */
	private void gcdCal_LoopMinus() {
		this.desc = "更相减损术算法";
		gcdCal_LoopMinus(larger, smaller);
		System.out.println(this.toString());

	}

	/*
	 * 更相减损术位移 mod1 原理：y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
	 */
	private void gcdCal_LoopMinusNew() {
		this.desc = "stein算法";
		gcdCal_LoopMinusNew(larger, smaller);
		System.out.println(this.toString());
	}

	/*
	 * 辗转相除求最大公约数 mod2
	 */
	private void gcdCal_LoopDivisor(int l, int s) {

		int m;

		if (l % s == 0) {
			timer();
			gcd *= s;

		} else {

			timer();

			m = l % s;

			// 因为余数<除数
			gcdCal_LoopDivisor(s, m);

		}
	}

	/*
	 * 辗转相除位移求最大公约数 mod4
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

				// 因为余数<除数
				gcdCal_LoopDivisorNew(s, m);

			}

		}

	}

	/*
	 * 更相减损术求最大公约数 mod5 原理：y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
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
	 * 更相减损术位移求最大公约数 mod1 原理：y-x=b; gcd(y,x)=gcd(x,b) Loop:Recursion x==b
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
