<%
  System.out.print(alTest4.foop);
  try {
    System.out.print(FooP.getInstance());
    FooP.getInstance().test();
  }catch (Exception e){
    System.out.println("jsp error");
    e.printStackTrace();
  }

%>
