public class SeletorProvedor {

    private final FabricaNuvem aws = new AwsFabrica();
    private final FabricaNuvem azure = new AzureFabrica();

    public FabricaNuvem fabricaPara(String provedor) {
        if ("Aws".equalsIgnoreCase(provedor)) {
            return aws;
        }
        if ("Azure".equalsIgnoreCase(provedor)) {
            return azure;
        }
        throw new IllegalArgumentException("Provedor desconhecido: " + provedor);
    }
}
