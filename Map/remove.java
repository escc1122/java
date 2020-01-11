    Map<String ,String> map = new HashMap<String,String>();
    Iterator<String> map_iterator = map.iterator();
    while (map_iterator.hasNext()){
      String key = map_iterator.next();
      map_iterator.remove();
    }
