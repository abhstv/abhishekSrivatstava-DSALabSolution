package com.greatlearning.balancebrackets.driver;

import java.util.Scanner;
import java.util.Stack;

public class BalancedBrackets {

    static boolean checkBalancedBracket(String br){

        if ((br.length())%2 != 0)
            return false;
        else {
            Stack <Character> temp = new Stack<Character>();
            char ch;
            for(int i =0; i<br.length(); i++){
                ch = br.charAt(i);
                if(ch=='(' || ch=='{' || ch=='['){
                    temp.push(ch);
                    continue;
                }
                if (temp.isEmpty())
                    return false;
                    char popch = temp.pop();
                    switch(ch){
                        case ')':
                            if(popch == '{' || popch=='[')
                            return false;
                            break;             
                        case '}':
                            if(popch == '(' || popch=='[')
                            return false;
                            break;
                        case ']':
                            if(popch == '{' || popch=='(')
                            return false;
                            break;
                    }
                
            }
            return temp.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a bracket String : ");
        String br= sc.next();
        boolean result = checkBalancedBracket(br);
        if (result == true){
            System.out.println("The entered String has Balanced Brackets");
        }
        else 
        System.out.println("The entered Strings do not contain Balanced Brackets");

    }
    
}
