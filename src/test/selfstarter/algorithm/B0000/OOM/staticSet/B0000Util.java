/**
 * 
 */
package test.selfstarter.algorithm.B0000.OOM.staticSet;


/**
 * @author cuirz
 *
 */
public class B0000Util {

		 
		private String name;
		private String pswd;
		private int age;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}



		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}



		/**
		 * @return the pswd
		 */
		public String getPswd() {
			return pswd;
		}



		/**
		 * @param pswd the pswd to set
		 */
		public void setPswd(String pswd) {
			this.pswd = pswd;
		}



		/**
		 * @return the age
		 */
		public int getAge() {
			return age;
		}



		/**
		 * @param age the age to set
		 */
		public void setAge(int age) {
			this.age = age;
		}
		
		/**
		 * @param name
		 * @param pswd
		 * @param age
		 */
		public B0000Util(String name, String pswd, int age) {
			super();
			this.name = name;
			this.pswd = pswd;
			this.age = age;
		}
		

}
