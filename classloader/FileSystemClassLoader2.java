package com.dec;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.*;

public class FileSystemClassLoader2 extends ClassLoader {

	private String rootDir;

  private byte[] key;
  private Cipher cipher;

	public FileSystemClassLoader2(String rootDir , byte[] key) throws GeneralSecurityException,
      IOException{
    this.rootDir = rootDir;
    this.key = key;
    SecretKeySpec spec = new SecretKeySpec(key, "AES");
    cipher = Cipher.getInstance("AES");
    //設定為加密模式
    cipher.init(Cipher.DECRYPT_MODE, spec);
	}

	protected Class<?> findClass(String name) throws ClassNotFoundException {
    System.out.println("=======findClass======");
    Class clasz = findLoadedClass( name );
    if (clasz != null){
      return clasz;
    }
    byte[] classData = null;
    try {
      classData = getClassData(name);
    }catch (IllegalBlockSizeException ibse){
      System.out.println("IllegalBlockSizeException return Class.forName");
      return Class.forName(name);
    }
		if (classData == null) {
//      System.out.println(this.getParent());
//      return Class.forName(name);
			throw new ClassNotFoundException();
		}else {
			return defineClass(name, classData, 0, classData.length);
		}
	}

	private byte[] getClassData(String className) throws IllegalBlockSizeException{
    String path = classNameToPath(className);
    try {
      byte[] buffer = Util.readFile(path);
//      System.out.println("加密前字串===================>"+new String(buffer));
      byte decryptedClassData[] = cipher.doFinal( buffer );
//      System.out.println("加密後字串===================>"+new String(decryptedClassData));
      return decryptedClassData;
    } catch (BadPaddingException e) {
      e.printStackTrace();
    }
    catch (IOException e) {
      e.printStackTrace();
    }
    return null;
	}

	private String classNameToPath(String className) {
		return rootDir + File.separatorChar
				+ className.replace('.', File.separatorChar) + ".class";
	}

}
