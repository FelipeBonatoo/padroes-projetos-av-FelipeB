public class Main {

    public static void main(String[] args) {
        Lote tela = new Lote("Tela Abstrata", "Arte", 1000.00, 1200.00, new ComissaoArte());
        Lote notebook = new Lote("Notebook Gamer", "Eletronicos", 2000.00, 5000.00, new ComissaoEletronicos());

        Participante ana = new Participante("Ana");
        Participante bruno = new Participante("Bruno");
        Participante carla = new Participante("Carla");
        PainelLeiloeiro painel = new PainelLeiloeiro();
        Auditor auditor = new Auditor();

        tela.acompanhar(ana);
        tela.acompanhar(bruno);
        tela.acompanhar(carla);
        tela.acompanhar(painel);
        tela.acompanhar(auditor);

        notebook.acompanhar(ana);
        notebook.acompanhar(carla);
        notebook.acompanhar(painel);
        notebook.acompanhar(auditor);

        System.out.println("##### Lote 'Tela Abstrata' (Arte)\n");
        bruno.darLance(tela, 1100.00);
        carla.darLance(tela, 1120.00);
        carla.darLance(tela, 1200.00);

        System.out.println("\nCarla deixa de acompanhar o lote 'Tela Abstrata'\n");
        tela.deixarDeAcompanhar(carla);
        ana.darLance(tela, 1300.00);

        System.out.println("\nCampanha: 'Tela Abstrata' passa a usar a comissao de Eletronicos\n");
        tela.trocarRegraComissao(new ComissaoEletronicos());
        bruno.darLance(tela, 1400.00);

        System.out.println("\n##### Lote 'Notebook Gamer' (Eletronicos)\n");
        ana.darLance(notebook, 2100.00);
        carla.darLance(notebook, 2500.00);

        System.out.println("\n##### Encerramentos\n");
        tela.encerrar();
        notebook.encerrar();
        System.out.println("Lote '" + tela.nome() + "': " + (tela.vendido() ? "VENDIDO" : "NAO VENDIDO"));
        System.out.println("Lote '" + notebook.nome() + "': " + (notebook.vendido() ? "VENDIDO" : "NAO VENDIDO"));
        carla.darLance(notebook, 3000.00);
        System.out.println();

        AcertoVendedor.imprimir(tela);

        Fatura semServicos = new FaturaBase(tela.nome(), tela.lanceAtual());
        ImpressoraFatura.imprimir(semServicos);

        Fatura fatura = new FaturaBase(tela.nome(), tela.lanceAtual());
        fatura = new SeguroTransporte(fatura);
        fatura = new CertificadoAutenticidade(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EmbalagemEspecial(fatura);
        fatura = new EntregaExpressa(fatura);
        ImpressoraFatura.imprimir(fatura);

        auditor.imprimirRegistros();
    }
}
