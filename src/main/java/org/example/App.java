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
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe um número para verificar se pertence à sequência de Fibonacci:");
            int number = scanner.nextInt();

            if(appService.isFibonacci(number)) {
                System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
            } else {
                System.out.println("O número " + number + " NÃO pertence à sequência de Fibonacci.");
            }
        } catch (Exception e) {
            throw new RuntimeException("Houve algum problema ao ler o número informado");
        }

        System.out.println( "/////////////////////////////////////////////////////////////" );

        System.out.println( "QUESTÃO 3:" );

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("dados.json"));

            List<Double> faturamentos = new ArrayList<>();

            for (JsonNode node : rootNode) {
                double valor = node.get("valor").asDouble();
                if (valor > 0) { // Ignorar dias sem faturamento
                    faturamentos.add(valor);
                }
            }

            if (faturamentos.isEmpty()) {
                System.out.println("Nenhum dia de faturamento registrado.");
                return;
            }

            double menorFaturamento = faturamentos.stream().min(Double::compare).orElse(0.0);
            double maiorFaturamento = faturamentos.stream().max(Double::compare).orElse(0.0);

            double soma = faturamentos.stream().mapToDouble(Double::doubleValue).sum();
            double media = soma / faturamentos.size();

            long diasAcimaDaMedia = faturamentos.stream().filter(f -> f > media).count();

            System.out.printf("Menor valor de faturamento: %.2f\n", menorFaturamento);
            System.out.printf("Maior valor de faturamento: %.2f\n", maiorFaturamento);
            System.out.printf("Número de dias com faturamento acima da média: %d\n", diasAcimaDaMedia);
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo JSON: " + e.getMessage());
        }

        System.out.println( "/////////////////////////////////////////////////////////////" );

        System.out.println( "QUESTÃO 4:" );

        appService.monthlyBilling();

        System.out.println( "/////////////////////////////////////////////////////////////" );

        System.out.println( "QUESTÃO 5:" );

        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe uma frase");
            String frase = scanner.nextLine();
            System.out.println("Frase informada: " + frase);
            System.out.println("Frase invertidade: " + appService.reverseString(frase));
        } catch (Exception e) {
            throw new RuntimeException("Houve algum problema ao ler a frase");
        }

    }
}
