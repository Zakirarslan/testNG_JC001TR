package techproed.tests.day22_listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;

@Listeners(techproed.utilities.Listeners.class)

public class C01_Listeners1 {



    @Test
    public void test01() {
        System.out.println("test01 pass");
        Assert.assertTrue(true);
    }
    @Test
    public void test02() {
        System.out.println("test02 fail");
        Assert.assertTrue(false);
    }

    @Test
    public void test03() {
        System.out.println("test03 skip");
       throw new SkipException("test skipped");
    }

    @Test
    public void test04() {
        System.out.println("test04 exception");
        throw new NoSuchElementException("No such element exception");
    }
}
