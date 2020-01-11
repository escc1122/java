import org.threeten.bp.ZoneId;
import org.threeten.bp.ZoneOffset;
import org.threeten.bp.ZonedDateTime;
import org.threeten.bp.format.DateTimeFormatter;

/**
 * 參考
 * https://www.threeten.org/threetenbp/
 * https://www.threeten.org/threetenbp/update-tzdb.html
 */
public class Test {
  public static void main (String args[]){
    System.out.println(ZonedDateTime.now().toString());



    ZonedDateTime zonedDateTime = ZonedDateTime.of(2018,1,1,0,0,0,0,ZoneId.of(ZoneId.SHORT_IDS.get("PST")));

    ZonedDateTime utcDate = zonedDateTime.withZoneSameInstant(ZoneOffset.UTC);


    ZoneId zoneIdTaipei = ZoneId.of("Asia/Taipei");

    ZonedDateTime Taipei = zonedDateTime.withZoneSameInstant(zoneIdTaipei);


    System.out.println("utc : " +utcDate.toString());
    System.out.println("Taipei : " +Taipei.toString());
    System.out.println("pst : " +zonedDateTime.toString());


    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy:mm:dd HH:mm:ss");

    System.out.println("utc : " +utcDate.format(formatter));
    System.out.println("Taipei : " +Taipei.format(formatter));
    System.out.println("pst : " +zonedDateTime.format(formatter));
//2019-04-01T16:28:00.763+08:00[Asia/Taipei]
//utc : 2018-01-01T08:00Z
//Taipei : 2018-01-01T16:00+08:00[Asia/Taipei]
//pst : 2018-01-01T00:00-08:00[America/Los_Angeles]
//utc : 2018:00:01 08:00:00
//Taipei : 2018:00:01 16:00:00
//pst : 2018:00:01 00:00:00


  }
}




