package entities;

public class PayerCompany extends Payers {
    private Integer employeesNumber;

    public PayerCompany(String name, Double anualIncome, Integer employeesNumber) {
        super(name, anualIncome);
        this.employeesNumber = employeesNumber;
    }

    public Integer getEmployeesNumber() {
        return employeesNumber;
    }

    public void setEmployeesNumber(Integer employeesNumber) {
        this.employeesNumber = employeesNumber;
    }

    @Override
    public Double taxesPaid() {
        double tax;
        if (employeesNumber > 10) {
            tax = getAnualIncome() * 0.14;
        } else {
            tax = getAnualIncome() * 0.16;
        }
        return tax;
    }
}
