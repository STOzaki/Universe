package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

/**
 * ****************************************************************************
 * Compilation: javac Body.java Execution: java Body Dependencies: Vector.java
 * StdDraw.java
 *
 * Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 *****************************************************************************
 */
public class Body {

    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass; // mass
    private final double rad; //radius
    private Color color; //color
    private double radius; //radius of the frame from Universe.
    private String title; //title
    private ArrayList<double[]> trail = new ArrayList<double[]>();
   
    /**
     * puts the instance values into the parameter.
     *
     * @param r gets the values of the constant r.
     * @param v gets the values of the constant v.
     * @param mass get the value of the constant mass.
     * @param rad get the value of the constant rad.
     * @param c grabs the color values from the color vector
     * @param radius grabs from the Universe
     */
    public Body(Vector r, Vector v, double mass, double rad, int[] c, double radius, String title) {
        this.r = r;
        this.v = v;
        this.mass = mass;
        this.rad = rad;
        this.color = new Color(c[0], c[1], c[2]);
        this.radius = radius;
        this.title = title;
      
    } // Body( Vector, Vector, double mass, rad, color)

    public void move(Vector f, double dt) {
        Vector a = f.times(1 / mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
        this.update(r);
    } // move( Vector, double )
    public void update(Vector r){
        if (trail.isEmpty()){
            for(int i = 0; i < 150; i++){
            double[] first = {r.cartesian(0),r.cartesian(1)};
            trail.add(first);
            } 
        }
        double[] position = {r.cartesian(0),r.cartesian(1)};
        for(int i = 0; i < trail.size()-1; i++){
            double[] extra = trail.get(i+1);
            trail.set(i, extra);
        }
        double[] np = {r.cartesian(0),r.cartesian(1)};
        trail.set(149,np); 
    }
    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    public void draw() {
        StdDraw.setPenColor(StdDraw.WHITE);
        Font font = new Font("Times New Roman", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.textLeft(-radius, -radius, title);
        StdDraw.setPenRadius(rad);
        StdDraw.setPenColor(this.color);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
        StdDraw.setPenRadius(rad*0.3);
        for(int i = 0; i < trail.size()-1; i++){
            double[] first = trail.get(i);
            double[] second = trail.get(i+1);
            StdDraw.line(first[0],first[1],second[0],second[1]);
        }
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )
} // Body
