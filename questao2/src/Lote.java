import java.util.ArrayList;
import java.util.List;

public class Lote {

    private final String nome;
    private final String categoria;
    private final double precoReserva;
    private final List<Interessado> interessados = new ArrayList<>();
    private RegraComissao regraComissao;
    private double lanceAtual;
    private int totalLances;
    private Interessado comprador;
    private boolean aberto = true;
    private boolean vendido;
    private double comissao;

    public Lote(String nome, String categoria, double precoInicial, double precoReserva, RegraComissao regraComissao) {
        this.nome = nome;
        this.categoria = categoria;
        this.lanceAtual = precoInicial;
        this.precoReserva = precoReserva;
        this.regraComissao = regraComissao;
    }

    public void acompanhar(Interessado interessado) {
        interessados.add(interessado);
    }

    public void deixarDeAcompanhar(Interessado interessado) {
        interessados.remove(interessado);
    }

    public boolean darLance(Interessado autor, double valor) {
        if (!aberto) {
            System.out.println("   RECUSADO: lote encerrado, nao aceita novos lances");
            return false;
        }
        double minimo = lanceAtual * 1.05;
        if (valor + 0.005 < minimo) {
            System.out.println(String.format(
                    "   RECUSADO: o lance precisa ser pelo menos 5%% maior que o lance atual de R$ %.2f (minimo R$ %.2f)",
                    lanceAtual, minimo));
            return false;
        }
        lanceAtual = valor;
        totalLances++;
        comprador = autor;
        for (Interessado interessado : new ArrayList<>(interessados)) {
            if (interessado != autor) {
                interessado.atualizar(this, autor, valor);
            }
        }
        return true;
    }

    public void trocarRegraComissao(RegraComissao novaRegra) {
        if (!aberto) {
            throw new IllegalStateException("lote ja encerrado");
        }
        this.regraComissao = novaRegra;
    }

    public void encerrar() {
        aberto = false;
        if (totalLances > 0 && lanceAtual >= precoReserva) {
            vendido = true;
            comissao = regraComissao.calcular(lanceAtual);
        }
    }

    public String nome() {
        return nome;
    }

    public String categoria() {
        return categoria;
    }

    public double lanceAtual() {
        return lanceAtual;
    }

    public int totalLances() {
        return totalLances;
    }

    public Interessado comprador() {
        return comprador;
    }

    public boolean vendido() {
        return vendido;
    }

    public double comissao() {
        return comissao;
    }
}
