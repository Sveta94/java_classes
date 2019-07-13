package ru.stqa.pft.addressbook.appmanager;

public class Equation {

  public int n;
  double a;
  double b;
  double c;

  public Equation(double a, double b, double c) {

    this.a = a;
    this.b = b;
    this.c = c;
    double d = b * b - 4 * a * c;

    if (a != 0) {
      if (d > 0) {
        n = 2;
      } else if (d == 0) {
        n = 1;
      } else {
        n = 0;
      }
    } else if (b != 0) {
      n = 1;
    } else if (c != 0) {
      n = 0;
    } else n = -1;
  }

  public int numberOfRoots() {
    return n;
  }

}