package com.dec;


public class FooP {
  protected static FooP fooP=null;
  public void test(){
    System.out.println("Foop test");
    fooP.test();
  }

  public static FooP getInstance(){
    return fooP;
  }


}
