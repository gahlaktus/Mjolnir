package com.dragon.refactor.sprint1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author huangzhibo
 * @date 28/07/2017
 */
public class CustomerTest {
    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void statementSingle() throws Exception {

        Customer customer1 = new Customer("客户一");

        Movie movie1 = new Movie("冰与火之歌", 1000);

        Rental rental1 = new Rental(movie1, 7);

        customer1.addRental(rental1);

        String res1 = customer1.statement();

        System.out.println(res1);

    }

    @Test
    public void statementDouble() throws Exception {
        Customer customer2 = new Customer("客户二");
        Movie movie2 = new Movie("纸牌屋", 987);
        Rental rental2 = new Rental(movie2, 9);
        Movie movie3 = new Movie("越狱", 800);
        Rental rental3 = new Rental(movie3, 10);
        customer2.addRental(rental2);
        customer2.addRental(rental3);

        String res1 = customer2.statement();

        System.out.println(res1);
    }

}