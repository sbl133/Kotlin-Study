package com.lannstark.lec12;

public class Lec12Main {

  public static void main(String[] args) {
//    Person.Companion.newBaby("ABC");
    Person.Factory.newBaby("ABC");
    Person.newBaby("ABC"); // @JvmStatic 필요
  }

}
