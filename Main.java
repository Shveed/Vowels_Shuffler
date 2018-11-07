package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Random random = new Random();
        String vowels = "aeiouy";
        String MyLine;
        String curr = "";
        int count = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter line. We will shuffle all vowels.");
        MyLine = sc.nextLine();
	    for(int i=0; i<MyLine.length(); i++){
	        if(IsIn(vowels, MyLine.charAt(i))){
	            curr = curr + MyLine.charAt(i);
	            count++;
	        }
        }

        char[] newvowels = new char[count];
	    for(int i = 0; i < count; i++){
	        newvowels[i] = curr.charAt(i);
        }

        for(int i = count - 1; i > 0; i--){
            int j = random.nextInt(i+1);
            char temp = newvowels[j];
            newvowels[j] = newvowels[i];
            newvowels[i] = temp;
        }

        int k = 0;
        for(int i=0; i<MyLine.length(); i++){
            if(IsIn(vowels, MyLine.charAt(i))){
                MyLine = MyLine.substring(0, i) + newvowels[k] + MyLine.substring(i+1);
                k++;
            }
        }
        System.out.println(MyLine);
    }

    static boolean IsIn(String str, char elem){
        for(int i=0; i< str.length(); i++) {
            if (str.charAt(i) == elem) {
                return true;
            }
        }
        return false;
    }
}
