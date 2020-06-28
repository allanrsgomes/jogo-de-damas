import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Arquivo {
    protected String diretorio;
    protected File file;

    public Arquivo() throws IOException {
        this.diretorio = "C:\\jogo-de-damas\\resultados.txt";
        this.file = new File (this.diretorio);
        arquivoExiste();
    }

    protected void arquivoExiste() throws IOException {
        if (!this.file.exists()){
            FileWriter arquivo = new FileWriter(this.diretorio);
        }
    }

    protected void limparArquivo() throws IOException {
        Writer limpa = new BufferedWriter(new FileWriter(this.file));
    }

    protected void escreveNovaLinha(String conteudo) throws IOException {
        try {
            FileWriter escreve = new FileWriter(this.file, true);
            escreve.write(conteudo);
            escreve.write("\n");
            escreve.close();
        } catch (IOException error){
            System.err.println("Erro: " + error.getMessage());
        }
    }

    protected void salvarGanhador(String nome, int tempo) throws IOException {
        escreveNovaLinha(nome + "," + tempo);
    }

    protected List<String[]> lerResultados() throws IOException {
        FileReader fr = new FileReader(this.diretorio);
        BufferedReader br = new BufferedReader(fr);
        String linha;

        List<String[]> linhas = new ArrayList();
        while((linha = br.readLine()) != null){
            linhas.add(linha.split(","));
        }
        return linhas;
    }

}

