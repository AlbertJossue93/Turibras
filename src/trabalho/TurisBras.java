package trabalho;
import java.util.Scanner;
// Aqui vamos realizar a entrada do usuario, o procedimento de cadastro, e os algoritmos.
public class TurisBras {
    public static void main(String[] args) throws ReservaFalhada {
        Scanner sc = new Scanner(System.in);
        Usuario usuario = new Usuario();
        SistemaDeResserva s1 = new SistemaDeResserva();
        Viagem viagem = new Viagem();
        do {
            System.out.println("--------------------------------------------------" +
                    "");
            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------" +
                    "");
            System.out.println("\t\t\t\tSeja Bem Vindo a Turibrass Express\t\t\t\t\t");

            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------" +
                    "");
            System.out.println("---------------------------------------------------");

            System.out.println("\t\t\t\t\tSystem TurisBras Express \t\t\t\t\t");
            System.out.println("");

                    System.out.print("Digite o Nome do Cliente: ");
                    s1.setUsuario(sc.nextLine());
            System.out.println("");

            usuario.CadastroCpf();

            System.out.println("");


                    // chamada do cadastro de email(herdado)
                    usuario.CadastrodoEmail();

            System.out.println("");
            // id de viagem do usuario...
            usuario.gerarIdAleatorio();

            System.out.println("");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("Sucesso!! " + s1.getUsuario() + " seu cadastro foi realizado com sucesso !");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            System.out.println("");

            System.out.println("");

                    // escolha do destino
                    viagem.setDestino(viagem.getDestino());
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
            System.out.println("");
                    // Escolher data e horario...
                    viagem.escolherDataeHorario();
            System.out.println("");
                    s1.setViagem(viagem);
            System.out.println("");


                    System.out.println("Quantidade de assentos disponíveis: " + s1.getAssentosDisponiveis());
                    while (true) {
                        System.out.print("Quantidade de assentos a serem reservados: ");
                        int quantidadeReservada = sc.nextInt();
                        try {
                            s1.realizarReserva(quantidadeReservada);
                            if (s1.perguntarCancelarReserva()) {
                                s1.cancelarReserva(quantidadeReservada);
                                break;  // Reinicia o loop do começo...
                            }
                            System.out.println("---------------------------");
                            System.out.println("");
                            System.out.println("Reserva realizada com sucesso!");
                            System.out.println("-----------------------------");
                            System.out.println("");
                            s1.relatorio();
                            System.out.println("");
                            usuario.Relatorio();
                            System.out.println("");
                            break;
                        } catch (ReservaFalhada e) {
                            System.out.println("Erro ao fazer a reserva: " + e.getMessage());
                        }
                        System.out.println("Quantidade de assentos disponíveis após a reserva: " + s1.getAssentosDisponiveis());
                    }
            System.out.println("");
                    System.out.println("Deseja Continuar? (sim/nao):");
            System.out.println("");
                    sc.nextLine();
                    String continuar = sc.nextLine();
                    if (!continuar.equalsIgnoreCase("sim")) {
                        System.out.println("");
                        System.out.println("=========================================================" +
                                "");
                        System.out.println("=========================================================");
                        System.out.println("\tObrigado por Usar Turibras express, ate logo! \t");
                        System.out.println("=========================================================" +
                                "");
                        System.out.println("=========================================================");
                        System.out.println("");
                        break;
                    }
        }
            while (true) ;
        }
    }










