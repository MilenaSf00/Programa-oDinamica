/**
 * A classe Resultado fornece um método estático para calcular o número de maneiras de construir uma parede sólida
 * com base nas regras do problema relacionado a blocos de Lego.
 */
public class Resultado {
     /**
     * Representa o módulo usado nas operações, definido como 1_000_000_007.
     */
    static final int MODULO = 1_000_000_007;
/**
     * Calcula o número de maneiras de construir uma parede sólida com a altura e largura especificadas,
     * utilizando blocos de Lego de diferentes larguras.
     *
     * @param altura  A altura desejada da parede.
     * @param largura A largura desejada da parede.
     * @return O número de maneiras de construir a parede sólida.
     */
    public static int legoBlocks(int altura, int largura) {
        int[] linha = new int[largura + 1];
        linha[1] = 1;
        if (largura >= 2)
            linha[2] = 2;
        if (largura >= 3)
            linha[3] = 4;
        if (largura >= 4)
            linha[4] = 8;
        // Contagem para larguras maiores
        for (int i = 5; i <= largura; i++) {
            linha[i] = (linha[i - 1] + linha[i - 2] +
                    linha[i - 3] + linha[i - 4]) % MODULO;
        }
        // Contagem total por largura, considerando a altura
        int[] totalPorLargura = linha.clone();
        for (int j = 2; j <= altura; j++) {
            for (int i = 1; i <= largura; i++) {
                totalPorLargura[i] = (linha[i] * totalPorLargura[i]) % MODULO;
            }
        }
        // Contagem de estruturas sólidas
        int[] estruturaSolida = new int[largura + 1];
        estruturaSolida[1] = 1;
        for (int larguraAtual = 2; larguraAtual <= largura; larguraAtual++) {
            int somaNaoSolida = 0;
            for (int i = 1; i < larguraAtual; i++) {
                somaNaoSolida = (somaNaoSolida + (estruturaSolida[i] * totalPorLargura[larguraAtual - i]) % MODULO)
                        % MODULO;
            }
            estruturaSolida[larguraAtual] = (totalPorLargura[larguraAtual] - somaNaoSolida + MODULO) % MODULO;
        }
        return estruturaSolida[largura];
    }

}