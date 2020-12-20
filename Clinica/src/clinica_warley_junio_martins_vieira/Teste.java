package clinica_warley_junio_martins_vieira;

import java.util.ArrayList;
import java.util.Scanner;

public class Teste {
    static Scanner input = new Scanner(System.in);
    static final int opcaoEncerraPrograma = 0;
    static final int quantidadeFuncionalidadesPrograma = 8;
    public static void main(String[] args) {
        menuApresentacaoPrograma();
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        Clinica clinica;
        do{
            var cliente = instaciarCliente();
            if(cliente == null)
                break;
            clientes.add(cliente);
        }while(true);
        clinica = new Clinica(clientes);
        int opcaoFuncionalidadePrograma;
        do{
            do{
                opcaoFuncionalidadePrograma = atribuirInt(menuFuncionalidades());
            }while(opcaoFuncionalidadePrograma < opcaoEncerraPrograma
                || opcaoFuncionalidadePrograma > quantidadeFuncionalidadesPrograma);
            switch(opcaoFuncionalidadePrograma){
                case 1 -> olharQuantidadePacientes(clinica);
                case 2 -> olharMediaIdadeHommens(clinica);
                case 3 -> olharQuantidadeMulheresFiltroAlturaIdade(clinica);
                case 4 -> olharQuantidadeClientesFiltroIdade(clinica);
                case 5 -> olharNomePacienteMaisVelho(clinica);
                case 6 -> olharNomeMulherMaisBaixa(clinica);
                case 7 -> localizaCliente(clinica);
                case 8 -> printaTodosClientes(clinica);
                case 0 -> encerraPrograma();
            }
        }while(opcaoFuncionalidadePrograma != opcaoEncerraPrograma);
    }   
    private static void menuApresentacaoPrograma() {
        System.out.println("\tPrograma Clinica"
                         + "\n\tWarley Júnio Martins Vieira"
                         + "\n\tProgramação de Computadores 2"
                         + "\n\n\tEscreve 'exit' em qualquer input para finalizar o cadastro dos cliente!");    }
    private static String menuFuncionalidades(){
        return "\nDigite a opção da informação desejada sobre os clientes:"
             + "\n(1). Quantidade de pacientes "
             + "\n(2). Media de idade entre homens"
             + "\n(3). Quantidade de mulheres com altura entre 1,60 e 1,70 e peso acima de 70kg"
             + "\n(4). Quantidade de pessoas com idade entre 18 e 25"
             + "\n(5). Nome do paciente mais velhos"
             + "\n(6). Nome da mulher mais baixa"
             + "\n(7). Procura um paciente"
             + "\n(8). Printar todos os paciente"
             + "\n(0). Encerrar"
             + "\nOpção desejada: ";
    } 
    private static void olharQuantidadePacientes(Clinica clinica){
        int quantidadeClientes = clinica.quantidadePacientes();
        System.out.println("\nA quantidade de clientes cadastrados atualmente na clinica é: "+quantidadeClientes+"!");
    }
    private static void olharMediaIdadeHommens(Clinica clinica){
        double mediaIdade = clinica.calculaMediaIdadeHomens();
        System.out.println("\nA media de idade entre os clientes homens cadastrados na clinica é: "+mediaIdade+"!");
    }
    private static void olharQuantidadeMulheresFiltroAlturaIdade(Clinica clinica){
        int quantidadeMulheresFiltroAlturaIdade = clinica.calculaQuantidadeMulheresFiltroAlturaPeso();
        System.out.println("\nFiltro atual: mulheres, altura entre 1,60 e 1,70 e peso acima de 70kg"
                         + "\nQuantidade cadastrada atualmente na clinica: "+quantidadeMulheresFiltroAlturaIdade+"!");
    }
    private static void olharQuantidadeClientesFiltroIdade(Clinica clinica){
       int quantidadeClientesFiltroIdade = clinica.calculaQuantidadePessoasFiltroIdade();
       System.out.println("\nFiltro atual: pessoas com idade entre 18 e 25"
                        + "\nQuantidade presente atualmente na clinica: " +quantidadeClientesFiltroIdade+"!");
    }
    private static void olharNomePacienteMaisVelho(Clinica clinica){
        String nomeClienteMaisVelho = clinica.procuraNomePacienteMaisVelho();
        System.out.println("\nO nome do cliente mais velho presente na clinica é: "+nomeClienteMaisVelho+"!");
    }
    private static void olharNomeMulherMaisBaixa(Clinica clinica){
        String nomeMulherMaisBaixa = clinica.procuraNomeMulherMaisBaixa();
        System.out.println("\nO nome da mulher mais baixa na clinica é: "+nomeMulherMaisBaixa+"!");
    }
    private static void printarCliente(Cliente cliente){
        try{
            System.out.println("\nId: " + cliente.getId()
                    + "\nNome: " + cliente.getNome()
                    + "\nSexo: " + cliente.getSexo()
                    + "\nIdade: " + cliente.getIdade()
                    + "\nAltura: " + cliente.getAltura() +"m"
                    + "\nPeso"+ cliente.getPeso() +"Kg\n");
        }catch(NullPointerException e){
            System.out.println("Não há referencia para o cliente"
                             + "\nExceção: " + e.getMessage());
        }
        }
    private static void localizaCliente(Clinica clinica){
        var mensagemId = "Digite o id do cliente: ";
        int idClienteProcurado = atribuirInt(mensagemId);
        var clinteLocalizado = clinica.getClientes()
                                       .stream()
                                       .filter(x -> x.getId() == idClienteProcurado)
                                       .findFirst()
                                       .orElse(null);
        printarCliente(clinteLocalizado);
    }
    private static void printaTodosClientes(Clinica clinica){
        for(var item : clinica.getClientes())
            printarCliente(item);
    }
    private static Cliente instaciarCliente(){
        String auxiliarVerificaExit;
        System.out.println("\nDiigte os dados do cliente:"
                          + "\nObs: digite exit para encerrar o cadastro\n");
        var mensagemNome = "Digite o nome do cliente: ";
        auxiliarVerificaExit = atribuirString(mensagemNome);
        if(auxiliarVerificaExit.equals("exit")){
            System.out.println("Cadastro Encerrado!");
            return null;
        }
        String nome = auxiliarVerificaExit;
        var mensagemSexo = "Digite o sexo do cliente: ";
        auxiliarVerificaExit = atribuirString(mensagemSexo);
        if(auxiliarVerificaExit.equals("exit")){
            System.out.println("Cadastro Encerrado!");
            return null;
        }
        String sexo = auxiliarVerificaExit;
        var mensagemIdade = "Digite a idade do cliente: ";
        do{
            auxiliarVerificaExit = atribuirString(mensagemIdade);
                if(auxiliarVerificaExit.equals("exit")){
                    System.out.println("Cadastro Encerrado!");
                    return null;
            }
        }while(!verificaInt(auxiliarVerificaExit));
        int idade = Integer.parseInt(auxiliarVerificaExit);
        var mensagemPeso = "Digite o peso do cliente: ";
        do{
            auxiliarVerificaExit = atribuirString(mensagemPeso);
            if(auxiliarVerificaExit.equals("exit")){
                System.out.println("Cadastro Encerrado!");
                return null;
            }
        }while(!verificaDouble(auxiliarVerificaExit));
        double peso = Double.parseDouble(auxiliarVerificaExit);
        var mensagemAltura = "Digite a altura do cliente: ";
        do{
            auxiliarVerificaExit = atribuirString(mensagemAltura);
                        if(auxiliarVerificaExit.equals("exit")){
                            System.out.println("Cadastro Encerrado!");
                            return null;
                        }
        }while(!verificaDouble(auxiliarVerificaExit));
        double altura = Double.parseDouble(auxiliarVerificaExit);
        return new Cliente(idade, sexo, nome, peso, altura);
    }
    private static boolean verificaInt(String auxiliarVerificaExit) {
        int testeAtribuicaoValor;
            try{
                testeAtribuicaoValor = Integer.parseInt(auxiliarVerificaExit);
                return true;
            }
            catch(Exception e){
                System.out.println("Exeção lançada: " + e.getMessage());
                return false;
            }
    }
    private static int atribuirInt(String mensagem) {
        int valorAtribuido;
        do{
            try{
                System.out.print(mensagem);
                valorAtribuido = Integer.parseInt(input.nextLine());
                return valorAtribuido;
            }
            catch(Exception e){
                System.out.println("Exeção lançada: " + e.getMessage());
            }
        }while(true);
    }
    private static boolean verificaDouble(String auxiliarVerificaExit) {
        double testeAtribuicaoValor;
            try{
                testeAtribuicaoValor = Double.parseDouble(auxiliarVerificaExit);
                return true;
            }
            catch(Exception e){
                System.out.println("Exeção lançada: " + e.getMessage());
                return false;
            }
    }
    private static String atribuirString(String mensagem) {
        String valorAtribuido;
        do{
                System.out.print(mensagem);
                valorAtribuido = input.nextLine();
                if(!valorAtribuido.isEmpty())
                    return valorAtribuido;
        }while(true);
    }
    private static void encerraPrograma() {
        System.out.println("\nPrograma Encerrado!\n");
    }
}


























