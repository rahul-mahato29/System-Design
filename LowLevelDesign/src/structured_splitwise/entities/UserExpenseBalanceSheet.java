package structured_splitwise.entities;

import structured_splitwise.entities.Balance;

import java.util.HashMap;
import java.util.Map;

public class UserExpenseBalanceSheet {
    Map<String, Balance> userVsBalance;
    double totalYourExpense;     //totalYouOwe - totalYouGetBack
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet(){
        userVsBalance = new HashMap<>();
        totalYourExpense = 0;
        totalYouOwe = 0;
        totalYouGetBack = 0;
    }

    public void setTotalPayment(double totalPayment) {
        this.totalPayment = totalPayment;
    }

    public void setTotalYouGetBack(double totalYouGetBack) {
        this.totalYouGetBack = totalYouGetBack;
    }

    public void setTotalYouOwe(double totalYouOwe) {
        this.totalYouOwe = totalYouOwe;
    }

    public void setTotalYourExpense(double totalYourExpense) {
        this.totalYourExpense = totalYourExpense;
    }

    public void setUserVsBalance(Map<String, Balance> userVsBalance) {
        this.userVsBalance = userVsBalance;
    }

    public double getTotalPayment() {
        return totalPayment;
    }

    public double getTotalYouGetBack() {
        return totalYouGetBack;
    }

    public double getTotalYouOwe() {
        return totalYouOwe;
    }

    public double getTotalYourExpense() {
        return totalYourExpense;
    }

    public Map<String, Balance> getUserVsBalance() {
        return userVsBalance;
    }
}
