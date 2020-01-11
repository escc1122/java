package com.alTest;
import java.lang.reflect.Field;
public class alTest{
  private String test1 = "123456";
  private String test2 = "test2";
  private String test3 = "test3";

    public static void main(String[] args) throws Exception {


      try {
        Class al_test_class = null;
        Object al_test_object = null;
        al_test_class = Class.forName(alTest.class.getName());
        //建立實體
        al_test_object = al_test_class.getConstructor().newInstance();


        //==============================================================================
        //取得特定欄位
        Field field_test1  = al_test_class.getDeclaredField("test1");
        field_test1.setAccessible(true);

        String r = field_test1.get(al_test_object).toString();
        System.out.println("test1===>"+r);



        //==============================================================================
        //取得全部欄位
        Field[] fields = al_test_class.getDeclaredFields();
        for (Field field : fields) {
          field.setAccessible(true);
          if (field.get(al_test_object)!=null && !"".equals(field.get(al_test_object).toString())){
            System.out.println("==="+field.getName()+"===>"+field.get(al_test_object).toString());
          }

        }



      } catch (Exception e) {
        e.printStackTrace();
      }

    }

  public void run(){
  }
}
