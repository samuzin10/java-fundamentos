public class Pessoa {
private String nome;
private int idade;
private String cpf;

public Pessoa (String nome, int idade, String cpf) {
    if(nome == null || nome.trim().isEmpty()){
        throw new IllegalArgumentException("Nome inválido.");
    }
    if (idade < 0){
        throw new IllegalArgumentException("Idade inválida.");
    }
    if (cpf == null || cpf.length() != 11){
        throw new IllegalArgumentException("CPF inválido.");
    }
    
    this.nome = nome;
    this.idade = idade;
    this.cpf = cpf;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public int getIdade() {
    return idade;
}
public void setIdade(int idade){
    this.idade = idade;
}
public String getCpf(){
    return cpf;
}
public void setCpf(String cpf){
    this.cpf = cpf;
}


public boolean maiorIdade() {
    return idade >= 18;
}
}