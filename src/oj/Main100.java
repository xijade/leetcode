package oj;

import java.util.*;

import java.io.*;
import java.math.BigInteger;

public class Main100{

    public static void main(String[] arg){
        Scanner scan = new Scanner(new BufferedInputStream(System.in));
        int n = scan.nextInt();
        int l = n;
        while(n--!=0){
            BigInteger integer = new BigInteger(scan.next());
            BigInteger integer2 = new BigInteger(scan.next());
            System.out.println("Case " + (l-n) + ":");
            System.out.println(integer + " + " + integer2  +  " = " +integer.add(integer2));
            if(n!=1){
                System.out.println();
            }
        }
        scan.close();
    }

}