package trabalho;
import java.util.Random;// Biblioteca Random que é usada para gerar numeros aleatorios...
import java.util.Scanner;

public class Usuario extends SistemaDeResserva  { // herança extendida da classe sistema de resserva
    protected String nome;
    protected String cpf;
    protected String email;
    protected String id;

    //metodos setter e getterss

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCpf() {
        return cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void setId(String id) {
     this.id = id;
    }

    public String getId() {
        return id;
    }

    /// metodos herdados de realizar reserva e cancelar reserva

    // metodos so para o usuario se cadastrar primeiro....
    public void gerarIdAleatorio() {
        Random random = new Random();
        int idMinimo = 100000; // O menor ID com 6 dígitos
        int idMaximo = 999999; // O maior ID com 6 dígitos
        int idGerado = random.nextInt(idMaximo - idMinimo + 1) + idMinimo;
        setId(Integer.toString(idGerado));
    }


    public void CadastrodoEmail() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe seu email:");
        while(true){
            email = sc.nextLine();
            if (email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) { // Metodo matches(Expressoes Regulares)
                break;                                             // Uma expressão regular é uma String especialmente formatada que mostra um padrão de pesquisa e substituição de textos. O principal objetivo dessas expressões é fazer validações nos dados de um programa, assegurando que estes dados estejam em um determinado formato. Uma expressão consiste em caracteres literais e símbolos especiais.
            }else{                                                // O método matches especifica uma expressão regular e localiza o conteúdo do objeto String em que está sendo aplicada essa expressão. Para saber se essa correspondência foi atendida ou não, é retornado um valor booleano (true ou false).
                System.out.println("! Ups !,Email Errado!, Digite seu Email Novamente:");
            }
        }
    }

    public void CadastroCpf() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o Cpf: ");
        while (true){
            cpf = sc.nextLine(); // Lê a entrada do usuário e armazena em 'cpf'.
            cpf.replaceAll("\\D", "");// Remove todos os caracteres não numéricos da 'cpf'.
            // O metodo Replace all é de muito versatil para manipular manipular strings de acordo com padrões específicos.
            // Oseja é usado para substituir todas as ocorrências de um padrão específico por uma nova sequência de caracteres em uma string.
            if (cpf.length()>=11){ // Verifica se 'cpf' tem pelo menos 11 dígitos.
                break;// sai do loop se valida que o cpf tem mais de 11 digitos
            }else{
                System.out.println("CPF Invalido");
                System.out.println("Informe o cpf:");
            }
        }

    }
    public void Relatorio() {
        System.out.println("id:" + getId());
        System.out.println("CPF: " +getCpf());

        System.out.println("------------------");

        System.out.println("Aproveite Muito Mas Volte logo");


        System.out.println(" Boa viagem ");

        System.out.println("--------------------");
    }
}
