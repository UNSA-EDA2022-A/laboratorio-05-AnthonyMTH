package com.example.project;

import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();
        Scanner sc = new Scanner(System.in);
        while (true) {
            String s = sc.nextLine();
            System.out.println(obj.existenDuplicados(s));
        }
    }

    public boolean existenDuplicados(String str) {
        MyStack<Character> stack = new LinkedListStack<Character>();
        int validar = 0;
        for (int i = 0; i < str.length(); i++) {
            Character caracter = str.charAt(i);
            if(caracter == '(' || caracter == ')' || caracter == '+' || 
                caracter == '-') {
                //Para verificar que solo se ingrese esos caracteres
                switch (caracter) {
                    case '+': if(stack.isEmpty() == false) validar++; break;
                    case '-': if(stack.isEmpty() == false) validar++; break;
                    case '(': stack.push(caracter); break;
                    case ')':
                        if(stack.top() == '(' && validar != 0){
                            stack.pop();
                            validar--;
                        }; break;
                }
            }
            else continue; 
        }
        return !stack.isEmpty(); 
    }
    }
}
