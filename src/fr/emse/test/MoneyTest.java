package fr.emse.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class MoneyTest {
	
	private Money m12CHF;
    private Money m14CHF;
    
    public MoneyTest() {}
    
    
    @BeforeClass
    public static void setUpClass() {}
    
    @AfterClass
    public static void tearDownClass() {}
    
    @Before
    public void setUp() {
        m12CHF = new Money(12, "CHF");
        m14CHF = new Money(14, "CHF");
    }

    @After
    public void tearDown() {}
    
    @Test
    public void testSimpleAdd() {
        Money expected = new Money(26, "CHF");
        IMoney result = m12CHF.add(m14CHF);
        assertEquals(expected, result);
    }

    
    
    @Test
    public void testEquals() {
        assertTrue(!m12CHF.equals(null));
        assertEquals(m12CHF, m12CHF);
        assertEquals(m12CHF, new Money(12, "CHF"));
        assertTrue(!m12CHF.equals(m14CHF));
    }

}
