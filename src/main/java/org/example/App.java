package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
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

        try {
            appService.fibonacciResolution();
        } catch (Exception e) {
            throw new RuntimeException("Houve algum problema ao ler o número informado");
        }

        System.out.println( "/////////////////////////////////////////////////////////////" );

        System.out.println( "QUESTÃO 3:" );

        try {
            appService.dataBilling();
        } catch (Exception e) {
            throw new RuntimeException("Houve falha no processo de dados do faturamento diario");
        }

        System.out.println( "/////////////////////////////////////////////////////////////" );

        System.out.println( "QUESTÃO 4:" );

        appService.monthlyBilling();

        System.out.println( "/////////////////////////////////////////////////////////////" );

        System.out.println( "QUESTÃO 5:" );

        appService.reverseStringProcess();

    }
}
