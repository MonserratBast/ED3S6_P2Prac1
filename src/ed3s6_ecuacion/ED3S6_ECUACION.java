package ed3s6_ecuacion;

import java.util.Scanner;

public class ED3S6_ECUACION {

    public ED3S6_ECUACION(int n) {
        System.out.println("(x+y)^" + n + " = " + formula(n, 0));
    }

    private String formula(int n, int k) {
        if (k > n) {
            return "";
        }
        long factor = factorial(n) / (factorial(k) * factorial(n - k));
        String termino = "";
        if (factor > 1) {
            termino += factor;
        }
        termino += letra("x", n - k) + letra("y", k);
        if (termino.equals("")) {
            termino = "1";
        }
        if (k < n) {
            termino += " + ";
        }
        return termino + formula(n, k + 1);
    }

    private String letra(String variable, int exp) {
        if (exp == 0) {
            return "";
        } else if (exp == 1) {
            return variable;
        } else {
            return variable + "^" + exp;
        }
    }

    private long factorial(int a) {
        if (a <= 1) {
            return 1;
        }
        return a * factorial(a - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el exponente n: ");
        int n = sc.nextInt();
        new ED3S6_ECUACION(n);
        sc.close();
    }
}