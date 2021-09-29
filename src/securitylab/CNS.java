package securitylab;

import java.util.*;

/**
 *
 * @author admin
 */
public class CNS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String key = sc.next();
        String plain = sc.next();
        int x=key.length();
        int y=plain.length();
        while(x<y){
            key += key;
            x=key.length();
        }
        key=key.substring(0,plain.length());
        
        String cipher="";
        for(int i=0;i<plain.length();i++){
            char c =(char)(((key.charAt(i) + plain.charAt(i))%26)+'a');
            //System.out.println(c+" ");
            cipher = cipher + c;  
        }
        
        System.out.println(cipher);
        
        String decrypt="";
        for(int i=0;i<plain.length();i++){
            int z =(cipher.charAt(i) - key.charAt(i) + 26) % 26;
            char c = (char) (z+'a');
            //System.out.println(c+" ");
            decrypt = decrypt + c;
        }
            
        System.out.println(decrypt);
        
    }
    
}
