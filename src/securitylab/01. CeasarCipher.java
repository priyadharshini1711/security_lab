import java.util.*;

class Cipher
{
  String alphabet = "abcdefghijklmnopqrstuvwxyz";
  String encrypt (String plainText, int shiftKey)
  {
    plainText = plainText.toLowerCase ();
    String cipherText = "";
    for (int i = 0; i < plainText.length (); i++)
      {
	int charPosition = alphabet.indexOf (plainText.charAt (i));
	int keyVal = (shiftKey + charPosition) % 26;
	char replaceVal = alphabet.charAt (keyVal);
	  cipherText += replaceVal;
      }
    return cipherText;
  }

  String decrypt (String cipherText, int shiftKey)
  {
    cipherText = cipherText.toLowerCase ();
    String plainText = "";
    for (int i = 0; i < cipherText.length (); i++)
      {
	int charPosition = alphabet.indexOf (cipherText.charAt (i));
	int keyVal = (charPosition - shiftKey) % 26;
	if (keyVal < 0)
	  {
	    keyVal = alphabet.length () + keyVal;
	  }
	char replaceVal = alphabet.charAt (keyVal);
	plainText += replaceVal;
      }
    return plainText;
  }
}

public class Main
{
  public static void main (String[]args)
  {
    Cipher c = new Cipher ();
    Scanner sc = new Scanner (System.in);
      System.out.println ("enter the string for encryption");
    String message = new String ();
      message = sc.next ();
    String cipherText = new String ();
      cipherText = c.encrypt (message, 3);
      System.out.println ("Encryption:");
      System.out.println (cipherText);
      System.out.println ("Decryption:");
      System.out.println (c.decrypt (cipherText, 3));
      sc.close ();
  }
}

/*
output

enter the string for encryption
computer
Encryption:
frpsxwhu
Decryption:
computer
*/
