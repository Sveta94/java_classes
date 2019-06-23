package ru.stqa.pft.sandbox;

import org.testng.Assert;
import sandbox.src.main.java.ru.stqa.pft.sandbox.Square;
import org.testng.annotations.Test;



public class SquareTests {

  @Test
  public void testArea(){

    Square s1  =  new Square(5);
     Assert.assertEquals(s1.area(), 25.0);
  }

}
