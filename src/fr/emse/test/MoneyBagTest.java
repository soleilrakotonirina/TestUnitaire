package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoneyBagTest {
	
	private Money f12CHF;
	private Money f14CHF;
	private Money f7USD;
	private Money f21USD;
	private MoneyBag fMB1;
	private MoneyBag fMB2;

	public MoneyBagTest() {}
	
	
	
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
	@Before
	public void setUp() {
		f12CHF = new Money(12, "CHF");
		f14CHF= new Money(14, "CHF");
		f7USD= new Money( 7, "USD");
		f21USD= new Money(21, "USD");
		fMB1= new MoneyBag(f12CHF, f7USD);
		fMB2= new MoneyBag(f14CHF, f21USD);
	}

    @After
    public void tearDown() {}

    
    
	@Test
	public void testBagEquals() {
		assertTrue(!fMB1.equals(null));
		assertEquals(fMB1, fMB1);
		assertTrue(!fMB1.equals(f12CHF));
		assertTrue(!f12CHF.equals(fMB1));
		assertTrue(!fMB1.equals(fMB2));
	}

    @Test
    public void testMixedSimpleAdd() {
	    // [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
	    Money bag[] = { f12CHF, f7USD };
	    MoneyBag expected = new MoneyBag(bag);
	    assertEquals(expected, f12CHF.add(f7USD));
    }
    
    // Test  pour ajouter un MoneyBag à un simple Money
    @Test
    public void testBagSimpleAdd() {
        // [12 CHF] + [3 CHF] == {[12 CHF][3 CHF]}
        MoneyBag bag = new MoneyBag(new Money[] {new Money(12, "CHF")});
        Money expected = new Money(3, "CHF");
        assertEquals(new MoneyBag(new Money[] {new Money(12, "CHF"), new Money(3, "CHF")}), bag.add(expected));
    }

    // Test pour ajouter un simple Money à un MoneyBag
    @Test
    public void testSimpleBagAdd() {
        // [12 CHF] + [3CHF]+[4 CHF] == [19 CHF]
        MoneyBag bag = new MoneyBag(new Money(12, "CHF"), new Money(3, "CHF"));
        MoneyBag expected = new MoneyBag(new Money[] {new Money(19, "CHF")});
        assertEquals(expected, bag.add(new Money(4, "CHF")));
    }

    // Test pour ajouter deux MoneyBags
    @Test
    public void testBagBagAdd() {
    	// [12 CHF] + [7 USD] == {[12 CHF][7 USD]}
    	MoneyBag bag1 = new MoneyBag(new Money(12, "CHF"),new Money(3,"EUR"));
    	MoneyBag bag2 = new MoneyBag(new Money(7, "USD"),new Money(2,"ARY"));
    	MoneyBag expected = new MoneyBag(new Money[] {new Money(12, "CHF"), new Money(3,"EUR"), new Money(7, "USD"), new Money(2,"ARY")});
    	assertEquals(expected, bag1.add(bag2));
    }

}
