import java.util.Random;

public class Laboratorio {
    private static final double VALOR_POR_QUILO = 7.50; // R$ 7,50
    private static final double FRETE_MINIMO = 15.00; // R$ 15.0
    private static final double TAXA_DE_DESCONTO = 0.10; // 10%
    private static final double DESCONTO_MAXIMO = 50.00; // R$

    public static void main(String[] args) {
        exercicioFrete();
    }

    public static void exercicioFrete() {
        double pesoEmQuilos = 0.1;

        double quilosCobrados = Math.ceil(pesoEmQuilos);
        double freteCalculado = quilosCobrados * VALOR_POR_QUILO;
        double freteFinal = Math.max(freteCalculado, FRETE_MINIMO);

        System.out.println("Peso: " + pesoEmQuilos + " Kg");
        System.out.println("Frete: R$ " + freteFinal);

        double descontoFinal = calcularDesconto(freteFinal);
        System.out.printf("Desconto Final : %8.2f%n", descontoFinal);
        String numeroPedido = gerarNumeroDoPedido();
        System.out.printf("Pedido: %20s%n", numeroPedido);

        String nomeProduto = "furadeiRA";
        System.out.printf("Produto: %-20s%n", normalizarNome(nomeProduto));

        int qtdProduto = 3;
        double precoProduto = 378.83;
        nomeProduto = normalizarNome(nomeProduto);

        String linha01 = String.format("%-20s, R$%8.2f x %3d%n", nomeProduto, precoProduto, qtdProduto);
        System.out.print(linha01);

        nomeProduto = " SeRRa EleTRIca";
        nomeProduto = normalizarNome(nomeProduto);
        linha01 = String.format("%-20s, R$%8.2f x %3d%n", nomeProduto, precoProduto, qtdProduto);
        System.out.print(linha01);
    }

    private static double calcularDesconto(double valorDoPedido) {
        double desconto = valorDoPedido * TAXA_DE_DESCONTO;
        return Math.min(desconto, DESCONTO_MAXIMO);
    }

    private static String gerarNumeroDoPedido() {
        Random sorteio = new Random(60);
        int sequencial = sorteio.nextInt(100000); // 0 a 99999
        return String.format("PED-2026-%05d", sequencial);
    }

    private static String normalizarNome(String nomeDigitado) {
        if (nomeDigitado == null || nomeDigitado.isBlank()) {
            return "NAO INFORMADO";
        }
        return nomeDigitado.trim().toUpperCase();
    }
    private static String montarRecibo(String [] produto, double[] precos){
        StringBuilder recibo = new StringBuilder();
        recibo.append("=== RECIBO DO PEDIDO ===").append(System.lineSeparator());
        
        for (int i = 0; i< produto.length; i++){
            recibo.append(String.format("%-20s R$ %8.2f", produto[i], precos[i])).append(System.lineSeparator());
        }
        return recibo.toString();

    }
}