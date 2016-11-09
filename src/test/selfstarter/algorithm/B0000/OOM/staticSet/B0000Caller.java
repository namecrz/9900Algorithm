/**
 * 
 */
package test.selfstarter.algorithm.B0000.OOM.staticSet;

import java.util.HashSet;
import java.util.Set;

import test.selfstarter.algorithm.B0000.OOM.staticSet.B0000Util;

/**
 * @author cuirz
 *
 */
public class B0000Caller {
	
	public static void main(String[] args) throws Exception{		
		Set<B0000Util> set = new HashSet<B0000Util>();		
		B0000Util p1 = new B0000Util("��ɮ","pwd1",25);		
		B0000Util p2 = new B0000Util("�����","pwd2",26);		
		B0000Util p3 = new B0000Util("��˽�","pwd3",27);		
		set.add(p1);		
		set.add(p2);		
		set.add(p3);		
		System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!"); //������ܹ���:3 ��Ԫ��!		
		p3.setAge(2); //�޸�p3������,��ʱp3Ԫ�ض�Ӧ��hashcodeֵ�����ı�		
				
		set.remove(p3); //��ʱremove����������ڴ�й©		
				
		set.add(p3); //������ӣ���Ȼ��ӳɹ�		
		System.out.println("�ܹ���:"+set.size()+" ��Ԫ��!"); //������ܹ���:4 ��Ԫ��!		
		for (B0000Util person : set){		
			System.out.println(person);		
		}		
	}

}
