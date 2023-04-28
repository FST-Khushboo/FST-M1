package Activities;

import org.testng.annotations.*;

public class TestNG_annotation
{
    @BeforeClass
    public void beforeClass()
    {
       System.out.println("Class is present");
    }
    @BeforeMethod
    public void beforeMethod()
    {
        System.out.println("Method is present");
    }
    @Test
    public void testCase1()
    {
       System.out.println("testCase1 is working fine");
    }
    @BeforeTest
    @Test
    public void testCase2()
    {
        System.out.println("testCase2 is working fine");
    }
    @AfterTest
    @AfterMethod
    public void afterMethod()
    {
        System.out.println("AfterMethod is working fine");
    }
    @AfterClass
    public void afterClass()
    {
        System.out.println("AfterClass is working fine");
    }
}
