import java.lang.reflect.Field;

public class ProductReflectAnnotation {

  @ProductAnnotation(productName="iphone X",publishYear="2017釋出")
  private String iphoneX;//iponeX配上註解
  @ProductAnnotation(productType= ProductAnnotation.Type.電腦,productName="mac",publishYear="2018釋出")
  private String mac;//Mac配上註解
  private String noAnnotationField;//noAnnotationField不加註解

  public static void main(String[] args) {
    // 解析ProductReflectAnnotation類屬性的註解
    // getDeclaredFields方法會返回ProductReflectAnnotation類所有的屬性
    Field[] fields = ProductReflectAnnotation.class.getDeclaredFields();
    for(Field field : fields){
      //判斷屬性是否標註了@ProductAnnotation註解
      boolean fieldHasAnno = field.isAnnotationPresent(ProductAnnotation.class);
      if(fieldHasAnno){
        //獲取@ProductAnnotation註解
        ProductAnnotation product = field.getAnnotation(ProductAnnotation.class);
        //獲取@ProductAnnotation註解 引數值
        String name = product.productName();
        String publishYear = product.publishYear();
        ProductAnnotation.Type type = product.productType();
        System.out.println("[" + field.getName() + "] " + name + ","+ type + "," + publishYear);
      }
    }
  }

}
