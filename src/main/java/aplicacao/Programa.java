package aplicacao;

import xadrez.PartidaXadrez;
import xadrez.PecaXadrez;
import xadrez.PosicaoXadrez;

import java.util.Scanner;

public class  Programa {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        PartidaXadrez partidaXadrez = new PartidaXadrez();

        while (true) {
            UI.imprimirTabuleiro(partidaXadrez.getPecas());
            System.out.println();
            System.out.print("Origem: ");
            PosicaoXadrez posicaoInicial = UI.lerPosicaoXadrez(scan);

            System.out.println();
            System.out.print("Destino: ");
            PosicaoXadrez posicaoFinal = UI.lerPosicaoXadrez(scan);

            PecaXadrez capturarPeca = partidaXadrez.executarMovimento(posicaoInicial, posicaoFinal);
        }
    }
}
