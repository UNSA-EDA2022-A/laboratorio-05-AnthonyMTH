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
                    /* Usé como apoyo los signos '+' y '-'. 'validar' es una variable
                     * que aumentará de valor si hay uno de estos dos signos dentro
                     * (indicando una operación) y, como condición adicional,
                     * debe haber un paréntesis ya agregado para verificar correctamente.
                     * Por ejemplo: '(a+b)+((c+d))' aquí hay 3 '+', sin esta última 
                     * condición se verificaría como correcto. La condición se aplica
                     * únicamente para este tipo de casos: '((a+b)-(a-b))'.
                     */
                    case '(': stack.push(caracter); break;
                    case ')':
                        if(stack.top() == '(' && validar != 0){
                        //Elimina el último elemento en caso 'validar' sea distinto de 0
                        //(que haya operación/operaciones dentro)
                            stack.pop();
                            validar--;
                        }; break;
                }
            }
            else continue; //Si no coincide con los caracteres que nos interesan, pasa de ellos
        }
        return !stack.isEmpty(); 
        //Negación porque en caso haya algún caracter al finalizar el bucle, quiere decir que 
        //hubo paréntesis sobrantes, retornando true (detectando que sí está incorrecto)
    }
    }
}
