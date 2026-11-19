import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Auditor implements Interessado {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    private final List<String> registros = new ArrayList<>();

    @Override
    public String nome() {
        return "Auditor";
    }

    @Override
    public void atualizar(Lote lote, Interessado autor, double valor) {
        registros.add(String.format("%s | lote '%s' | %s | R$ %.2f",
                LocalDateTime.now().format(FORMATO), lote.nome(), autor.nome(), valor));
    }

    public void imprimirRegistros() {
        System.out.println("=== AUDITORIA: " + registros.size() + " lances aceitos ===");
        for (String registro : registros) {
            System.out.println(registro);
        }
        System.out.println();
    }
}
