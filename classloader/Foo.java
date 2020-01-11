package com.dec;
// Foo.java

public class Foo extends FooP
{
  public static void main (String[] args){
    System.out.println("test");
  }

  public void test(){
    System.out.println( "Foo test" );
  }

  public static FooP getInstance() {
    try {
      byte rawKey[] = Util.readFile("alTest" , "");

      FileSystemClassLoader2 f = new FileSystemClassLoader2("C://classes",rawKey);
      Class clasz = f.findClass("com.dec.Foo");
      return (FooP)clasz.newInstance();
    }catch (Exception e){
      System.out.println("test");
      e.printStackTrace();
      return null;
    }
  }
}
