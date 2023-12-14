
//Recebe a altura (altura) e a largura (largura) como parâmetros e retorna um inteiro.
//Cria um array linha para armazenar as contagens de diferentes larguras.
//Inicializa linha[1], linha[2], linha[3], e linha[4] conforme as regras do problema.
// loop para calcular linha[i] para i de 5 até a largura (largura). Cada valor é a soma dos quatro valores anteriores, mantendo o resultado módulo MODULO.
// array totalPorLargura e inicializa com os valores de linha.dois loops para considerar a altura. Multiplica linha[i] pelo valor atual de totalPorLargura[i], mantendo o resultado módulo MODULO.
//array estruturaSolida e inicializa estruturaSolida[1] como 1.
//Utiliza um loop para calcular estruturaSolida[larguraAtual] para larguraAtual de 2 até a largura (largura).
//Retorna estruturaSolida[largura], que representa o número de maneiras de construir uma parede sólida com a altura e largura especificadas.
public class Resultado {
    static final int MODULO = 1_000_000_007;

    public static int legoBlocks(int altura, int largura) {
        // Inicialização da contagem para diferentes larguras
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