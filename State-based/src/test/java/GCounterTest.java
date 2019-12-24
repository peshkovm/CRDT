import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class GCounterTest {

    private GCounter counter1;
    private GCounter counter2;
    private GCounter counter3;
    private Random rand = new Random(System.currentTimeMillis());

    @Before
    public void setUp() throws Exception {
        counter1 = new GCounter(3, 0);
        counter2 = new GCounter(3, 1);
        counter3 = new GCounter(3, 2);
    }

    @Test
    public void increment() {
        for (int i = 0; i < 100; i++) {
            int value = counter1.value();
            counter1.increment();
            Assert.assertEquals(value + 1, counter1.value());
        }
    }

    @Test
    public void value() {
        for (int i = 0; i < rand.nextInt(10); i++)
            counter1.increment();
        for (int j = 0; j < rand.nextInt(10); j++)
            counter2.increment();
        for (int k = 0; k < rand.nextInt(10); k++)
            counter3.increment();
        int value = counter1.value();
        counter1.merge(counter2);
        counter1.merge(counter3);
        Assert.assertEquals(counter1.value(), value + counter2.value() + counter3.value());
    }

    @Test
    public void merge() {
        for (int i = 0; i < rand.nextInt(10); i++)
            counter1.increment();
        for (int j = 0; j < rand.nextInt(10); j++)
            counter2.increment();
        int value = counter1.value();
        int value1 = counter2.value();
        counter1.merge(counter2);
        Assert.assertEquals(value + value1, counter1.value());
    }
}