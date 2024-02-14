package trabalho;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class Viagem {
    private String destino;
    private String data;
    private String horario;
    private List<String> datasDisponiveis = new ArrayList<>();
    private List<String> Horariosdisponiveis = new ArrayList<>();
    private Map<String, Float> DestinoePreco = new HashMap<>();// usamos a biblioteca importada Hashmap principalmente
    // porque é muito eficiente e o metodo put. é  usado para adicionar novos pares de destino-preço ao HashMap. Por exemplo, DestinoePreco.put("Sao Paulo",500.50f); adiciona um novo par ao HashMap com a chave “Sao Paulo” e o valor 500.50.

    // Metodo construtor da classe composta viagem(aqui estamos usando composiçao...
    public Viagem() {
        // preços das passagens dos Destinos Disponiveis
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        DestinoePreco.put("Sao Paulo",500.00f);
        DestinoePreco.put("Rio de Janeiro" ,700.50f);// com a biblioteca hasmap adicionamos uma string e uma variavel do tipo float
        DestinoePreco.put("Brasilia" ,650.00f);
        DestinoePreco.put("Manaus",230.50f);
        DestinoePreco.put("Vilhena",120.50f);
        DestinoePreco.put("Ouro Preto", 125.50f);
        DestinoePreco.put("Boa Vista", 400.00f);
        DestinoePreco.put("Rio Branco", 450.00f);
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        // datas disponiveis no metodo construtor
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        datasDisponiveis.add("27/11/2023");
        datasDisponiveis.add("28/11/2023"); // adicionamos as listas das datas e horarios.
        datasDisponiveis.add("29/11/2023");
        datasDisponiveis.add("30/11/2023");
        datasDisponiveis.add("01/12/2023");
        datasDisponiveis.add("02/12/2023");
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        // horarios disponiveis no metodo construtor
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        Horariosdisponiveis.add("08:00");
        Horariosdisponiveis.add("10:00");
        Horariosdisponiveis.add("14:40");
        Horariosdisponiveis.add("17:45");
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

    }
    public float getPrecoPassagem() {
        return DestinoePreco.get(destino); // Obtém o preço da passagem com base no destino
    }


    public void setDestino(String destinoEscolhido) {
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.println("Destinos Disponíveis Para viagem:");

        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        int i = 0;
        for (Map.Entry<String, Float> entry : DestinoePreco.entrySet()) {
            System.out.println( (i  + 1) + "." + entry.getKey() + " (Preço: " + entry.getValue() + " reais)");
            i++;
        }

        int escolha = 0;
        while (true) {
            System.out.println("");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            System.out.print("Escolha o número do destino desejado: ");
            System.out.println("");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            escolha = sc.nextInt();
            if (escolha >= 1 && escolha <= DestinoePreco.size()) {
                break;
            } else {
                System.out.println("Escolha Inválida, Por favor escolha um destino válido.");
            }
        }

        this.destino = new ArrayList<>(DestinoePreco.keySet()).get(escolha - 1);
        System.out.println("Destino escolhido: " + this.destino);
    }





    public String getDestino() {
        return destino;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String getHorario() {
        return horario;
    }
    public void escolherDataeHorario(){
        Scanner sc = new Scanner(System.in);
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        System.out.println("Datas Disponíveis:");
        System.out.println("");
        System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

        for (int i = 0; i < datasDisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + datasDisponiveis.get(i));
        }

        int escolhaData;
        while (true) {
            System.out.println("");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            System.out.print("Escolha o número da data desejada: ");
            System.out.println("");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            escolhaData = sc.nextInt();
            if (escolhaData >= 1 && escolhaData <= datasDisponiveis.size()) {
                break;
            } else {
                System.out.println("Escolha inválida. Por favor, escolha um número válido.");
            }
        }

        String dataEscolhida = datasDisponiveis.get(escolhaData - 1);
        setData(dataEscolhida);

        System.out.println("Data escolhida: " + dataEscolhida);



        System.out.println("");

        System.out.println("Horários Disponíveis:");

        System.out.println("");
        for (int i = 0; i < Horariosdisponiveis.size(); i++) {
            System.out.println((i + 1) + ". " + Horariosdisponiveis.get(i));
        }

        int escolhaHorario;
        while (true) {
            System.out.println("");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            System.out.print("Escolha o número do horário desejado: ");

            System.out.println("");
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");

            escolhaHorario = sc.nextInt();
            if (escolhaHorario >= 1 && escolhaHorario <= Horariosdisponiveis.size()) {
                break;
            } else {
                System.out.println("Escolha inválida. Por favor, escolha um número válido.");
            }
        }

        String horarioEscolhido = Horariosdisponiveis.get(escolhaHorario - 1);
        setHorario(horarioEscolhido);

        System.out.println("Horário Escolhido: " + horarioEscolhido);
       }
    }




