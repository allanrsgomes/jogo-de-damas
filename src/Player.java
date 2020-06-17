public class Player {
    private String nome;
    private int pecas;
    private int melhorTempo;

    public Player(String nm) {
        nome = nm;
        melhorTempo = 0;
        pecas = 0;
    }

    public void incPecas() {
        pecas++;
    }

    public void decPecas() {
        pecas--;
    }

    public void setMelhorTempo(int tempo) {
        melhorTempo = tempo;
    }

    public void setNome(String nom) {
        nome = nom;
    }

    public int getPecas() {
        return pecas;
    }

    public int getMelhorTempo() {
        return melhorTempo;
    }

    public String getNome() {
        return nome;
    }
}