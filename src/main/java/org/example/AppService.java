package org.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppService {

    public void monthlyBilling() {
        double sp = 67836.43;
        double rj = 36678.66;
        double mg = 29229.88;
        double es = 27165.48;
        double outros = 19849.53;

        double total = sp + rj + mg + es + outros;

        System.out.printf("SP: %.2f%%%n", (sp / total) * 100);
        System.out.printf("RJ: %.2f%%%n", (rj / total) * 100);
        System.out.printf("MG: %.2f%%%n", (mg / total) * 100);
        System.out.printf("ES: %.2f%%%n", (es / total) * 100);
        System.out.printf("Outros: %.2f%%%n", (outros / total) * 100);
    }

    public void dataBilling() {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode rootNode = objectMapper.readTree(new File("dados.json"));

            List<Double> faturamentos = new ArrayList<>();

            for (JsonNode node : rootNode) {
                double valor = node.get("valor").asDouble();
                if (valor > 0) {
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
    }

    public void reverseStringProcess() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Informe uma frase");
            String frase = scanner.nextLine();
            System.out.println("Frase informada: " + frase);
            System.out.println("Frase invertidade: " + reverseString(frase));
        } catch (Exception e) {
            throw new RuntimeException("Houve algum problema ao ler a frase");
        }
    }

    public void fibonacciResolution() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe um número para verificar se pertence à sequência de Fibonacci:");
        int number = scanner.nextInt();

        if(isFibonacci(number)) {
            System.out.println("O número " + number + " pertence à sequência de Fibonacci.");
        } else {
            System.out.println("O número " + number + " NÃO pertence à sequência de Fibonacci.");
        }
    }

    private String reverseString(String str) {
        char[] chars = str.toCharArray();
        StringBuilder reversed = new StringBuilder();

        for (int i = chars.length - 1; i >= 0; i--) {
            reversed.append(chars[i]);
        }

        return reversed.toString();
    }

    private boolean isFibonacci(int number) {
        if (number < 0) {
            return false;
        }

        int a = 0, b = 1;
        while (a <= number) {
            if (a == number) {
                return true;
            }
            int next = a + b;
            a = b;
            b = next;
        }
        return false;
    }

}
