class AwsMaquinaVirtual implements MaquinaVirtual {

    private final String id;
    private final Tarifas tarifas;

    AwsMaquinaVirtual(String id, Tarifas tarifas) {
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
