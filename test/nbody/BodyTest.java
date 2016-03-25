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
public class BodyTest {
    
    public BodyTest() {
    }
//
    /**
     * Test of move method, of class Body.
     */
    @Test
    public void testMove() {
        Vector f = new Vector(new double[]{5.0, 0.0});
        double dt = 1;
        Body instance = new Body(
                new Vector(new double[]{0.0, 0.0}),
                new Vector(new double[]{0.0, 0.0}),
                10,
                0.02,
                new int[]{255, 150, 250},
                200000,
                "Testing",
                50,
                0.9);
        instance.move(f, dt);
        Vector expResult = new Vector(new double[]{0.5,0});
        Vector result = instance.getPosition();
        assertEquals(expResult.cartesian(0),result.cartesian(0), 0.0000001);
        assertEquals(expResult.cartesian(1),result.cartesian(1), 0.0000001);
        
        
    }
//
//    /**
//     * Test of update method, of class Body.
//     */
//    @Test
//    public void testUpdate() {
//        System.out.println("update");
//        Vector r = null;
//        Body instance = null;
//        instance.update(r);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of forceFrom method, of class Body.
//     */
//    @Test
//    public void testForceFrom() {
//        System.out.println("forceFrom");
//        Body b = null;
//        Body instance = null;
//        Vector expResult = null;
//        Vector result = instance.forceFrom(b);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
    /**
     * Test of repel method, of class Body.
//     */
//    @Test
//    public void testRepel() {
//        double radius = 0.0;
//        
//        Body instance = new Body(
//                new Vector(new double[]{-5.0e10,-2.0e10}),
//                new Vector(new double[]{5.0e04,0.0e00}),
//                3.0e28,
//                0.02,
//                new int[]{255, 150, 250},
//                200000,
//                "Testing",
//                50,
//                0.9);
//        instance.repel(radius);
//        
//    }
////
////    /**
//     * Test of drawtrail method, of class Body.
//     */
//    @Test
//    public void testDrawtrail() {
//        System.out.println("drawtrail");
//        Body instance = null;
//        instance.drawtrail();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of draw method, of class Body.
//     */
//    @Test
//    public void testDraw_0args() {
//        System.out.println("draw");
//        Body instance = null;
//        instance.draw();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of draw method, of class Body.
//     */
//    @Test
//    public void testDraw_double() {
//        double penRadius = 0.07;
//        Body instance = new Body();
//        instance.draw(penRadius);
//    }

    private void String(String testing) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
