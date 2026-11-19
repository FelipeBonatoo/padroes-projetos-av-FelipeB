import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Configuracao {

    private static final Configuracao INSTANCIA = new Configuracao();

    private final String regiao;
    private final double orcamentoMaximo;

    private Configuracao() {
        Properties props = carregar();
        this.regiao = props.getProperty("regiao.padrao");
        this.orcamentoMaximo = Double.parseDouble(props.getProperty("orcamento.mensal.maximo"));
        System.out.println("[config] config.properties carregado (leitura unica)");
    }

    public static Configuracao getInstance() {
        return INSTANCIA;
    }

    public String regiao() {
        return regiao;
    }

    public double orcamentoMaximo() {
        return orcamentoMaximo;
    }

    private static Properties carregar() {
        for (String caminho : new String[] { "config.properties", "../config.properties", "questao1/config.properties" }) {
            File arquivo = new File(caminho);
            if (arquivo.exists()) {
                try (FileInputStream in = new FileInputStream(arquivo)) {
                    Properties props = new Properties();
                    props.load(in);
                    return props;
                } catch (IOException e) {
                    throw new IllegalStateException("Falha ao ler config.properties", e);
                }
            }
        }
        throw new IllegalStateException("config.properties nao encontrado");
    }
}
