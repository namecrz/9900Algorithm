package test.selfstarter.algorithm.A0000.gcd.greatest_common_divisor;

/*
 * greatest_common_divisor:
 * 
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
		
		//to-do ������֤
		
		//to-do ������֤
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
	 * ���ݹ����mod������ͬ����㷨
	 */
	private void gcdCal(){ 
		
		if (mod == 0){
		//���������λ��	
		}else if(mod == 1){
		//���������	
		}else if(mod == 2){
		//շת���	
		}else if(mod == 3){
		//ѭ����С��
		gcdCal_LoopSmaller();
		}else{
		//��ʼ���쳣����ӡmod����	
		}
		
	}
	
	/*
	 * ѭ����С������С������
	 */
	private void gcdCal_LoopSmaller(){ 
		
		int j=(int) ((Math.ceil(larger>>1)>smaller)?Math.ceil(larger>>1):smaller);
		for(int i=1;i<=j;i++){
			if (smaller%i == 0 && larger%i == 0){
				gcd = i;
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
	
	public String toString(){
		String o = "  a: "+a+"\n"+"  b: "+b+"\n"+"mod: "+mod+"\n"+"gcd: "+gcd;
		return o;
	}
	
	
	
}
