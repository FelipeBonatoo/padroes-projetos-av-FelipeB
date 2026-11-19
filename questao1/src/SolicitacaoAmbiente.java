public class SolicitacaoAmbiente {

    private final String nome;
    private final String provedor;
    private final int maquinas;
    private final int gb;

    public SolicitacaoAmbiente(String nome, String provedor, int maquinas, int gb) {
        this.nome = nome;
        this.provedor = provedor;
        this.maquinas = maquinas;
        this.gb = gb;
    }

    public String nome() {
        return nome;
    }

    public String provedor() {
        return provedor;
    }

    public int maquinas() {
        return maquinas;
    }

    public int gb() {
        return gb;
    }
}
