package trabalho;
// aqui criaremos todo o processo de encapsulamento,metodos especiais, e etc...
//import java.util.Array.List
// import java.util.List;
import java.util.Scanner;
public class SistemaDeResserva {
    // primer passo declarar os atributos da clase ...
    private String usuario;
    private Viagem viagem;
    private int assentosDisponiveis;
    private int assentosReservados;
    private float pagamento;

    // Método construtor da classe
    public SistemaDeResserva() {
        this.setAssentosDisponiveis(48); // Inicialmente, há 50 assentos disponíveis
        this.setAssentosReservados(0);  // Inicialmente, nenhum assento está reservado
    }

    // Estado atual...
    public void relatorio(){
        System.out.println("Nome:" +getUsuario());
        System.out.println("pagamento: " +getPagamento());
        System.out.println("--------------------");
    }

    // Métodos getters e setters para usuario
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    // Métodos getters e setters para destino


    // Métodos getters e setters para assentosDisponiveis
    public int getAssentosDisponiveis() {
        return assentosDisponiveis;
    }

    public void setAssentosDisponiveis(int assentosDisponiveis) {
        this.assentosDisponiveis = assentosDisponiveis;
    }

    // Métodos getters e setters para assentosReservados
    public int getAssentosReservados() {
        return assentosReservados;
    }

    public void setAssentosReservados(int assentosReservados) {
        this.assentosReservados = assentosReservados;
    }

    // Métodos getters e setters para data


    // Métodos getters e setters para pagamento
    public float getPagamento() {
        return pagamento;
    }

    public void setPagamento(float pagamento) {
        this.pagamento = pagamento;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public Viagem getViagem() {
        return viagem;
    }

    // Criaçao dos Metodos...

    // Método para realizar uma reserva

    public void realizarReserva(int quantidadeReservada) throws ReservaFalhada {
        if (quantidadeReservada <= 0) {
            throw new ReservaFalhada("A quantidade de assentos tem que ser maior do que zero");
        }

        if (quantidadeReservada > getAssentosDisponiveis()) {
            throw new ReservaFalhada("Não há assentos suficientes disponíveis para a reserva.");
        }


        System.out.println("Quantidade de assentos disponíveis: " + getAssentosDisponiveis());
        System.out.println("Quantidade de assentos a serem reservados: " + quantidadeReservada);

        // Realizando pagamento algortimos com metodos

        float precoPassagem = viagem.getPrecoPassagem(); // Obtém o preço da passagem
        float valorTotal = quantidadeReservada * precoPassagem;
        System.out.println("Valor total a ser pago: " + valorTotal + " reais.");
        float valorPagamento = solicitarPagamento(valorTotal);

        if (valorPagamento < valorTotal) {
            System.out.println("Pagamento insuficiente. A reserva foi cancelada.");
        } else {
            float troco = valorPagamento - valorTotal;
            System.out.println("Pagamento bem-sucedido. Seu troco é: " + troco + " reais.");
            setAssentosDisponiveis(getAssentosDisponiveis() - quantidadeReservada);
            setAssentosReservados(getAssentosReservados() + quantidadeReservada);
            setPagamento(valorPagamento);
            System.out.println("Reserva realizada com sucesso para " + getUsuario() + " com a quantidade reservada para " + quantidadeReservada + " assentos.");
        }


    }
// Metodo privado simulando um pagamento.
    private float solicitarPagamento(float valorTotal) {
        Scanner sc = new Scanner(System.in);
        float valorPagamento = 0;

        while (valorPagamento < valorTotal) {
            System.out.print("Insira o valor do pagamento: ");
            System.out.println("");
            valorPagamento = sc.nextFloat();

            if (valorPagamento < valorTotal) {
                System.out.println("Pagamento insuficiente. O valor total a ser pago é: " + valorTotal + " reais.");
                System.out.println("");
            }
        }
        return valorPagamento;
    }

        // Método para cancelar uma reserva.
        public boolean cancelarReserva(int quantidadeCancelada)  {
            Scanner sc = new Scanner(System.in);
            System.out.println("");

            System.out.println("Deseja cancelar Reserva? (Sim/nao):");

            String cancelar = sc.nextLine();

            if (cancelar.equalsIgnoreCase("sim")) {
                System.out.println("Informe a quantidade de assentos a serem cancelados:");
                quantidadeCancelada = sc.nextInt();
                System.out.println("");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                if (quantidadeCancelada <= 0) {
                    System.out.println("A quantidade de assentos a serem cancelados deve ser maior que zero.");
                    System.out.println("");
                    System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

                    return false;
                }
                System.out.println("");
                if (quantidadeCancelada > getAssentosReservados()) {
                    System.out.println("Não há assentos reservados suficientes para o cancelamento.");
                    return false;
                }

                setAssentosDisponiveis(getAssentosDisponiveis() + quantidadeCancelada);
                setAssentosReservados(getAssentosReservados() - quantidadeCancelada);

                System.out.println("Reserva cancelada com sucesso para " + getUsuario() + " para " + quantidadeCancelada + " assentos.");
                System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
                return true;
            }

            return false; // Se o usuário(cliente) não deseja cancelar a reserva....'

        }
    // metodo de perguntar cancelar reserva caso(metodo opcional para que seja um pouco mais interativo o sistema)...
    public boolean perguntarCancelarReserva() {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.print("O cliente pretende Cancelar? (sim/nao): ");
        String resposta = sc.nextLine();
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        return resposta.equalsIgnoreCase("sim");
    }

    }










