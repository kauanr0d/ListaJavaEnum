package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import enums.WorkerLevel;

import java.time.LocalDate;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Departament departament = new Departament("TI");
        Worker w1 = new Worker("Kauan", WorkerLevel.JUNIOR,1000,departament);
        HourContract contract1 = new HourContract(LocalDate.now(),5,300);
        HourContract contract2 = new HourContract(LocalDate.now(),3,500);
        HourContract contract3 = new HourContract(LocalDate.now().plusMonths(1),3,500);

        w1.addContract(contract1);
        w1.addContract(contract2);
        w1.addContract(contract3);
        System.out.println("Salário total: " + w1.income(2023,6));
        System.out.println("Salario total do ano:"+w1.annualIncomeContracts(2023,1));

    }
}
