class AzureFilaMensagens implements FilaMensagens {

    private final String id;
    private final Tarifas tarifas;

    AzureFilaMensagens(String id, Tarifas tarifas) {
        this.id = id;
        this.tarifas = tarifas;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public double custoMensal() {
        return tarifas.custoFila();
    }
}
