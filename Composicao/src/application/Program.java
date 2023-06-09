package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        DateTimeFormatter df1 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        Departament departament = new Departament("TI");
        Worker w1 = new Worker("Kauan", WorkerLevel.JUNIOR,1000,departament);
        HourContract contract1 = new HourContract(LocalDate.now(),5,300);
        HourContract contract2 = new HourContract(LocalDate.now(),3,500);
        HourContract contract3 = new HourContract(LocalDate.now().plusMonths(1),3,500);

        System.out.println("Insira a data do contrato:");
        LocalDate contractDate = LocalDate.parse(sc.next(),df1);
        df1.format(contractDate);
        System.out.println(contractDate.format(df1));

        HourContract contract4 = new HourContract(contractDate,10,500);
        w1.addContract(contract1);
        w1.addContract(contract2);
        w1.addContract(contract3);
        w1.addContract(contract4);
        sc.nextLine();

        System.out.println("Insira o ano e mês: (MM/yyyy)");
        String monthAndYear = sc.nextLine();
        int month = Integer.parseInt(monthAndYear.substring(0,2));
        int year = Integer.parseInt(monthAndYear.substring(3));

        System.out.println("Salário total: " + w1.income(year,month));
        System.out.println("Salario total do ano:"+w1.annualIncomeContracts(2023,1));
        System.out.println(w1.toString());

    }
}
