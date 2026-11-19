import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SeletorProvedor seletor = new SeletorProvedor();

        List<SolicitacaoAmbiente> solicitacoes = Arrays.asList(
                new SolicitacaoAmbiente("app-pagamentos", "Aws", 2, 100),
                new SolicitacaoAmbiente("app-relatorios", "Aws", 3, 200),
                new SolicitacaoAmbiente("app-portal", "Azure", 3, 200),
                new SolicitacaoAmbiente("app-big-data", "Aws", 8, 500));

        List<Thread> threads = new ArrayList<>();
        for (SolicitacaoAmbiente s : solicitacoes) {
            threads.add(new Thread(() -> new ProvisionadorAmbiente(seletor.fabricaPara(s.provedor())).provisionar(s)));
        }
        for (Thread t : threads) {
            t.start();
        }
        for (Thread t : threads) {
            t.join();
        }

        HistoricoAuditoria.getInstance().imprimir();
    }
}
