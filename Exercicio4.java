/**
 * Um quadrado pode ser considerado como perfeito quando a soma de todas as linhas resultam no mesmo valor. 
 * Também a soma das colunas resultam no mesmo valor e, ainda, a soma das diagonais principal e secundária também resultam no mesmo valor.
 * Escreva um algoritmo que calcule se o quadrado pode ser considerado como perfeito. Para isso deve ser capturado o tamanho do quadrado a partir de input do usuário.
 */

import java.util.Random;
import java.util.Scanner;

public class Exercicio4 {

    public static void main(String[] args) {
        int[][] matriz = montarEPreencherQuadrado();
        int somaLinha, somaColuna;
        int primeiraLinha = 0, primeiraColuna = 0, diagonal = 0, diagonalInversa = 0, contador = 0;

        for (int coluna = 0; coluna < matriz.length; coluna++) {
            primeiraLinha = primeiraLinha + (matriz[0][coluna]);
        }

        for (int linha = 0; linha < matriz.length; linha++) {
            primeiraColuna = primeiraColuna + (matriz[linha][0]);
        }

        for (int linha = 0; linha < matriz.length; linha++) {
            diagonal = diagonal + (matriz[linha][contador]);
            contador++;
        }

        contador = 1;

        for (int linha = 0; linha < matriz.length; linha++) {
            diagonalInversa = diagonalInversa + (matriz[linha][matriz.length - contador]);
            contador++;
        }

        boolean quadradoPerfeito = true;

        if (diagonal != diagonalInversa) {
            quadradoPerfeito = false;
        }

        if (quadradoPerfeito) {
            for (int linha = 1; linha < matriz.length; linha++) {
                somaLinha = 0;
                for (int coluna = 0; coluna < matriz.length; coluna++) {
                    somaLinha = somaLinha + (matriz[linha][coluna]);
                }
                if (somaLinha != primeiraLinha || somaLinha != diagonal || somaLinha != diagonalInversa) {
                    quadradoPerfeito = false;
                    break;
                }
            }
        }

        if (quadradoPerfeito) {
            for (int coluna = 1; coluna < matriz.length; coluna++) {
                somaColuna = 0;
                for (int linha = 0; linha < matriz.length; linha++) {
                    somaColuna = somaColuna + (matriz[linha][coluna]);
                }
                if (somaColuna != primeiraColuna || somaColuna != diagonal || somaColuna != diagonalInversa) {
                    quadradoPerfeito = false;
                    break;
                }
            }
        }

        if (quadradoPerfeito) {
            System.out.println("Quadrado perfeito!");
        } else {
            System.out.println("Não é um quadrado perfeito!");
        }
    }

    public static int[][] montarEPreencherQuadrado() {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe o tamanho do quadrado desejado:");
        int tamanho = scanner.nextInt();
        int[][] matriz = new int[tamanho][tamanho];
        for (int linha = 0; linha < matriz.length; linha++) {
            int[] colunas = matriz[linha];
            for (int coluna = 0; coluna < colunas.length; coluna++) {
                int valorAleatorio = random.nextInt(1, 11);
                colunas[coluna] = valorAleatorio;
                System.out.print("[" + valorAleatorio + "]");
            }
            System.out.println();
        }
        scanner.close();
        return matriz;
    }

}