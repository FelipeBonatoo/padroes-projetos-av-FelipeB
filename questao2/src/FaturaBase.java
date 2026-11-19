public class FaturaBase implements Fatura {

    private final String nomeLote;
    private final double valorVenda;

    public FaturaBase(String nomeLote, double valorVenda) {
        this.nomeLote = nomeLote;
        this.valorVenda = valorVenda;
    }

    @Override
    public String descricao() {
        return String.format("Lote: %s\nValor de venda: R$ %.2f", nomeLote, valorVenda);
    }

    @Override
    public double custo() {
        return valorVenda;
    }

    @Override
    public double valorVenda() {
        return valorVenda;
    }
}
