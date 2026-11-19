class AzureArmazenamento implements Armazenamento {

    private final String id;
    private final int gb;
    private final Tarifas tarifas;

    AzureArmazenamento(String id, int gb, Tarifas tarifas) {
        this.id = id;
        this.gb = gb;
        this.tarifas = tarifas;
    }

    @Override
    public String id() {
        return id;
    }

    @Override
    public int gb() {
        return gb;
    }

    @Override
    public double custoMensal() {
        return tarifas.custoArmazenamento(gb);
    }
}
