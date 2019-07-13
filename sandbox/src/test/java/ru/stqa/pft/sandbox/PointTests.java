package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


  public class PointTests {
    @Test
    public void pointTest(){
      Point p1 = new Point(4,3);
      Point p2 = new Point(3, -2);
      Assert.assertEquals(p1.distanceBetweenPoints1(p2), 5.0990195135927845);

    }

    @Test
    public void pointTest1(){
      Point p1 = new Point(8,2);
      Point p2 = new Point(6, 15);
      Assert.assertEquals(p1.distanceBetweenPoints1(p2), 13.152946437965905);

    }
  }


