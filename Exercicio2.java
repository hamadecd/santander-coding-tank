/**
 * Um funcionário deseja saber qual o valor liquido anual que recebe da sua empresa. Para tal calculo é necessário
 * considerar que o funcionário recebe o salário + décimo terceiro + férias e não esqueça de considerar o desconto do inss.
 * O inss tem desconto com base no valor mensal que o funcionário trabalha e para isso vamos utilizar a regra a seguir:
 * de 0 até 1212.00 -> 7,5%.
 * de 1212.01 até 2427,35 -> 9%.
 * de 2427,36 até 3641,03 -> 12%.
 * de 3641,04 até 7087,22 -> 14%.
 * acima de 7087,22 deve ser descontado o teto de 900 reais.
 *
 * O resultado final apresentado ao funcionário deve ter o salário anual bruto, total anual de inss descontado e o
 * salário anual líquido final.
 * 
 * @author Samir Hamade
 *
 */

import java.text.NumberFormat;
import java.util.Scanner;

public class Exercicio2 {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
		NumberFormat dinheiro = NumberFormat.getCurrencyInstance();
        String controle = "";
        double salario, descontoInssMensal, salarioLiquidoAnual, descontoInssAnual;
        System.out.println("*******************************BEM VINDO AO SISTEMA***************************************");

        do {
            System.out.println("Informe o seu salário: ");
            salario = scan.nextDouble();
        	if(salario <= 0) {
        		 System.out.println("Salário tem que ser maior que zero");
        		 break;
        	} 

            double decimoTerceiro = salario; // só pra ficar explícito no salarioBrutoAnual
            double ferias = salario + (salario * 0.3333);
            double salarioBrutoAnual = (salario * 11) + ferias + decimoTerceiro;

            if(salario <= 1212.00) {
                descontoInssMensal = 0.075;
                descontoInssAnual = salarioBrutoAnual * descontoInssMensal;
                salarioLiquidoAnual = salarioBrutoAnual - descontoInssAnual;
                System.out.printf("Salário menor do que R$ 1.212,00. Desconto INSS de 7,5 porcento no valor de R$ %.2f mensal\n", descontoInssMensal * salario);
            } else if (salario <= 2427.35) {
                descontoInssMensal = 0.09;
                descontoInssAnual = salarioBrutoAnual * descontoInssMensal;
                salarioLiquidoAnual = salarioBrutoAnual - descontoInssAnual;
                System.out.printf("Salário maior do que R$ 1.212,00 e menor igual a R$ 2.427,35. Desconto INSS de 9 porcento no valor de R$ %.2f mensal\n", descontoInssMensal * salario);
            } else if (salario <= 3641.03) {
                descontoInssMensal = 0.12;
                descontoInssAnual = salarioBrutoAnual * descontoInssMensal;
                salarioLiquidoAnual = salarioBrutoAnual - descontoInssAnual;
                System.out.printf("Salário maior do que R$ 2.427,35 e menor igual a R$ 3641,03. Desconto INSS de 12 porcento no valor de R$ %.2f mensal\n", descontoInssMensal * salario);
            } else if (salario <= 7087.22) {
                descontoInssMensal = 0.14;
                descontoInssAnual = salarioBrutoAnual * descontoInssMensal;
                salarioLiquidoAnual = salarioBrutoAnual - descontoInssAnual;
                System.out.printf("Salário maior do que R$ 3.641,03 e menor igual a R$ 7.087,22. Desconto INSS de 14 porcento no valor de R$ %.2f mensal\n", descontoInssMensal * salario);
            } else {
                descontoInssMensal = 900.00 / salario;
                descontoInssAnual = salarioBrutoAnual * descontoInssMensal;
                salarioLiquidoAnual = salarioBrutoAnual - descontoInssAnual;
                System.out.printf("Salário maior do que R$ 7.087,22. Desconto INSS no valor de R$ %.2f mensal\n", descontoInssMensal * salario);
            }

            System.out.printf("""
                        Salário anual bruto: %s\s
                        Total anual de INSS descontado: %s\s
                        Salário anual líquido: %s\s
                        ******************************************************************************************""",
                        dinheiro.format(salarioBrutoAnual),
                        dinheiro.format((descontoInssMensal * 12 + descontoInssAnual)),
                        dinheiro.format(salarioLiquidoAnual));

            System.out.println("\nDeseja fazer um novo cálculo? (S/N)");
            controle = scan.next().toLowerCase();
        } while (controle.equals("s") || controle.equals("sim"));
        System.out.println("Programa encerrado!");
        scan.close();
	}

}
