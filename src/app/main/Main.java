import java.util.Scanner;   
public class Main {
    public static void main(String args[]){
        Scanner sc = new Scanner (System.in);
        System.out.println ("Digite o nome da Pessoa: ");
        String nome = sc.nextLine();
        System.out.println ("Digite a idade da Pessoa: ");
        int idade = sc.nextInt();
        Pessoa p = new Pessoa (nome, idade);
        System.out.println ("Nome : " + p.getNome());
        System.out.println("Idade : " + p.getIdade());
        if (p.maiorIdade()) {
            System.out.println ("A pessoa é de maior idade.");
        }
        else {
            System.out.println("A pessoa é menor de idade.");
        }
        sc.close();
        }
    }