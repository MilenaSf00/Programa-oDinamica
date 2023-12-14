/**
 * A classe Main é responsável por interagir com o usuário, solicitando o número de casos de teste,
 * altura e largura da parede e exibindo os resultados obtidos pelo método legoBlocks da classe Resultado.
 */
import java.util.Scanner;
import java.util.logging.Logger;


public class Main {
    private static final Logger LOGGER = Logger.getLogger(Resultado.class.getName());

  
/**
     * Método principal que solicita ao usuário o número de casos de teste, altura e largura da parede
     * e exibe os resultados para cada caso de teste.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LOGGER.info("Insira o número de casos de teste:");
        int numeroCasosTeste = scanner.nextInt();

        for (int casoAtual = 0; casoAtual < numeroCasosTeste; casoAtual++) {
            System.out.println("---------------------------------");

            LOGGER.info("Digite a altura e largura (separados por espaço):");
            int altura = scanner.nextInt();
            int largura = scanner.nextInt();

            scanner.nextLine();

            // Chama a função legoBlocks para obter o resultado
       
            int resultado = Resultado.legoBlocks(altura, largura);
           

            LOGGER.info(String.format("Resultado para o caso de teste %d: %d", casoAtual + 1, resultado));
           // LOGGER.info(String.format("Tempo de execução para o caso de teste %d: %d milissegundos", casoAtual + 1, endTime - startTime));
        }

        scanner.close();
    }
}