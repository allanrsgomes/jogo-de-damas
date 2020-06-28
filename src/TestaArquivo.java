import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestaArquivo {
    public static void main(String[] args) throws IOException {
        Arquivo manipulador = new Arquivo();

        /*manipulador.lerResultados().forEach(linhas -> System.out.println(linhas));*/
        /*String[] aux;

        for(String linha: manipulador.lerResultados()){
            aux = linha.split(",");
            System.out.println("Jogador: " + aux[0].toString());
            System.out.println("Tempo: " + aux[1].toString());
        }*/

        System.out.println("Conteúdo do arquivo:");
        for (String linha[] : manipulador.lerResultados()) {
            System.out.println("Nome: " + linha[0] + " | Tempo: " + linha[1]);
        }


        /*Insere jogares sem repetilos na array*/
        List<String> jogadores = new ArrayList();
        for (String linha[] : manipulador.lerResultados()) {
            if (!jogadores.contains(linha[0])) {
                jogadores.add(linha[0]);
            }
        }

        /*Lendo jogadores*/
        System.out.println("\nArray Jogadores: ");
        for (String linha : jogadores) {
            System.out.println(linha);
        }


        /*verificar quantas vezes aparece*/
        ArrayList<String> jogadoresQtd = new ArrayList<>();
        for (String linhax : jogadores) {
            int qtd = 0;
            int segundos = 0;
            for (String linhay[] : manipulador.lerResultados()) {
                if (linhax.equals(linhay[0])) {
                    qtd++;
                    Integer segundosy = Integer.parseInt(linhay[1]);
                    segundos = segundos + segundosy;
                }
            }

            jogadoresQtd.add(linhax + "," + qtd + "," + (segundos / Integer.parseInt(String.valueOf(qtd))));
        }

        /*lendo qtd que repete cada nome*/
        System.out.println("\nQuantidade que repete cada jogador: ");
        for (String linha : jogadoresQtd) {
            System.out.println(linha);
        }


        /*rankeia */
        List<String[]> ranking = new ArrayList<>();
        for (String linha : jogadoresQtd) {
            ranking.add(linha.split(","));
        }


        System.out.println("\nLê ranking");
        for (String[] linhas : ranking) {
            System.out.println(
                    "Nome: " + linhas[0] + " | " +
                            "X : " + linhas[1] + " | " +
                            "Tempo : " + linhas[2]
            );
        }

        List<Ranking> rank = new ArrayList<Ranking>();

        for (String[] linhas: ranking){
            rank.add(new Ranking(linhas[0], Integer.parseInt(linhas[1]), Integer.parseInt(linhas[2])));
        }

        System.out.println("ListRanking: ");
        for (Ranking ranki: rank){
            System.out.println(ranki.getNome() + " " + ranki.getQtd());
        }

        Collections.sort(rank);
        System.out.println("List Ranking Ordenado");
        for(Ranking linha: rank){
            System.out.println(linha.getNome() + " " + linha.getQtd());
        }
    }
}
