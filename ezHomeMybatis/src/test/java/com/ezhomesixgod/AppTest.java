package com.ezhomesixgod;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }


    public static void main(String[] args) {


            System.out.println(get());

    }

    public static int get(){
        int i =1;

        try{
            return ++i;
        }catch (Exception e){

        }finally {
             ++i;

        }
        return i;
    }
}
