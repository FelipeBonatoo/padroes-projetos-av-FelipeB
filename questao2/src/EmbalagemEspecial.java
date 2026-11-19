public class EmbalagemEspecial extends ServicoAdicional {

    public EmbalagemEspecial(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String nomeServico() {
        return "Embalagem especial";
    }

    @Override
    protected double custoServico() {
        return 180.00;
    }
}
