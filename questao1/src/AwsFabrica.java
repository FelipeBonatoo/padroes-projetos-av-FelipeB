import java.util.concurrent.atomic.AtomicInteger;

public class AwsFabrica implements FabricaNuvem {

    private static final Tarifas TARIFAS = new Tarifas(0.10, 0.023, 0.40);

    private final AtomicInteger sequenciaMaquina = new AtomicInteger();
    private final AtomicInteger sequenciaArmazenamento = new AtomicInteger();
    private final AtomicInteger sequenciaFila = new AtomicInteger();

    @Override
    public String nomeProvedor() {
        return "Aws";
    }

    @Override
    public Tarifas tarifas() {
        return TARIFAS;
    }

    @Override
    public MaquinaVirtual criarMaquinaVirtual() {
        return new AwsMaquinaVirtual("i-" + sequenciaMaquina.incrementAndGet(), TARIFAS);
    }

    @Override
    public Armazenamento criarArmazenamento(int gb) {
        return new AwsArmazenamento("s3://" + sequenciaArmazenamento.incrementAndGet(), gb, TARIFAS);
    }

    @Override
    public FilaMensagens criarFila() {
        return new AwsFilaMensagens("sqs-" + sequenciaFila.incrementAndGet(), TARIFAS);
    }
}
