package test.selfstarter.algorithm.A0000.gcd.greatest_common_divisor;

/*
 * greatest_common_divisor:
 * 
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
	
	private int a;
	
	private int b;
	
	private int smaller;
	
	private int larger;
	
	private int gcd;
	
	private int mod;
	
	private int timer = 0;
	
	public A0000Util(int a,int b){
		
		init(a,b,0);
		gcdCal();
		
	}
	
	public A0000Util(int a,int b,int mod){
		
		init(a,b,mod);
		gcdCal();
		
	}
	
	private void init(int a, int b,int mod){
		
		//to-do 数据验证
		
		//to-do 数据验证
		this.a=a;
		this.b=b;
		this.mod=mod;
		order();
		
	}
	
	private void order(){
		
		this.smaller = Math.min(a,b);
		this.larger = Math.max(a,b);
		
	}
	
	private void timer(){
		timer += 1;
	}
	
	/*
	 * 根据构造的mod，走向不同求解算法
	 */
	private void gcdCal(){ 
		
		if (mod == 0){
		//更相减损数位移	
		}else if(mod == 1){
		//更相减损数	
		}else if(mod == 2){
		//辗转相除
		gcdCal_LoopDivisor();
		}else if(mod == 3){
		//循环最小数
		gcdCal_LoopSmaller();
		}else{
		//初始化异常，打印mod设置	
		}
		
	}
	
	/*
	 * 循环较小数求最小公倍数 mod3
	 * 原理：从小到大便利每一种可能
	 * Loop: i>min(ceil(larger)/2,smaller)
	 */
	private void gcdCal_LoopSmaller(){ 
		
		int j=(int) ((Math.ceil(larger>>1)<smaller)?Math.ceil(larger>>1):smaller);
		for(int i=1;i<=j;i++){
			if (smaller%i == 0 && larger%i == 0){
				gcd = i;
			}
			timer();
		}
		
	}
	
	/*
	 * 辗转相除求最小公倍数 mod2
	 * 原理：y%x=k...b; y=kx+b; gcd(y,x)=gcd(x,b)
	 * Loop:Recursion x%b==0  
	 */
	private void gcdCal_LoopDivisor(){ 
		
		gcdCal_LoopDivisor(larger , smaller);
		
	}
	
	/*
	 * 辗转相除求最小公倍数 mod2
	 */
	private void gcdCal_LoopDivisor(int l , int s){ 
		
		timer();
		
		int m;
		int a;
		int b;
		
		if (l%s==0){
			
			gcd = s ;
			
		}else{
			
			if (l%2 == 0 && s%2 == 0 ){
				
			}else if(l%2 == 0 && s%2 != 0 ){
				
			}else if(l%2 != 0 && s%2 == 0 ){
				
			}else if(l%2 != 0 && s%2 != 0 ){
				if (l%s==0){
					gcd = s ;
					
				}else{
	
					m=l%s;
					
					//因为余数<除数
					gcdCal_LoopDivisor(s,m);
					
				}
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
	 * @param a the a to set
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
	 * @param b the b to set
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
				+ mod + ", timer=" + timer + "]";
	}
	
	
	
}
