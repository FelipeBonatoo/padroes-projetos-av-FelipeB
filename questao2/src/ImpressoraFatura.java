public class ImpressoraFatura {

    public static void imprimir(Fatura fatura) {
        System.out.println("=== FATURA DO COMPRADOR ===");
        System.out.println(fatura.descricao());
        System.out.println(String.format("Total a pagar: R$ %.2f", fatura.custo()));
        System.out.println();
    }
}
