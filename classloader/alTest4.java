package com.dec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServlet;

/**
 * Created by alma on 2015/12/3.
 */
public class alTest4 extends HttpServlet {
  protected static Logger logger = LoggerFactory.getLogger(alTest4.class);
  public static FooP foop=null;
  static {
    logger.info("alTest4 Start!!");
    try {
//      FooP foo = new FooP();
//      logger.info(foo.getClass().getClassLoader().toString());
      byte rawKey[] = Util.readFile("alTest" , "C:/classes//");
//      URL url = new URL("file:C:/nineder-dev/workspace/shopping99/classes/");

      FileSystemClassLoader2 f = new FileSystemClassLoader2("C://classes",rawKey);
      Class clasz = f.findClass("com.dec.Foo");
//      clasz.newInstance();
      System.out.println("forname=========================");
      System.out.println("Foo====>" + clasz.getClassLoader());
      System.out.println("FooP====>" + FooP.class.getClassLoader());
//      Class forname = Class.forName("com.dec.Foo",true,f);
//      System.out.println("foo====>" + foo.getClass().getClassLoader());
      FooP foop = (FooP)clasz.newInstance();
      System.out.println("Class FooP =====>"+foop);
      FooP.fooP = foop;
//      foop=foo;
//      FooP foo = Foo.getInstance();
//      foo.test();

    }catch (ClassNotFoundException e){
      System.out.print("ClassNotFoundException");
    }catch (Exception e){
      System.out.println("alTest4 error");
      e.printStackTrace();
    }
  }//end method

}
