import java.util.concurrent.atomic.AtomicInteger;

public class AzureFabrica implements FabricaNuvem {

    private static final Tarifas TARIFAS = new Tarifas(0.12, 0.02, 0.50);

    private final AtomicInteger sequenciaMaquina = new AtomicInteger();
    private final AtomicInteger sequenciaArmazenamento = new AtomicInteger();
    private final AtomicInteger sequenciaFila = new AtomicInteger();

    @Override
    public String nomeProvedor() {
        return "Azure";
    }

    @Override
    public Tarifas tarifas() {
        return TARIFAS;
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new AzureMaquinaVirtual("vm-" + sequenciaMaquina.incrementAndGet(), TARIFAS);
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new AzureArmazenamento("blob://" + sequenciaArmazenamento.incrementAndGet(), gb, TARIFAS);
    }

    @Override
    public FilaMensagens criarFila() {
        return new AzureFilaMensagens("sb-" + sequenciaFila.incrementAndGet(), TARIFAS);
    }
}
