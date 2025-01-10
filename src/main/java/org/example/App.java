package org.example;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        AppService appService = new AppService();

        System.out.println( "QUESTÃO 2:" );

        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um número para verificar se pertence à sequência de Fibonacci:");
        int number = scanner.nextInt();

        if(appService.isFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " NÃO pertence à sequência de Fibonacci.");
        }

        System.out.println( "QUESTÃO 3:" );




    }
}
