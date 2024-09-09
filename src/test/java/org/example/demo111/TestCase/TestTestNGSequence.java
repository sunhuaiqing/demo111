package org.example.demo111.TestCase;

import org.springframework.boot.test.context.SpringBootTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.*;

@SpringBootTest
public class TestTestNGSequence {
    int i;
    int testParam = 5;

    @Test(priority = 1 ,enabled = true, groups = "success")
    public void Addition_11() {
        System.out.println("Test03的测试用例：Addition_11，开始执行~");
        int result = 1 + 2;
        Assert.assertEquals(result, 3, "Addition result should be 3");
        System.out.println("");
    }

    @Test(priority = 1 ,enabled = true, groups = "system")
    public void testDivision() {
        System.out.println("Test03的测试用例：testDivision，开始执行~");
        int result = 6 / 2;
        Assert.assertEquals(result, 3, "Division result should be 3");
        System.out.println("");
    }

    //@Parameters({"testParam"})
    @Test( dataProvider="testParam", priority = 2 ,enabled = true, groups = "success")
    public void test_Parameters(String testParam) {
        System.out.println("Test03的测试用例：test_Parameters，开始执行~");
        System.out.println("test_Parameters:传入的参数testParam:" + testParam);
        System.out.println("");
    }

    @DataProvider(name="testParam")
    public String[] testParam(){
        String[] str = {"dddddddd","kkkkkk","mmmmm123"} ;
        return str;
    }

    @BeforeSuite()
    public void BeforeSuite() {
        System.out.println("Test03的 BeforeSuite:被执行");
        System.out.println("");
    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("Test03的 BeforeTest:被执行");
        System.out.println("");
    }

    @BeforeGroups
    public void BeforeGroups() {
        System.out.println("Test03的 BeforeGroups:被执行");
        System.out.println("");
    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("Test03的 BeforeClass:被执行");
        System.out.println("");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("Test03的 BeforeMethod:被执行");
        System.out.println("");
    }

    @AfterSuite()
    public void AfterSuite() {
        System.out.println("Test03的 AfterSuite:被执行");
        System.out.println("");
    }

    @AfterTest
    public void AfterTest() {
        System.out.println("Test03的 AfterTest:被执行");
        System.out.println("");
    }

    @AfterGroups
    public void AfterGroups() {
        System.out.println("Test03的 AfterGroups:被执行");
        System.out.println("");
    }

    @AfterClass
    public void AfterClass() {
        System.out.println("Test03的 AfterClass:被执行");
        System.out.println("");
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("Test03的 AfterMethod:被执行");
        System.out.println("");
    }


}