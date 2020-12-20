package clinica_warley_junio_martins_vieira;
import java.util.ArrayList;
public class Clinica {
    private ArrayList<Cliente> clientes;
    public Clinica(ArrayList<Cliente> cliente) {
        this.clientes = cliente;
    }
    public Clinica() {
        this.clientes = new ArrayList<Cliente>();
    }
    public int quantidadePacientes(){
        int quantidade = 0;
        for(var item : this.clientes)
            quantidade++;
        return quantidade;
    }
    public double calculaMediaIdadeHomens(){
        double media = 0;
        int quantidadeHomens = 0;
        for(var item : this.clientes){
            if(item.getSexo().equals("masculino")){
                media += item.getIdade();
                quantidadeHomens++;
            }
        }
        if(quantidadeHomens == 0){
            return 0;
        }
        return media/quantidadeHomens;
    }
    public int calculaQuantidadeMulheresFiltroAlturaPeso(){
        double pesoMinimo = 70;
        double alturaMinima = 1.6;
        double alturaMaxima = 1.7;
        int quantidadeMulheresFiltroAlturaPeso = 0;
        for(var item : clientes)
            if(item.getSexo().equals("feminino"))
                if(item.getPeso() == pesoMinimo)
                    if(item.getAltura() >= alturaMinima
                    && item.getAltura() <= alturaMaxima)
                        quantidadeMulheresFiltroAlturaPeso++;
        return quantidadeMulheresFiltroAlturaPeso; 
    }
    public int calculaQuantidadePessoasFiltroIdade(){
        int quantidadePessoasFiltroIdade = 0;
        int idadeMinima = 18;
        int idadeMaxima = 25;
        for(var item : this.clientes)
            if(item.getIdade() >= 18
            && item.getIdade() <= 25)
                quantidadePessoasFiltroIdade++;
        return quantidadePessoasFiltroIdade;
    }
    public String procuraNomePacienteMaisVelho(){
        Cliente clienteMaisVelho = null;
        int maiorIdade = 0;
        for(var item : clientes)
            if(item.getIdade() >= maiorIdade){
                maiorIdade = item.getIdade();
                clienteMaisVelho = item;
            }
        if(clienteMaisVelho == null)
            return "Deculpe, ainda não há clientes na clinica!";
        return clienteMaisVelho.getNome();
    }
    public String procuraNomeMulherMaisBaixa(){
        Cliente mulherMaisBaixa = null;
        double menorAltura = Double.MAX_VALUE;
        for(var item : clientes)
            if(item.getSexo().equals("feminino"))
                if(item.getAltura() <= menorAltura){
                    menorAltura = item.getAltura();
                    mulherMaisBaixa = item;
                }
        if(mulherMaisBaixa == null)
            return "Deculpe, ainda não há mulheres na clinica!";
        return mulherMaisBaixa.getNome();
    }
    public boolean adicionarCliente(Cliente cliente){
        if(cliente == null){
            return false;
        }
        this.clientes.add(cliente);
        return true;
    }
    public ArrayList<Cliente> getClientes() {
        return this.clientes;
    }
    
}



















