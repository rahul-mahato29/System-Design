package splitwise.expense.split;

import java.util.List;

public interface SplitStrategy {
    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
