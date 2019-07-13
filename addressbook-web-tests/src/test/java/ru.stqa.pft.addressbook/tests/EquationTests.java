package ru.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.appmanager.Equation;



public class EquationTests {

  @Test

  public void test0() {
    Equation e = new Equation(1, 1, 1);
    Assert.assertEquals(e.numberOfRoots(),0);
  }

  @Test

  public void test1() {
    Equation e = new Equation(1, 2, 1);
    Assert.assertEquals(e.numberOfRoots(),1);
  }

  @Test

  public void test2() {
    Equation e = new Equation(1, 5, 6);
    Assert.assertEquals(e.numberOfRoots(),2);
  }
  @Test
  public void testA0() {
    Equation e = new Equation(0, 5, 6);
    Assert.assertEquals(e.numberOfRoots(),1);
  }
  @Test
  public void testA0B0() {
    Equation e = new Equation(0, 0, 6);
    Assert.assertEquals(e.numberOfRoots(),0);
  }
  @Test
  public void testA0B0C0() {
    Equation e = new Equation(0, 0, 0);
    Assert.assertEquals(e.numberOfRoots(),-1);
  }

}
