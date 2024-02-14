package trabalho;
// criamos uma excecao para nao criar erros e falhas no sistema caso usuario digite alguma coisa errada

public class ReservaFalhada extends Exception{
    public ReservaFalhada (String mensagem){
        super(mensagem);// a palavra chave pode ser usada para acessar a metodo e classe pai, ou para exceçoes, pode ser muitas maneiras, neste
        // exemplo serve para lançar uma mensagem de erro caso o usuario digite alguma coisa indevida.
    }
}
