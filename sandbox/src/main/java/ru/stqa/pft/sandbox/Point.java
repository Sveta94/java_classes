package ru.stqa.pft.sandbox;

public class Point {

  double x, y;

  Point(double x, double y){
    this.x = x;
    this.y = y;

  }

  public  double distanceBetweenPoints1(Point p2){
    double xDif = Math.pow((this.x - p2.x),2);
    double yDif = Math.pow((this.y - p2.y),2);
    return Math.sqrt(xDif + yDif);
  }


}
