package clinica_warley_junio_martins_vieira;
public class Cliente {
    private static int quantidadeClientes = 0;
    private int id;
    private int idade;
    private String sexo;
    private String nome;
    private double peso;
    private double altura;
    public Cliente(int idade, String sexo, String nome, double peso, double altura) {
        quantidadeClientes++;
        this.id = quantidadeClientes;
        this.idade = idade;
        this.sexo = sexo.toLowerCase();
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
    }
    public int getIdade() {
        return idade;
    }
    public void setIdade(int idade) {
        this.idade = idade;
    }
    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getAltura() {
        return altura;
    }
    public void setAltura(double altura) {
        this.altura = altura;
    }
    public static int getQuantidadeClientes() {
        return quantidadeClientes;
    }
    public int getId() {
        return id;
    }    
}











