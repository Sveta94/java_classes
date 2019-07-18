package ru.stqa.pft.sandbox;

import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {
    String[] langs = {"Java", "PHP", "Python", "C#"};
//      new String[4];
//    langs[0] = "Java";
//    langs[1] = "C#";
//    langs[2] = "Python";
//    langs[3] = "PHP";

//    for (int i = 0; i< langs.length; i++){
//      System.out.println("I want to learn " + langs[i]);}

    for (String l : langs) {
      System.out.println("I want to learn " + l);
    }

//    List<String> languages = new ArrayList<String>();
//    languages.add("Java");
//    languages.add("C#");
//    languages.add("Javascript");
    List<String> languages = Arrays.asList("Java", "C#", "C++", "Python");

    for (String l : languages) {
      System.out.println("I want to learn " + l);
    }
    for (int i = 0; i < languages.size(); i++){
      System.out.println("I want to learn " + languages.get(i));
    }

    // it is also possible to have a list of mixed types:

    List programminglangs = Arrays.asList("Java", "C#", "C++", "Python");

    for (Object l : programminglangs) {
      System.out.println("I want to learn " + l);
    }
  }
}
