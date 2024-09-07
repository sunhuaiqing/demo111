package org.example.demo111.TestCase;

import org.testng.Assert;
import org.testng.annotations.*;

public class TC1 {

    // 将该case 的groups标注为 mark；priority表示运行顺序
    @Test(groups = "smoke", priority = 1)
    public void testcase1() {
        Assert.assertEquals(1, 1);
        System.out.println("TC1的testcase1:被执行");
        System.out.println("");
    }

    @Test(dataProvider = "dp", priority = 1, groups = "sit") // dataProvider 获取数据驱动
    public void testcase2(Integer n, String s) {
        System.out.println("TC1的testcase2:被执行");
        System.out.println("dataProvider传参n,s：" + n + ", " + s);
        System.out.println("");
    }

    @DataProvider // 做数据驱动,数据源文件可以是EXCEL，XML，甚至可以是TXT文本
    public Object[][] dp() {
        System.out.println("Inside @DataProvider");
        return new Object[][]{new Object[]{1, "a"}, new Object[]{2, "b"},new Object[]{5, "f"}};
    }
}