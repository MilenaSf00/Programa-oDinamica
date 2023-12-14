
import java.util.Scanner;

public class Main {
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
