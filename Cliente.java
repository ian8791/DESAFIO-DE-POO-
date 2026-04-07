public class Cliente {
    private String nomeCompleto;
    private int mesa;
    public Cliente(String nomeCompleto, int mesa) {
        this.nomeCompleto = nomeCompleto;
        this.mesa = mesa;
    }
    public String getPrimeiroNome() {
        int espacoIndex = nomeCompleto.indexOf(" ");
        if (espacoIndex != -1) {
            return nomeCompleto.substring(0, espacoIndex);
        }
        return nomeCompleto;
    }
    public String nomeMaiusculo() {
        return nomeCompleto.toUpperCase();
    }
    public int getMesa() {
        return mesa;
    }
}
