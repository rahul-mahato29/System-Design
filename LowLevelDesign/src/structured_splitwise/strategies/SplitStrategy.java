package structured_splitwise.strategies;

import structured_splitwise.entities.Split;

import java.util.List;

public interface SplitStrategy {
    public void validateSplitRequest(List<Split> splitList, double totalAmount);
}
