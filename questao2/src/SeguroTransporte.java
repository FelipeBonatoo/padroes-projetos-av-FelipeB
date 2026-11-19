public class SeguroTransporte extends ServicoAdicional {

    public SeguroTransporte(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String nomeServico() {
        return "Seguro de transporte";
    }

    @Override
    protected double custoServico() {
        return valorVenda() * 0.015;
    }
}
