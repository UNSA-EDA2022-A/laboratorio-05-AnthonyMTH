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
                //Para verificar que solo se ingrese esos caracteres
                switch (caracter) {
                    case '(': stack.push(caracter); break;
                    case '[': stack.push(caracter); break;
                    case '{': stack.push(caracter); break;
                    //Si son de apertura se agregan al stack
                    case ')':
                        if (stack.top() == '(') stack.pop(); break;
                    case ']':
                        if (stack.top() == '[') stack.pop(); break;
                    case '}':
                        if (stack.top() == '{') stack.pop(); break;
                    //Si son se cierre, y el último caracter agregado es 
                    //el mismo pero de apertura, se elimina
                }
            }
            else return false;
        }
        return stack.isEmpty(); 
        //Si aún tiene caracteres quiere decir que no todos los signos 
        //tuvieron su respectivo cierre. por ende, retorna false
    }
}
