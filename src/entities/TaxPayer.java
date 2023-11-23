package entities;

public class TaxPayer {
    private Double salaryIncome;
    private Double servicesIncome;
    private Double capitalIncome;
    private Double healthSpending;
    private Double educationSpending;
    public TaxPayer() {

    }
    public TaxPayer(Double salaryIncome, Double servicesIncome, Double capitalIncome, Double healthSpending, Double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public Double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(Double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public Double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(Double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public Double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(Double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public Double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(Double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public Double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(Double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {
        double sum = 0;

        if (salaryIncome < 3000.00) {
            sum += 0.0;
        }
        else if (salaryIncome >= 3000.00 && salaryIncome < 5000.00) {
            sum += salaryIncome * 10 / 100;
        }
        else if (salaryIncome > 5000.00) {
            sum += salaryIncome * 20 / 100;
        }
        return sum;
    }

    public double servicesTex() {
        double sum = 0;
        if (servicesIncome != 0.0) {
            sum += servicesIncome * 15 / 100;
        }

        return sum;
    }
    public double capitalTex() {
        double sum = 0;
        if(capitalIncome != 0.0) {
            sum += capitalIncome * 20 / 100;
        }
        return sum;
    }
    public double grossTax() {
        return salaryTax() + servicesTex() + capitalTex();
    }
    public double taxRebate() {
        double spending = healthSpending + educationSpending;
        double percentageOfTotal = grossTax() * 30 / 100;
        double rebate = 0;
        if (spending >= percentageOfTotal) {
            rebate = percentageOfTotal;
        }
        else if (spending < percentageOfTotal) {
            rebate = spending;
        }

        return rebate;
    }
    public double netTax() {
        return grossTax() - taxRebate();
    }

    public String toString() {
        return "Imposto bruto total: "+
                toString().formatted("%.2f%n"+ grossTax()) +
                "Abatimento: "+
                toString().formatted("%.2f%n" + taxRebate())+
                "Imposto devido: "+
                toString().formatted("%.2f%n" + netTax());
    }



}
