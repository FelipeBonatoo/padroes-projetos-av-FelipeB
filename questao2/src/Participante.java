public class Participante implements Interessado {

    private final String nome;

    public Participante(String nome) {
        this.nome = nome;
    }

    @Override
    public String nome() {
        return nome;
    }

    public void darLance(Lote lote, double valor) {
        System.out.println(String.format("%s oferece R$ %.2f no lote '%s'", nome, valor, lote.nome()));
        lote.darLance(this, valor);
    }

    @Override
    public void atualizar(Lote lote, Interessado autor, double valor) {
        System.out.println(String.format("   [%s] novo lance no lote '%s': R$ %.2f", nome, lote.nome(), valor));
    }
}
