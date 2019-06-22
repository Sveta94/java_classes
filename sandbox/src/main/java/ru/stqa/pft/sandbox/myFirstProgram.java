package sandbox.src.main.java.ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {
 Point p1 = new Point(4,3);
 Point p2 = new Point(3,-2);

    System.out.println(distanceBetweenPoints(p1, p2));
    System.out.println(p1.distanceBetweenPoints1(p2));

  }

  public static double distanceBetweenPoints(Point p1, Point p2){
    double xDif = Math.pow((p1.x - p2.x),2);
    double yDif = Math.pow((p1.y - p2.y),2);
    return Math.sqrt(xDif + yDif);
  }

}