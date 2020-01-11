import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ProductAnnotation {

  //型別列舉
  public enum Type {
    手機, 電腦, 平板
  }

  ;

  //商品型別
  Type productType() default Type.手機;

  //商品釋出時間
  String publishYear() default "";

  //商品名稱
  String productName() default "";
}
