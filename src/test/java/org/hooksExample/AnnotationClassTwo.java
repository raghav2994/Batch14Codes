package org.hooksExample;

import org.testng.annotations.*;

public class AnnotationClassTwo {
//
//    @BeforeSuite
//    public void beforeSuiteMethod(){
//        System.out.println("Before Suite is executed for AnnotationClassTwo");
//    }
//
//    @BeforeMethod
//    public void beforeMethodMethod(){
//        System.out.println("Before Method is executed for AnnotationClassTwo");
//    }


    @Test(groups = {"Sanity"})
    public void testOne(){
        System.out.println("Test 1 is executed for AnnotationClassTwo");
    }
//
//    @AfterClass
//    public void afterClassMethod(){
//        System.out.println("After Class is executed for AnnotationClassTwo");
//    }

}
