/*
Escreva um algoritmo para desenhar uma pirâmide utilizando o print.
A pirâmide deve ter o tamanho definido pelo usuário através de um input de dados(Scanner). Veja o exemplo abaixo:

        Caso o usuário informe que deseja uma pirâmide de tamanho 3, então deve sair o seguinte resultado:

        --#--
        -###-
        #####
        Caso o usuário informe que deseja uma pirâmide de tamanho 5 então deve ser desenhado o seguinte:

        ----#----
        ---###---
        --#####--
        -#######-
        #########
*/

import java.util.Scanner;

public class Exercicio5 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Defina o tamanho da piramide: ");
        int tamanhoPiramide = scan.nextInt();
        int controle = tamanhoPiramide - 1;
        String caracter = "#";
        for (int i = tamanhoPiramide; i > 0; i--) {
            for (int j = controle; j > 0; j--) {
                System.out.print("-");
            }
            System.out.print(caracter);
            for (int k = controle; k > 0; k--) {
                System.out.print("-");
            }
            controle--;
            System.out.println();
            caracter = caracter + "##";
        }
        scan.close();
    }
}
