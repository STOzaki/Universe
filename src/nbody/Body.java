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
    private final double rad; //radius of the planets
    private Color color; //color
    private double radius; //radius of the frame from Universe.
    private String title; //title
    private ArrayList<double[]> trail = new ArrayList<double[]>();
    private double tlength;
    

    /**
     * 
     * @param r gets the values of the parameter r.
     * @param v gets the values of parameter v.
     * @param mass get the value of the constant mass.
     * @param rad get the value of the constant rad.
     * @param c grabs the color values from the color vector
     * @param radius grabs from the Universe
     * @param title use the title and give it to title
     */
    public Body(Vector r, Vector v, double mass, double rad, int[] c, double radius, String title, double tlength) {
        this.r = r;
        this.v = v;
        this.mass = mass;
        this.rad = rad;
        this.color = new Color(c[0], c[1], c[2]);
        this.radius = radius;
        this.title = title;
        this.tlength = tlength;
      
    } // Body( Vector, Vector, double mass, rad, color, radius, title)
    
    /**
     * 
     * @param f uses this to find the movement.
     * @param dt uses this to find how fast the orbs are moving.
     * uses f and dt(time) to find the position it will be in next, then
     * storing the value.
     * then finding the tail.
     */
    
    public void move(Vector f, double dt) {
        Vector a = f.times(1 / mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
        this.update(r);
    } // move( Vector, double dt)
    
    /**
     * 
     * @param r uses this to make a tail.
     *  it finds the position of the current position of the planet, then
     *  adds it to the trail.  After, it sees if the trail is too long.  If it
     *  is, then it gets rid of the oldest double[].
     */
    public void update(Vector r){
        double[] ap = {r.cartesian(0), r.cartesian(1)};
        trail.add(0,ap);
        if(trail.size() > tlength){
            trail.remove(trail.size() - 1);
        }
    } // update()
    
    /**
     * 
     * @param b is used to find the gravitational force between planets.
     * @return the direction times the force F.
     */
    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )
    
    public void repel(double radius){
        double xp = r.cartesian(0);
        double yp = r.cartesian(1);
        if(xp >= radius) {
            v.xrepel();
        }
        if(yp >= radius) {
            v.yrepel();
        }
        if(xp <= -radius) {
            v.xrepel();
        }
        if(yp <= -radius) {
            v.yrepel();
        }
    }
    
    public void drawtrail(){
        double nr = rad;
        for(int i = 0; i < trail.size()-1; i++){
            if(i%2 == 0){
            nr = nr * 0.9;
            }
            double[] first = trail.get(i);
            double[] second = trail.get(i+1);
            StdDraw.setPenRadius(nr);
            StdDraw.line(first[0],first[1],second[0],second[1]);
        }
    }

    public void draw() {
        StdDraw.setPenColor(StdDraw.WHITE);
        Font font = new Font("Times New Roman", Font.BOLD, 30);
        StdDraw.setFont(font);
        StdDraw.textLeft(-radius, -radius, title);
        StdDraw.setPenRadius(rad);
        StdDraw.setPenColor(this.color);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
        this.drawtrail();
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )
} // Body
