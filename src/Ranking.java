import java.io.IOException;
import java.util.*;

public class Ranking implements Comparable<Ranking>{

    protected String nome;
    protected int qtd;
    protected int tempo;

    public Ranking(){

    }

    public Ranking(String nome, int qtd, int tempo) {
        this.nome = nome;
        this.qtd = qtd;
        this.tempo = tempo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }


    @Override
    public int compareTo(Ranking o) {
        if (this.qtd > o.getQtd()){
            return -1;
        }
        if (this.qtd < o.getQtd()){
            return 1;
        }
        return 0;
    }

    public static List<Ranking> getRanking() throws IOException {
        Arquivo manipulador = new Arquivo();
        List<Ranking> rank = new ArrayList<Ranking>();

        /*Insere jogares sem repetilos na array*/
        List<String> jogadores = new ArrayList();
        for (String linha[] : manipulador.lerResultados()) {
            if (!jogadores.contains(linha[0])) {
                jogadores.add(linha[0]);
            }
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

        /*rankeia */
        List<String[]> ranking = new ArrayList<>();
        for (String linha : jogadoresQtd) {
            ranking.add(linha.split(","));
        }

        for (String[] linhas: ranking){
            rank.add(new Ranking(linhas[0], Integer.parseInt(linhas[1]), Integer.parseInt(linhas[2])));
        }

        Collections.sort(rank);

        return rank;
    }

}
