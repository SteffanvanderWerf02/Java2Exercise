import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    public final Money money = new Money();

    @Test
    void roundSimpleTest() {
        assertEquals(20, money.round(20.20343), "The money is not rounded");
    }

    @Test
    void addInterestSimpleTest() {
        assertEquals(40, money.addInterest(20,100));
    }

    @Test
    void exchange() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(200);
        list.add(200);
        list.add(100);
        assertEquals(list, money.exchange(500));
    }
}