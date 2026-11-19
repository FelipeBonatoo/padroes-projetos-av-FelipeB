public class CertificadoAutenticidade extends ServicoAdicional {

    public CertificadoAutenticidade(Fatura fatura) {
        super(fatura);
    }

    @Override
    protected String nomeServico() {
        return "Certificado de autenticidade";
    }

    @Override
    protected double custoServico() {
        return 300.00;
    }
}
