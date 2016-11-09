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
		B0000Util p1 = new B0000Util("唐僧","pwd1",25);		
		B0000Util p2 = new B0000Util("孙悟空","pwd2",26);		
		B0000Util p3 = new B0000Util("猪八戒","pwd3",27);		
		set.add(p1);		
		set.add(p2);		
		set.add(p3);		
		System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:3 个元素!		
		p3.setAge(2); //修改p3的年龄,此时p3元素对应的hashcode值发生改变		
				
		set.remove(p3); //此时remove不掉，造成内存泄漏		
				
		set.add(p3); //重新添加，居然添加成功		
		System.out.println("总共有:"+set.size()+" 个元素!"); //结果：总共有:4 个元素!		
		for (B0000Util person : set){		
			System.out.println(person);		
		}		
	}

}
