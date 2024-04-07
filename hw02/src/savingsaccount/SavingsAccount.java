package savingsaccount;

public class SavingsAccount{
    static double InterestRate = 0.01;
    double saving;
    static public void modifyInterestRate(double interestRate)
    {
        InterestRate = interestRate;
    }

    SavingsAccount(double savings)
    {
        saving = savings;
    }

    public double calculateMonthlyInterest()
    {
        double s = saving * (Math.pow((InterestRate + 1.0) , 1.0/12.0) - 1);
        saving += s;
        return s;
    }

}
