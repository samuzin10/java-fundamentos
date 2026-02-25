import java.util.ArrayList;
import java.util.Scanner;

public class Cadastro {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pessoa> pessoas = new ArrayList<>(); 
    public static void main(String[] args) {
    
    while (true) {
        System.out.println("Escolha a opção: ");
        System.out.println("1 - Cadastrar Pessoa");
        System.out.println("2 - Listar Pessoas");
        System.out.println("3 - Buscar por nome");
        System.out.println("4 - Maiores de idade");
        System.out.println("0 - Sair");

        int opcao = sc.nextInt();
        sc.nextLine(); 
        if (opcao == 0){
            System.out.println("Saindo...");
            break;
        }
        switch (opcao){
        case 1:
            cadastrarPessoa();
            break;    
        
        case 2:
            listarPessoas();
            break;
        
        case 3 :
            buscarPorNome();
            break;

        case 4:
            maioresDeIdade();
            break;

            default:
                System.out.println("Opção inválida, tente novamente.");
        }
    }
    sc.close();
}

    public static String lerStringObrigatoria(String mensagem){
        String valor;

        while(true){
           try{ 
            System.out.println(mensagem);
            valor = sc.nextLine();
            if (valor.trim().isEmpty()){
                System.out.println("Digite um valor válido.");
            }
            else{
                break;
            }
        }       
        catch (Exception e){
            System.out.println("Erro na leitura do valor.");
            sc.nextLine();
        }
    }
        return valor;
    }

    public static int lerInteiroPositivo(String mensagem){
        int valor;
        
        while(true){
            try{
                System.out.println(mensagem);
                valor = sc.nextInt();
                sc.nextLine();

                if(valor < 0){
                    System.out.println("Digite um número positivo.");
                }
                else{
                    return valor;
                }
            }
            catch (Exception e){
                System.out.println("Digite apenas números.");
                sc.nextLine();
            }
        }
    }

    public static String lerCpfValido(){
        String cpf;

        while(true){
            System.out.println("Digite o CPF da pessoa (apenas números):");
            cpf = sc.nextLine().replaceAll("\\D", "");

            if(cpf.length() != 11){
                System.out.println("CPF deve conter 11 dígitos.");
            }
            else{
                return cpf;
            }
        }
    }

    public static void cadastrarPessoa(){
        
        String nome = lerStringObrigatoria("Digite o nome da pessoa: ");
        
        int idade = lerInteiroPositivo("Digite a idade da pessoa: ");

        String cpf = lerCpfValido();
        
        Pessoa p = new Pessoa(nome, idade, cpf);
        pessoas.add(p);
        
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    public static void listarPessoas(){
        
        if(pessoas.isEmpty()){
            System.out.println("Não tem pessoas cadastradas.");
            return;
        }

        for (Pessoa p : pessoas){
            System.out.println("Nome: " + p.getNome() + ", Idade: " + p.getIdade() + ", CPF: " + p.getCpf());
            }
        }

    public static void buscarPorNome(){
        
        if(pessoas.isEmpty()){
            System.out.println("Não tem pessoas cadastradas.");
            return;
        }
        
        String nome = lerStringObrigatoria("Digite o nome da pessoa que deseja buscar: ");
        
        boolean encontrado = false;
        
        for (Pessoa p : pessoas){
            if (p.getNome().equalsIgnoreCase(nome)){
                System.out.println("Nome: " +p.getNome() + ", Idade: " + p.getIdade() + ", CPF: " + p.getCpf());
                encontrado = true;
                break;
            }
        }
        if(!encontrado){
            System.out.println("Pessoa não encontrada.");
        }
    }

    public static void maioresDeIdade(){
        boolean temMaiores = false;
        
        for (Pessoa p : pessoas){
            if (p.maiorIdade()){
                System.out.println("Nome: " + p.getNome() + ", Idade: " + p.getIdade() + ", CPF: " + p.getCpf());
                temMaiores = true;
            }
        }
            if (!temMaiores){
                System.out.println("Não tem pessoas maiores de idade");
            }
        }
    }
