package structured_splitwise.strategies;

import structured_splitwise.entities.Split;

import java.util.List;

public class EqualSplit implements SplitStrategy {
    @Override
    public void validateSplitRequest(List<Split> splitList, double totalAmount) {

        //validate total amount in splits of each user is equal and overall equals to totalAmount or not
        double amountShouldBePresent = totalAmount/splitList.size();

        for(Split split: splitList) {
            if(split.getAmountOwe() != amountShouldBePresent) {
                //throw exception
            }
        }
    }
}
