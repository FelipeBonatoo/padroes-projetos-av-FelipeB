public class PainelLeiloeiro implements Interessado {

    @Override
    public String nome() {
        return "Painel do leiloeiro";
    }

    @Override
    public void atualizar(Lote lote, Interessado autor, double valor) {
        System.out.println(String.format("   [PAINEL] lote '%s' | maior lance: R$ %.2f | total de lances: %d",
                lote.nome(), lote.lanceAtual(), lote.totalLances()));
    }
}
