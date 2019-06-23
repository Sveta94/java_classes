package ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
 Point p1 = new Point(8,2);
 Point p2 = new Point(6,15);


    System.out.println(distanceBetweenPoints(p1, p2));
    System.out.println(p1.distanceBetweenPoints1(p2));

  }

  public static double distanceBetweenPoints(Point p1, Point p2){
    double xDif = Math.pow((p1.x - p2.x),2);
    double yDif = Math.pow((p1.y - p2.y),2);
    return Math.sqrt(xDif + yDif);
  }

}