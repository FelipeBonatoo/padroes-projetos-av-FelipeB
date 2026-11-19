public class EntregaExpressa extends ServicoAdicional {

    public EntregaExpressa(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String nomeServico() {
        return "Entrega expressa";
    }

    @Override
    protected double custoServico() {
        return 450.00;
    }
}
