#classloader加密

試著使用自定的classloader去讀取class,並且該class繼承自一個正常系載入的父類

想達成利用一個系統定義的父類去操作自定義的子類

##程式
[Foo.java](https://github.com/escc1122/java/blob/master/classloader/Foo.java)
自定義子類別

[FooP.java](https://github.com/escc1122/java/blob/master/classloader/FooP.java)
正常載入父類

[Util.java](https://github.com/escc1122/java/blob/master/classloader/Util.java)
讀取文件路徑公用程式

[alTest4.java](https://github.com/escc1122/java/blob/master/classloader/alTest4.java)
載入class

[test.jsp](https://github.com/escc1122/java/blob/master/classloader/test.jsp)
試著在啟動時載入class

[FileSystemClassLoader2.java](https://github.com/escc1122/java/blob/master/classloader/FileSystemClassLoader2.java)
自定義的classloader
