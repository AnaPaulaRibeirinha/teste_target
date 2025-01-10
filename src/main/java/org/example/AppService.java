package org.example;

public class AppService {

    public boolean isFibonacci(int number) {
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

    public String reverseString(String str) {
        StringBuilder sb = new StringBuilder(str);
        return sb.reverse().toString(); // Reverso da string
    }
}
