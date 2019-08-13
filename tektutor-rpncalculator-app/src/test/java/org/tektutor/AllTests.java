package org.tektutor;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Categories.class)
@SuiteClasses({ TestClass2.class, TestRPNCalcutor.class })
@IncludeCategory(SmokeTest.class)
public class AllTests {

}