import java.util.*;

class Main {
    
    static String generateKey(String str, String key) {
        int x = str.length();

        for (int i = 0;; i++) {
            if (x == i)
                i = 0;
            if (key.length() == str.length())
                break;
            key += (key.charAt(i));
        }
        return key;
    }

    static String cipherText(String str, String key) {
        String cipher_text = "";

        for (int i = 0; i < str.length(); i++) {
            int x = (str.charAt(i) + key.charAt(i)) % 26;

            x += 'A';

            cipher_text += (char)(x);
        }
        return cipher_text;
    }

    static String originalText(String cipher_text, String key) {
        String orig_text = "";

        for (int i = 0; i < cipher_text.length() &&
            i < key.length(); i++) {
            int x = (cipher_text.charAt(i) -
                key.charAt(i) + 26) % 26;

            x += 'A';
            orig_text += (char)(x);
        }
        return orig_text;
    }

    static String LowerToUpper(String s) {
        StringBuffer str = new StringBuffer(s);
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                str.setCharAt(i, Character.toUpperCase(s.charAt(i)));
            }
        }
        s = str.toString();
        return s;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String Keyword = new String();
        System.out.println("enter key");
        Keyword = sc.next();

        String Str = new String();
        System.out.println("enter plain text");
        Str = sc.next();


        String str = LowerToUpper(Str);
        String keyword = LowerToUpper(Keyword);

        System.out.println("plain text: " + str);

        String key = generateKey(str, keyword);
        System.out.println("key text: " + key);
        String cipher_text = cipherText(str, key);

        System.out.println("cipher text : " +
            cipher_text);

        System.out.println("plain text : " +
            originalText(cipher_text, key));
    }
}

/*
output:

enter key
DECEPTIVE
enter plain text
WEAREDISCOVEREDSAVEYOURSELF
plain text: WEAREDISCOVEREDSAVEYOURSELF
key text: DECEPTIVEDECEPTIVEDECEPTIVE
cipher text : ZICVTWQNGRZGVTWAVZHCQYGLMGJ
plain text : WEAREDISCOVEREDSAVEYOURSELF

*/