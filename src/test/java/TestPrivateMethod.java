

import Bit2c.api.NBit2c;
import Bit2c.entities.results.Private.Balance.UserBalance;
import org.testng.annotations.Test;



public class TestPrivateMethod {
    @Test
    public void testUserBalance() {
        UserBalance ub = new NBit2c().getAccountBalance();

    }
}
