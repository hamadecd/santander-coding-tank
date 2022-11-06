import java.util.Scanner;

/**
 * Deve ser solicitado ao usuário o tamanho da matriz a ser criada. Após o input do usuário de ser criado uma matriz quadrada com as informações obtidas.
 * Exemplo: O usuário informou o valor 3 então teremos.
 * [][][]
 * [][][]
 * [][][]
 * Porém ao imprimir a matriz na tela deve ser preenchida a diagonal com os valores 1 e o para as demais posições o valor 0,
 * porém a diagonal deve começar do lado direito. Exemplo da solução esperada:
 * [0][0][1]
 * [0][1][0]
 * [1][0][0]
 */

public class Exercicio3 {
    public static void main(String[] args) {
        // Primeira versão sem pesquisar nada na internet
        Scanner scan = new Scanner(System.in);
        System.out.println("Informe o tamanho da matriz: ");
        int tamanhoMatriz = scan.nextInt();
        int controleDiagonal = tamanhoMatriz - 1;
        int[][] matriz = new int[tamanhoMatriz][tamanhoMatriz];
        for (int linha = 0; linha < matriz.length; linha++) {
            matriz[linha][controleDiagonal] = 1;
            for (int coluna = 0; coluna < matriz[linha].length; coluna++) {
                System.out.print(matriz[linha][coluna] + " ");
            }
            System.out.println();
            controleDiagonal--;
        }


        System.out.println("=============================================");

        String[][] matrizString = new String[tamanhoMatriz][tamanhoMatriz];

        int controleDiagonal2 = tamanhoMatriz - 1;
        for (int linha = 0; linha < matrizString.length; linha++) {
            matrizString[linha][controleDiagonal2] = "1";
            for (int coluna = 0; coluna < matrizString[linha].length; coluna++) {
                if (matrizString[linha][coluna] != "1") {
                    matrizString[linha][coluna] = "0";
                }
                System.out.print(matrizString[linha][coluna] + " ");
            }
            System.out.println();
            controleDiagonal2--;
        }
        scan.close();
    }
}
