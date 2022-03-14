package com.google.kickstart;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        int test = 1;

        while (testCases != 0){
            String str = scan.next().toLowerCase();
            String ch = scan.next().toLowerCase();
            System.out.println("Case #"+test+": "+ solve(str, ch.toCharArray()));
            testCases--;
            test++;
        }

    }

    public static int solve(String givenString, char[] givenChar){

        char[] arr = givenString.toCharArray();
        int result = 0;
            for(char cc: arr){
                int currentChar = cc;
                int minOperation = Integer.MAX_VALUE;
                for(char tt: givenChar){
                    int k = tt;
                    minOperation = Math.min(minOperation, Math.min(Math.abs(k - currentChar), 26 - Math.abs(k - currentChar)));
                }
                result+= minOperation;
            }

        return result;
    }
}
