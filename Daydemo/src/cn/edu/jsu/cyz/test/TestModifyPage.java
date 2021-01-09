package cn.edu.jsu.cyz.test;

import junit.framework.TestCase;
import cn.edu.jsu.cyz.frm.ModifyPage;
public class TestModifyPage extends TestCase{
	 public void testfind() {
		 String sql="select *from staff where JobNumber=10001";
		 boolean bl=ModifyPage.find(sql);
		 assertTrue(bl==true);
	 }

}
