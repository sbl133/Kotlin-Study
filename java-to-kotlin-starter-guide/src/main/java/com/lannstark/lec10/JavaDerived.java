package com.lannstark.lec10;

public class JavaDerived extends JavaBase {

  public JavaDerived() {
    super();
    System.out.println("JavaDerivedConstructor");
  }

  @Override
  public int getMember() {
    return 10;
  }

}
