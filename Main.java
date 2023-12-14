/**
 * A classe Main é responsável por interagir com o usuário, solicitando o número de casos de teste,
 * altura e largura da parede e exibindo os resultados obtidos pelo método legoBlocks da classe Resultado.
 */
import java.util.Scanner;

public class Main {
     /**
     * Método principal que solicita ao usuário o número de casos de teste, altura e largura da parede
     * e exibe os resultados para cada caso de teste.
     *
     * @param args Argumentos da linha de comando.
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o número de casos de teste:");
        int numeroCasosTeste = scanner.nextInt();

        for (int casoAtual = 0; casoAtual < numeroCasosTeste; casoAtual++) {
            System.out.println("Digite a altura e largura (separados por espaço):");
            int altura = scanner.nextInt();
            int largura = scanner.nextInt();
            // Chama a função legoBlocks para obter o resultado
            int resultado = Resultado.legoBlocks(altura, largura);

            System.out.println("Resultado para o caso de teste " + (casoAtual + 1) + ": " + resultado);
        }

        scanner.close();
    }
}
