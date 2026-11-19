public class AcertoVendedor {

    public static void imprimir(Lote lote) {
        double venda = lote.lanceAtual();
        double comissao = lote.comissao();
        System.out.println("=== ACERTO DO VENDEDOR - " + lote.nome() + " ===");
        System.out.println(String.format("Valor de venda     : R$ %.2f", venda));
        System.out.println(String.format("Comissao cobrada   : R$ %.2f", comissao));
        System.out.println(String.format("Liquido a repassar : R$ %.2f", venda - comissao));
        System.out.println();
    }
}
