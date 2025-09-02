package splitwise.expense;

import splitwise.expense.enums.ExpenseSplitType;
import splitwise.expense.split.EqualSplit;
import splitwise.expense.split.PercentageSplit;
import splitwise.expense.split.SplitStrategy;
import splitwise.expense.split.UnequalSplit;

public class SplitFactory {

    public static SplitStrategy getSplitObject(ExpenseSplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualSplit();
            case UNEQUAL:
                return new UnequalSplit();
            case PERCENTAGE:
                return new PercentageSplit();
            default:
                return null;
        }
    }
}