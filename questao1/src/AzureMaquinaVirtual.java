class AzureMaquinaVirtual implements MaquinaVirtual {

    private final String id;
    private final Tarifas tarifas;

    AzureMaquinaVirtual(String id, Tarifas tarifas) {
        this.id = id;
        this.tarifas = tarifas;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public double custoMensal() {
        return tarifas.custoMaquinas(1);
    }
}
