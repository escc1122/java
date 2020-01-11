  public static Object serializableClone(Object o) throws CloneNotSupportedException {
    ByteArrayOutputStream bos = null;
    ObjectOutputStream oos = null;
    ByteArrayInputStream bis = null;
    ObjectInputStream ois = null;
    try {
      //將該對象序列化成流,因為寫在流裡的是對象的一個拷貝，而原對象仍然存在於JVM裡面。所以利用這個特性可以實現對象的深拷貝
      bos = new ByteArrayOutputStream();

      oos = new ObjectOutputStream(bos);

      oos.writeObject(o);

      //將流序列化成對象
      bis = new ByteArrayInputStream(bos.toByteArray());

      ois = new ObjectInputStream(bis);

      return ois.readObject();
    }catch (Exception e){
      e.printStackTrace();
      throw new CloneNotSupportedException();
    }finally {
      try{
        bos = null;
        bis = null;
        if(oos != null) oos.close();
        if(ois != null) ois.close();
      }catch(IOException e){
      }
    }
  }
