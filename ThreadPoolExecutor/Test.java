import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {

  public static void main(String[] args){
    ThreadPoolExecutor executor =
            (ThreadPoolExecutor) Executors.newFixedThreadPool(5);

    List<Integer> aaa = new ArrayList<>();


    for (int i = 0 ; i<100 ;i++){
      aaa.add(i);
    }

    for (Integer i : aaa){
      executor.submit(()->{
        System.out.println(i);
      });
    }
    executor.shutdown();
  }
//0
//3
//4
//2
//1
//9
//10
//8
//7
//6
//14
//15
//5
//16
//13
//12
//11
//21
//22
//20
//19
//25
//18
//17
//28
//27
//30
//31
//26
//33
//34
//24
//36
//37
//23
//38
//40
//35
//32
//43
//44
//29
//46
//47
//48
//49
//45
//51
//52
//42
//41
//55
//56
//39
//57
//54
//53
//60
//50
//62
//61
//59
//58
//66
//65
//69
//64
//63
//71
//70
//68
//67
//75
//74
//73
//72
//80
//81
//79
//78
//77
//76
//85
//86
//84
//89
//83
//82
//91
//93
//94
//95
//96
//97
//98
//99
//90
//88
//87
//92
}
