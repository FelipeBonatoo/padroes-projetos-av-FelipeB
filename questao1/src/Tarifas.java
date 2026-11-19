public class Tarifas {

    private static final int HORAS_POR_MES = 730;

    private final double custoHoraMaquina;
    private final double custoGbMes;
    private final double custoFilaMes;

    public Tarifas(double custoHoraMaquina, double custoGbMes, double custoFilaMes) {
        this.custoHoraMaquina = custoHoraMaquina;
        this.custoGbMes = custoGbMes;
        this.custoFilaMes = custoFilaMes;
    }

    public double custoMaquinas(int quantidade) {
        return quantidade * custoHoraMaquina * HORAS_POR_MES;
    }

    public double custoArmazenamento(int gb) {
        return gb * custoGbMes;
    }

    public double custoFila() {
        return custoFilaMes;
    }

    public double estimar(int maquinas, int gb) {
        return custoMaquinas(maquinas) + custoArmazenamento(gb) + custoFila();
    }
}
