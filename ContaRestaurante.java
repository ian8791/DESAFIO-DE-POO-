import java.util.Locale;
public class ContaRestaurante {
    private Cliente cliente;
    private Pedido pedido1;
    private Pedido pedido2;
    private Pedido pedido3;
    public ContaRestaurante(Cliente cliente, Pedido pedido1, Pedido pedido2, Pedido pedido3) {
        this.cliente = cliente;
        this.pedido1 = pedido1;
        this.pedido2 = pedido2;
        this.pedido3 = pedido3;
    }
    public double calcularSubtotal() {
        return pedido1.calcularTotalItem() + pedido2.calcularTotalItem() + pedido3.calcularTotalItem();
    }
    public double calcularTaxaServico() {
        double subtotal = calcularSubtotal();
        if (subtotal > 100.0) {
            return subtotal * 0.10; // 10%
        } else {
            return subtotal * 0.05; // 5%
        }
    }
    public double calcularDesconto() {
        String primeiroNomeMaiusculo = cliente.getPrimeiroNome().toUpperCase();
        if (primeiroNomeMaiusculo.charAt(0) == 'A') {
            return 15.0;
        } else {
            return 0.0;
        }
    }

    public double calcularValorFinal() {
        return calcularSubtotal() + calcularTaxaServico() - calcularDesconto();
    }
    public void exibirRelatorio() {
        System.out.println("======== CONTA DO RESTAURANTE ========\n");
        System.out.println("Cliente: " + cliente.nomeMaiusculo());
        System.out.println("Primeiro nome: " + cliente.getPrimeiroNome());
        System.out.println("Mesa: " + cliente.getMesa() + "\n");
        System.out.println("Pedidos:");

        // Agrupando os pedidos em um vetor para satisfazer o requisito do laço FOR
        Pedido[] listaPedidos = {pedido1, pedido2, pedido3};
        for (int i = 0; i < listaPedidos.length; i++) {
            System.out.printf(Locale.US, "%d - %s | Qtd: %d | Total: R$ %.2f\n", 
                (i + 1), 
                listaPedidos[i].getDescricao(), 
                listaPedidos[i].getQuantidade(), 
                listaPedidos[i].calcularTotalItem());
        }
        System.out.println();
        System.out.printf(Locale.US, "Subtotal: R$ %.2f\n", calcularSubtotal());
        System.out.printf(Locale.US, "Taxa de serviço: R$ %.2f\n", calcularTaxaServico());
        System.out.printf(Locale.US, "Desconto: R$ %.2f\n", calcularDesconto());
        System.out.printf(Locale.US, "Valor final: R$ %.2f\n", calcularValorFinal());
    }
}