package test.selfstarter.algorithm.A0002.bigNum.bigNum;

/**
 * bigNum:
 * @parameter mod:算法模式
 * 
 * @author 作者名
 * @date 日期
 * @version 版本标识
 * @parameter 参数及其意义
 * @since 最早使用该方法/类/接口的JDK版本
 * @return 返回值
 * @throws 异常类及抛出条件
 * --@deprecated 引起不推荐使用的警告
 * @see reference 查看引用
 * @override 重写
 * 
 */
public class A0002Util { 
	
	private String desc;
	
	private int mod;

	private int[] a;
	
	private int[] b;

	private int[] ra;
	
	private int[] rb;

	private int[] odd;
	
	private int[] carry;
	
	private int[] rsum;
	
	private int[] sum;
	
	private int[] diff;//difference 
	
	private int[] pro;//product 
	
	private int[] quot ;//quotient 

	private int timer = 0;
	
	private void init(int[] a, int[] b, int mod){
		
		this.a=a;
		this.b=b;
		ra=reverse(a);
		rb=reverse(b);
		this.mod=mod;
		
	}
	
	public A0002Util(int[] a, int[] b) {

		init(a, b, 0);
		cal();

	}
	
	public A0002Util(int[] a, int[] b, int mod) {

		init(a, b, mod);
		cal();

	}
	
	private void cal(){
		
		if (mod == 0){
			
			calSum();
			calDiff();
			calPro();
			calQuot();
			
		}else if (mod == 1){
			
		}else if (mod == 2){
			
		}else if (mod == 3){
			
		}else if (mod == 4){
			
		}
		
	}

	private void calSum(){
		
	}
	
	private void calDiff(){
			
	}
	
	private void calPro(){
		
	}
	
	private void calQuot(){
		
	}
	
	private int[] reverse(int[] t){
		
		return t;
		
	}
	
	
}
