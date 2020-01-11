     //將test1的值塞入test2
     Test test1 = new Test();
      Test test2 = new Test();
      Field[] fields = Test.class.getDeclaredFields();
      try {
        for (Field field : fields) {
          field.setAccessible(true);
          //確定test1的欄位有沒有值
          if (field.get(test1)!=null && !"".equals(field.get(test1).toString())){
            System.out.println("======>"+field.get(test1).toString());
            field.set(test2,field.get(test1));
          }

        }
      }catch (Exception e){
        e.printStackTrace();
      }
