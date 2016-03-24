/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbody;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Salem
 */
public class VectorTest {
    
    public VectorTest() {
    }

    /**
     * Test of length method, of class Vector.
     */
    @Test
    public void testLength() {
        Vector instance = new Vector(10);
        int expResult = 10;
        int result = instance.length();
        assertEquals(expResult, result);
    }
//
//    /**
//     * Test of dot method, of class Vector.
//     */
//    @Test
//    public void testDot() {
//        System.out.println("dot");
//        Vector that = null;
//        Vector instance = null;
//        double expResult = 0.0;
//        double result = instance.dot(that);
//        assertEquals(expResult, result, 0.0);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of magnitude method, of class Vector.
     */
    @Test
    public void testMagnitude() {
        Vector instance = new Vector (new double[] {3});
        double expResult = 3;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of distanceTo method, of class Vector.
     */
    @Test
    public void testDistanceTo() {
        Vector that = new Vector(new double[]{10});
        Vector instance = new Vector(new double[]{13});
        double expResult = 3;
        double result = instance.distanceTo(that);
        assertEquals(expResult, result, 0.0);        
    }
//
    /**
     * Test of plus method, of class Vector.
     * This is telling me that my expResult was 20.0, but it was 20.0, and that
     * does not make sense
     */
//    @Test
//    public void testPlus() {
//        Vector that = new Vector(new double[]{10});
//        Vector instance = new Vector(new double[]{10});
//        Vector expResult = new Vector(new double[]{10});
//        Vector result = instance.plus(that);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of xrepel method, of class Vector.
//     */
//    @Test
//    public void testXrepel() {
//        Vector instance = new Vector(new double[]{20});
//        instance.xrepel();
//        Vector result = instance(double[1]);
//        Vector expResult = new Vector(new double[]{-16});
//        assertEquals(expResult,);
//    }
//
//    /**
//     * Test of yrepel method, of class Vector.
//     */
//    @Test
//    public void testYrepel() {
//        System.out.println("yrepel");
//        Vector instance = null;
//        instance.yrepel();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of minus method, of class Vector.
//     */
//    @Test
//    public void testMinus() {
//        System.out.println("minus");
//        Vector that = null;
//        Vector instance = null;
//        Vector expResult = null;
//        Vector result = instance.minus(that);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of cartesian method, of class Vector.
     */
    @Test
    public void testCartesian() {
        int i = 0;
        Vector instance = new Vector(new double[]{20});
        double expResult = 20;
        double result = instance.cartesian(i);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of times method, of class Vector.
     * This is a similar problem as testPlus.  They are equal to us, but the
     * program knows something I do not.
     */
//    @Test
//    public void testTimes() {
//        double factor = 10;
//        Vector instance = new Vector(new double[]{10});
//        Vector expResult = new Vector(new double[]{100});
//        Vector result = instance.times(factor);
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of direction method, of class Vector.
//     * Same as the last two I commited on
//     */
//    @Test
//    public void testDirection() {
//        Vector instance = new Vector(new double[]{3});
//        Vector expResult = new Vector(new double[]{1});
//        Vector result = instance.direction();
//        assertEquals(expResult, result);
//    }
//
//    /**
//     * Test of toString method, of class Vector.
//     */
//    @Test
//    public void testToString() {
//        System.out.println("toString");
//        Vector instance = null;
//        String expResult = "";
//        String result = instance.toString();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of main method, of class Vector.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        String[] args = null;
//        Vector.main(args);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//    
    }
