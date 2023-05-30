import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.TaxPayer;

public class TaxCalculator {

	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> taxpayers = new ArrayList<>();

		System.out.print("Quantos contribuintes você vai digitar? ");
		int numContribuintes = sc.nextInt();
		System.out.println();
		for (int i = 1; i <= numContribuintes; i++) {
			System.out.println("Digite os dados do " + (i) + "o." + " contribuinte:");

			System.out.print("Renda anual com salário: ");
			double rendaSalarioAnual = sc.nextDouble();
			double salaryIncome = rendaSalarioAnual / 12.0;

			System.out.print("Renda anual com prestação de serviços: ");
			double servicesIncome = sc.nextDouble();

			System.out.print("Renda anual com ganho de capital: ");
			double capitalIncome = sc.nextDouble();

			System.out.print("Gastos médicos: ");
			double healthSpending = sc.nextDouble();

			System.out.print("Gastos educacionais: ");
			double educationSpending = sc.nextDouble();
			System.out.println();
			taxpayers.add(new TaxPayer(salaryIncome, servicesIncome, capitalIncome, healthSpending, educationSpending));
		}

		for (int i = 0; i < numContribuintes; i++) {
			TaxPayer taxpayer = taxpayers.get(i);
			double impostoBruto = taxpayer.grossTax();
			double impostoDevido = taxpayer.netTax();
			double abatimento = taxpayer.taxRebate();

			System.out.println();
			System.out.println("Resumo do " + (i + 1) + "o. contribuinte");
			System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
			System.out.printf("Abatimento: %.2f\n", abatimento);
			System.out.printf("Imposto devido: %.2f\n", impostoDevido);

		}

		sc.close();

	}
}
