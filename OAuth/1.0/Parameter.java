import java.util.ArrayList;
import java.util.List;

public class Parameter implements Comparable<Parameter>
{
  private final String key;
  private final String value;

  public Parameter(String key, String value)
  {
    this.key = key;
    this.value = value;
  }

  public boolean equals(Object other)
  {
    if(other == null) return false;
    if(other == this) return true;
    if(!(other instanceof Parameter)) return false;

    Parameter otherParam = (Parameter) other;
    return otherParam.key.equals(key) && otherParam.value.equals(value);
  }

  public int hashCode()
  {
    return key.hashCode() + value.hashCode();
  }

  public int compareTo(Parameter parameter)
  {
    int keyDiff = key.compareTo(parameter.key);

    return keyDiff != 0 ? keyDiff : value.compareTo(parameter.value);
  }

  public static List<Parameter> transQueryString(String query){
    List<Parameter> para = new ArrayList<Parameter>();
    if (query!=null){
      if (query.indexOf("&")>0){
        String[] tmp = query.split("&");
        for (String a : tmp){
          if (a.indexOf("=")>0){
            try {
              String[] tmp2 = a.split("=");
              Parameter b = new Parameter(tmp2[0],tmp2[1]);
              para.add(b);
            }catch (Exception e){
              System.out.println("陣列分割異常");
            }
          }
        }
      }
    }
    return para;
  }

  public String getKey(){
    return key;
  }
  public String getValue(){
    return value;
  }
}
