import java.util.Scanner;
public class Calculadora {
    static int soma (int a, int b) {
        return a + b;
    }
    static int subtracao (int a, int b) {
        return a - b;
    }
    static int multiplicacao (int a, int b) {
        return a * b;
    }
    static int divisao (int a, int b) {
        return a / b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

    int numA;
    int numB;
    int opcao;
    
    while (true) {
        System.out.println("Escolha a operação:");
        System.out.println("1 - Soma");
        System.out.println("2 - Subtração");
        System.out.println("3 - Multiplicação");
        System.out.println("4 - Divisão");
        System.out.println("0 - Sair");
        opcao = sc.nextInt();
        if (opcao == 0) {
            System.out.println("Saindo...");
            break;
        }
        switch (opcao) {
            case 1:
                System.out.println("Digite o primeiro número: ");
                numA = sc.nextInt();
                System.out.println ("Digite o segundo número: ");
                numB = sc.nextInt();
                System.out.println("Resultado: " + soma (numA, numB));
                break;
            case 2:
                System.out.println ("Digite o primeiro número: ");
                numA = sc.nextInt();
                System.out.println ("Digite o segundo número: ");
                numB = sc.nextInt();
                System.out.println("Resultado: " + subtracao (numA, numB));
                break;
            case 3:
                System.out.println ("Digite o primeiro número: ");
                numA = sc.nextInt();
                System.out.println ("Digite o segundo número: ");
                numB = sc.nextInt();
                System.out.println("Resultado: " + multiplicacao (numA, numB));
                break;
            case 4:
                System.out.println("Digite o primeiro número: ");
                numA = sc.nextInt();
                System.out.println ("Digite o segundo número: ");
                numB = sc.nextInt();
                if (numB == 0) {
                    System.out.println("Não é possível dividir por zero.");
                }
                else {
                    System.out.println("Resultado: " + divisao (numA, numB));
                }
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }
    sc.close();
}
} 
