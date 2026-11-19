import java.util.List;

public class Ambiente {

    private final String nome;
    private final String provedor;
    private final String regiao;
    private final List<MaquinaVirtual> maquinas;
    private final Armazenamento armazenamento;
    private final FilaMensagens fila;

    public Ambiente(String nome, String provedor, String regiao, List<MaquinaVirtual> maquinas,
                    Armazenamento armazenamento, FilaMensagens fila) {
        this.nome = nome;
        this.provedor = provedor;
        this.regiao = regiao;
        this.maquinas = maquinas;
        this.armazenamento = armazenamento;
        this.fila = fila;
    }

    public double custoMensal() {
        double total = armazenamento.custoMensal() + fila.custoMensal();
        for (MaquinaVirtual m : maquinas) {
            total += m.custoMensal();
        }
        return total;
    }

    public String resumo() {
        StringBuilder sb = new StringBuilder();
        sb.append("--- Ambiente provisionado ---\n");
        sb.append("Ambiente : ").append(nome).append('\n');
        sb.append("Provedor : ").append(provedor).append('\n');
        sb.append("Regiao   : ").append(regiao).append('\n');
        for (MaquinaVirtual m : maquinas) {
            sb.append("  Maquina virtual: ").append(m.id()).append('\n');
        }
        sb.append("  Armazenamento: ").append(armazenamento.id()).append(" (").append(armazenamento.gb()).append(" GB)\n");
        sb.append("  Fila: ").append(fila.id()).append('\n');
        sb.append(String.format("Custo mensal estimado: R$ %.2f%n", custoMensal()));
        return sb.toString();
    }
}
