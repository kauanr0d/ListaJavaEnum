package entities;
import enums.WorkerLevel;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Worker {
    private String name;
    private WorkerLevel level;
    private double baseSalary;
    private Departament departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker(String name, WorkerLevel level, double baseSalary, Departament departament) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.departament = departament;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContract(HourContract contract){
        this.contracts.add(contract);
    }
    public void removeContract(HourContract contract){
        this.contracts.remove(contract);
    }
    public void removeAllContracts(){
        this.contracts.clear();
    }
    public double income(int year,int month){
        double totalSalary = 0;
        List <HourContract> listContracts;
        double k = 0;
        listContracts = this.contracts.stream().filter(n-> n.getDate().getMonth() == Month.of(month) && n.getDate().getYear() == year).collect(Collectors.toList());
        for(HourContract x:listContracts){
            k += x.totalValue();
        }
        totalSalary += k;
        if(totalSalary>0) {
            return totalSalary + this.baseSalary;
        }else{
            return 0;
        }
    }
    public double annualIncomeContracts(int year,int month){
        if(month<=12) {
            double totalSalary = income(year, month);
            return totalSalary + annualIncomeContracts(year, month+1);
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Worker{" +
                "name='" + name + '\'' +
                ", level=" + level +
                ", baseSalary=" + baseSalary +
                ", departament=" + departament +
                '}';
    }
}
