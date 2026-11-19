public interface FabricaNuvem {
    String nomeProvedor();

    Tarifas tarifas();

    MaquinaVirtual criarMaquinaVirtual();

    Armazenamento criarArmazenamento(int gb);

    FilaMensagens criarFila();
}
