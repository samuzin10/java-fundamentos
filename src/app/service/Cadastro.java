import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class Cadastro {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Pessoa> pessoas = new ArrayList<>(); 
    public static void main(String[] args) {
    
    while (true) {
        System.out.println("Escolha a opção: ");
        System.out.println("1 - Cadastrar Pessoa");
        System.out.println("2 - Listar Pessoas");
        System.out.println("3 - Buscar por nome");
        System.out.println("4 - Buscar por CPF");
        System.out.println("5 - Atualizar dados");
        System.out.println("6 - Excluir pessoa");
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
            buscarPorCpf();
            break;
        
        case 5:
            atualizarDados();
            break;
        
        case 6:
            excluirPessoa();
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

    public static boolean cpfJaExiste(String cpf){
        for (Pessoa p : pessoas){
            if(p.getCpf().equals(cpf)){
                return true;
            }
        }
        return false;
    }

    public static boolean listaVazia(){
        if(pessoas.isEmpty()){
            System.out.println("Não tem pessoas cadastradas.");
            return true;
        }
        return false;
    }

    public static void cadastrarPessoa(){
        
        String nome = lerStringObrigatoria("Digite o nome da pessoa: ");
        
        int idade = lerInteiroPositivo("Digite a idade da pessoa: ");

        String cpf;

        do{
            cpf = lerCpfValido();
            if(cpfJaExiste(cpf)){
                System.out.println("CPF já cadastrado!");
            }
        }
        while (cpfJaExiste(cpf));
        
        Pessoa p = new Pessoa(nome, idade, cpf);
        pessoas.add(p);
        
        System.out.println("Pessoa cadastrada com sucesso!");
    }

    public static void listarPessoas(){
        
        if(listaVazia()){
            return;
        }

        for (Pessoa p : pessoas){
            System.out.println("Nome: " + p.getNome() + ", Idade: " + p.getIdade() + ", CPF: " + p.getCpf());
            }
        }

    public static void buscarPorNome(){
        
        if(listaVazia()){
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

    public static void buscarPorCpf(){
        if(listaVazia()){
            return;
        }

        String cpf = lerCpfValido();
        
        for (Pessoa p : pessoas){
            if (p.getCpf().equals(cpf)){
                System.out.println("Nome: " + p.getNome());
                System.out.println("Idade: " + p.getIdade());
                System.out.println("CPF encontrado: " + p.getCpf());
                return;

            }
        }
        
        System.out.println("CPF não encontrado.");
        }
        
    public static void atualizarDados(){
        if(listaVazia()){
            return;
        }
        System.out.println("Digite o nome da pessoa que deseja atualizar: ");
        String nome = sc.nextLine();
        boolean encontrado = false;

        for (Pessoa p : pessoas){
            if(p.getNome().equalsIgnoreCase(nome)){
                System.out.println("Digite o novo nome: ");
                String novoNome = sc.nextLine();
                System.out.println("Digite a nova idade: ");
                int novaIdade = sc.nextInt();
                sc.nextLine();
                System.out.println("Digite o novo CPF: ");
                String novoCpf = sc.nextLine();

                p.setNome(novoNome);
                p.setIdade(novaIdade);
                do{
                    if(cpfJaExiste(novoCpf)){
                        System.out.println("CPF já cadastrado!");
                    }
                }
                while (cpfJaExiste(novoCpf));
                p.setCpf(novoCpf);
                encontrado = true;
                break;
            }

        }
        if(!encontrado){
            System.out.println("Pessoa não encontrada.");
        }
    }

    public static void excluirPessoa(){
        
        if(listaVazia()){
            return;
        }
        System.out.println("Digite o nome da pessoa que deseja excluir: ");
        Iterator<Pessoa> iterator = pessoas.iterator();
        String nome = sc.nextLine();
        boolean encontrado = false;

         while(iterator.hasNext()){
            Pessoa p = iterator.next();
            if(p.getNome().equalsIgnoreCase(nome)){
                iterator.remove();
                System.out.println("Pessoa excluída com sucesso!");
                encontrado = true;
                break;
        }
            if(!encontrado){
                System.out.println("Pessoa não encontrada.");
            }
        }
    }
}

