package com.mycompany.parcial2;

import org.junit.Test;



import static org.junit.Assert.assertEquals;

public class MathServiceTest {

    @Test
    public void testLinearSearchFound() {
        int[] list = {10, 20, 30, 40, 50};
        int target = 30;
        int expected = 2;
        assertEquals(expected, MathService.linearSearch(list, target));
    }

    @Test
    public void testLinearSearchNotFound() {
        int[] list = {10, 20, 30, 40, 50};
        int target = 60;
        int expected = -1;
        assertEquals(expected, MathService.linearSearch(list, target));
    }

    @Test
    public void testBinarySearchFound() {
        int[] list = {10, 20, 30, 40, 50};
        int target = 40;
        int expected = 3;
        assertEquals(expected, MathService.bbinaria(list, 0, list.length - 1, target));
    }

    @Test
    public void testBinarySearchNotFound() {
        int[] list = {10, 20, 30, 40, 50};
        int target = 60;
        int expected = -1;
        assertEquals(expected, MathService.bbinaria(list, 0, list.length - 1, target));
    }
}
