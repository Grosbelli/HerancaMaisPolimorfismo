package application;

import entities.PayerCompany;
import entities.PayerIndividual;
import entities.Payers;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        List<Payers> payerList = new ArrayList<>();

        System.out.print("Enter the number of tax payers: ");
        Integer taxPayers = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= taxPayers ; i++){
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or company (i/c)? ");
            char typePayer = sc.next().charAt(0);
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Anual income: ");
            Double anualIncome = sc.nextDouble();
            sc.nextLine();

            if(typePayer == 'i') {
                System.out.print("Health expenditures: ");
                Double healthExpenditures = sc.nextDouble();
                sc.nextLine();

                payerList.add(new PayerIndividual(name, anualIncome, healthExpenditures));
            } else {
                System.out.print("Number of employees: ");
                Integer employeesNumber = sc.nextInt();

                payerList.add(new PayerCompany(name, anualIncome, employeesNumber));
            }

        }

        System.out.println("\nTAXES PAID: ");
        double totalTaxes = 0;

        for (Payers p : payerList) {
            double tax = p.taxesPaid();
            System.out.println(p.getName() + ": $ " + String.format("%.2f",tax));
            totalTaxes += tax;
        }

        System.out.printf("TOTAL TAXES: $ %.2f%n", totalTaxes);

        sc.close();

    }
}
