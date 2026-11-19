import java.util.ArrayList;
import java.util.List;

public class ProvisionadorAmbiente {

    private final FabricaNuvem fabrica;

    public ProvisionadorAmbiente(FabricaNuvem fabrica) {
        this.fabrica = fabrica;
    }

    public void provisionar(SolicitacaoAmbiente solicitacao) {
        Configuracao config = Configuracao.getInstance();
        HistoricoAuditoria historico = HistoricoAuditoria.getInstance();
        String provedor = fabrica.nomeProvedor();

        double estimado = fabrica.tarifas().estimar(solicitacao.maquinas(), solicitacao.gb());
        if (estimado > config.orcamentoMaximo()) {
            String motivo = String.format("custo estimado R$ %.2f acima do orcamento de R$ %.2f",
                    estimado, config.orcamentoMaximo());
            historico.registrar(solicitacao.nome(), provedor, "RECUSADO: " + motivo);
            System.out.println(">>> " + solicitacao.nome() + " recusado: " + motivo + "\n");
            return;
        }

        List<MaquinaVirtual> maquinas = new ArrayList<>();
        for (int i = 0; i < solicitacao.maquinas(); i++) {
            maquinas.add(fabrica.criarMaquinaVirtual());
        }
        Armazenamento armazenamento = fabrica.criarArmazenamento(solicitacao.gb());
        FilaMensagens fila = fabrica.criarFila();

        Ambiente ambiente = new Ambiente(solicitacao.nome(), provedor, config.regiao(), maquinas, armazenamento, fila);
        System.out.print(ambiente.resumo());
        historico.registrar(solicitacao.nome(), provedor, "ACEITO");
    }
}
