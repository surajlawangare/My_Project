package ui;

import org.testng.annotations.Test;

public class GroupTestDemo {

	@Test (priority=1, groups="regression")
	public void test1() {
		
		System.out.println("Test 1");
	}
	
	@Test (priority=2, groups="retest")
	public void test2() {
		
		System.out.println("Test 2");
	}
	
	@Test (priority=3, groups={"regression","retest"})
	public void test3() {
		
		System.out.println("Test 3");
	}
	
	@Test (priority=4, groups="retest")
	public void test4() {
		
		System.out.println("Test 4");
	}
	
}
