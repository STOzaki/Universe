package nbody;

import edu.princeton.cs.StdDraw;

/******************************************************************************
 *  Compilation:  javac Body.java
 *  Execution:    java Body
 *  Dependencies: Vector.java StdDraw.java
 *
 *  Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 ******************************************************************************/

public class Body {
    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass; // mass
    private final double rad; //radius
    private final double radius; //the hight and width of the frame of the Universe.

    /**
     * puts the instance values into the parameter.
     * 
     * @param r gets the values of the constant r.
     * @param v gets the values of the constant v.
     * @param mass get the value of the constant mass.
     * @param rad get the value of the constant rad.
     * @param radius get the value of the constant radius.
     */
    public Body(Vector r, Vector v, double mass, double rad, double radius) {
        this.r = r;
        this.v = v;
        this.mass = mass;
        this.rad = rad;
        this.radius = radius;
    } // Body( Vector, Vector, double mass, rad)

    public void move(Vector f, double dt,double radius) {
        if(radius == r[0]||radius == r[1]){
            
        }
        Vector a = f.times(1/mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
    } // move( Vector, double )

    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    public void draw() {
        StdDraw.setPenRadius(rad);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw()

    // this method is only needed if you want to change the size of the bodies
    public void draw(double penRadius) {
        StdDraw.setPenRadius(penRadius);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
    } // draw( double )
} // Body
