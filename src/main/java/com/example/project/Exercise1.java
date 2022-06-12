package com.example.project;

import java.util.Scanner;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.esBalanceado(s));
        }
    }

    public boolean esBalanceado(String s) {
        MyStack<Character> stack = new LinkedListStack<Character>();
        for (int i = 0; i < s.length(); i++) {
            Character caracter = s.charAt(i); 
            if(caracter == '(' || caracter == ')' || caracter == '[' || 
                caracter == ']'|| caracter == '{' || caracter == '}') {
                switch (caracter) {
                    case '(': stack.push(caracter); break;
                    case '[': stack.push(caracter); break;
                    case '{': stack.push(caracter); break;
                    case ')':
                        if (stack.top() == '(') stack.pop(); break;
                    case ']':
                        if (stack.top() == '[') stack.pop(); break;
                    case '}':
                        if (stack.top() == '{') stack.pop(); break;
                }
            }
            else return false;
        }
        return stack.isEmpty(); 
    }
}
