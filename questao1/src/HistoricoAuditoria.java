import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class HistoricoAuditoria {

    private static final HistoricoAuditoria INSTANCIA = new HistoricoAuditoria();
    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss.SSS");

    private final List<String> registros = new ArrayList<>();

    private HistoricoAuditoria() {
    }

    public static HistoricoAuditoria getInstance() {
        return INSTANCIA;
    }

    public synchronized void registrar(String ambiente, String provedor, String resultado) {
        registros.add(LocalDateTime.now().format(FORMATO) + " | ambiente=" + ambiente
                + " | provedor=" + provedor + " | resultado=" + resultado);
    }

    public synchronized void imprimir() {
        System.out.println("=== Historico de auditoria (" + registros.size() + " registros) ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
    }
}
