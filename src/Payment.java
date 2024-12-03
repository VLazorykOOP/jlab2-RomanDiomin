import java.time.Year;

public class Payment {
    private String lastName;
    private String firstName;
    private double salary;
    private int yearOfEmployment;
    private double bonusPercentage;
    private double taxPercentage;
    private int workedDaysInMonth;
    private int daysInMonth;
    private double accruedAmount;
    private double withheldAmount;

    public Payment(String lastName, String firstName, double salary, int yearOfEmployment,
            double bonusPercentage, double taxPercentage, int workedDaysInMonth, int daysInMonth) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.salary = salary;
        this.yearOfEmployment = yearOfEmployment;
        this.bonusPercentage = bonusPercentage;
        this.taxPercentage = taxPercentage;
        this.workedDaysInMonth = workedDaysInMonth;
        this.daysInMonth = daysInMonth;
        this.accruedAmount = 0;
        this.withheldAmount = 0;
    }

    public void calculateAccruedAmount() {
        double baseAmount = (salary * workedDaysInMonth) / daysInMonth;
        double bonus = baseAmount * (bonusPercentage / 100);
        this.accruedAmount = baseAmount + bonus;
    }

    public void calculateWithheldAmount() {
        this.withheldAmount = accruedAmount * (taxPercentage / 100);
    }

    public int calculateYearsOfExperience() {
        int currentYear = Year.now().getValue();
        return currentYear - yearOfEmployment;
    }

    public double getAccruedAmount() {
        return accruedAmount;
    }

    public double getWithheldAmount() {
        return withheldAmount;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Працівник: " + getFullName() + "\n" +
                "Оклад: " + salary + "\n" +
                "Рік поступлення на роботу: " + yearOfEmployment + "\n" +
                "Відсоток надбавки: " + bonusPercentage + "%\n" +
                "Податок: " + taxPercentage + "%\n" +
                "Відпрацьовано днів у місяці: " + workedDaysInMonth + "/" + daysInMonth + "\n" +
                "Нарахована сума: " + accruedAmount + "\n" +
                "Утримана сума: " + withheldAmount + "\n" +
                "Стаж роботи: " + calculateYearsOfExperience() + " років";
    }

    public static void main(String[] args) {
        Payment employee = new Payment(
                "Іванов", "Іван", 20000, 2015, 10, 20, 22, 30);

        employee.calculateAccruedAmount();
        employee.calculateWithheldAmount();

        System.out.println(employee);
    }
}
