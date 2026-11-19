public abstract class ServicoAdicional implements Fatura {

    private final Fatura fatura;

    protected ServicoAdicional(Fatura fatura) {
        this.fatura = fatura;
    }

    protected abstract String nomeServico();

    protected abstract double custoServico();

    @Override
    public String descricao() {
        return fatura.descricao() + String.format("\n  + %s: R$ %.2f", nomeServico(), custoServico());
    }

    @Override
    public double custo() {
        return fatura.custo() + custoServico();
    }

    @Override
    public double valorVenda() {
        return fatura.valorVenda();
    }
}
