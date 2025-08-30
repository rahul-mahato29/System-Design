package splitwise.expense.split;

import splitwise.expense.enums.ExpenseSplitType;

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