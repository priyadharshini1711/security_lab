import java.util.*;
import java.io.*;
import java.math.BigInteger;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("enter the prime number : ");
        BigInteger p = new BigInteger(br.readLine());
        System.out.println("enter primitive root of " + p + " : ");
        BigInteger g = new BigInteger(br.readLine());
        System.out.println("enter value for x less than " + p + " : ");
        BigInteger x = new BigInteger(br.readLine());
        BigInteger r1 = g.modPow(x, p);
        System.out.println("r1 : " + r1);
        System.out.println("enter value for y less than " + p + " : ");
        BigInteger y = new BigInteger(br.readLine());
        BigInteger r2 = g.modPow(y, p);
        System.out.println("r2 : " + r2);
        BigInteger k1 = r2.modPow(x, p);
        System.out.println("key calculated for user1 : " + k1);
        BigInteger k2 = r1.modPow(y, p);
        System.out.println("key calculated for user2 : " + k2);
        System.out.println("diffie hellman secret key encryption has taken");

    }
}

/*
output

enter the prime number : 
11
enter primitive root of 11 : 
7
enter value for x less than 11 : 
3
r1 : 2
enter value for y less than 11 : 
6
r2 : 4
key calculated for user1 : 9
key calculated for user2 : 9
diffie hellman secret key encryption has taken

*/