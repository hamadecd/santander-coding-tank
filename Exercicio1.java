/**
 * Desenvolver um programa que deverá desenhar um triângulo conforme a figura abaixo.
******
*****
****
***
**
*
 * O programa deverá receber quantidade de linhas a serem impressas.
 */

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Informe a quantidade de linhas para determinar o tamanho do triângulo: ");
        int numeroDeLinhas = scan.nextInt();

        for (int i = numeroDeLinhas; i > 0; i--) {
            System.out.println("*".repeat(i));
        }
        scan.close();
    }
}
