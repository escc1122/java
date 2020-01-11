#目的
利用java RSA加密 對某一次串行分割加密

##程式說明
[Generatingkey.java](https://github.com/escc1122/java/blob/master/RSA/Generatingkey.java)
利用myKeyPair.java產生公鑰跟私鑰

[myKeyPair.java](https://github.com/escc1122/java/blob/master/RSA/myKeyPair.java)
產生公鑰跟私鑰


[Main2.java](https://github.com/escc1122/java/blob/master/RSA/Main2.java)
利用公私鑰進行加解密

[myEncryption.java](https://github.com/escc1122/java/blob/master/RSA/myEncryption.java)
公私鑰加解密用class

##需要注意的地方
1.RSA 是屬於 block chiper，所以一次只能加密很短的字串，如果加密長度超過 117 bytes，執行時會丟出 Exception 。

2.加密時是以每 100 bytes 做一次切割，而解密時則是以每 128 bytes 做切割
意味著 100 bytes 加密後應會產出 128 bytes 的結果，因此解密時要把同樣長度的資料解回來。
不過實務上這可能跟金鑰長度有關，比如說金鑰長度延展成 2048-bit 時，每 100 bytes 加密會產出 256 bytes 的結果。
另外演算法使用的填充方式不同，也會導致一輪加密中能夠加密的長度產生變化。

##參考網址
http://jimwayne.blogspot.tw/2012/06/java.html
