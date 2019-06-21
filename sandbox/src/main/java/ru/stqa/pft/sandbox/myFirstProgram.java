package sandbox.src.main.java.ru.stqa.pft.sandbox;

public class MyFirstProgram {

  public static void main(String[] args) {

   hello("Sveta");
   hello("user");

   double l = 5;
   double a = 8;
   double b = 9;

    System.out.println("The area of a square with a side of " + l + " = " + area(l));

    System.out.println("The area of a rectangle with sides of " + a + " and " +  b  + " = " + area(a, b));

  }

  public static void hello(String somebody){
    System.out.println("Hello " + somebody + "!");
  }
  public static double area (double len){
    return len * len;

  }
  public static double area (double a, double b){
    return a * b;

  }

}