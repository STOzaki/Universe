package nbody;

import edu.princeton.cs.In;
import edu.princeton.cs.StdDraw;
import java.awt.Color;

/**
 * ****************************************************************************
 * Compilation: javac Universe.java Execution: java Universe dt input.txt
 * Dependencies: Body.java Vector.java StdIn.java StdDraw.java Datafiles:
 * http://www.cs.princeton.edu/introcs/34nbody/2body.txt
 * http://www.cs.princeton.edu/introcs/34nbody/3body.txt
 * http://www.cs.princeton.edu/introcs/34nbody/4body.txt
 * http://www.cs.princeton.edu/introcs/34nbody/2bodyTiny.txt
 *
 * This data-driven program simulates motion in the universe defined by the
 * standard input stream, increasing time at the rate on the command line.
 *
 * % java Universe 25000 4body.txt
 *
 *
 *****************************************************************************
 */
public class Universe {

    private final double radius;     // radius of universe
    private final int N;             // number of bodies
    private final Body[] orbs;       // array of N bodies
    private double[] massive; // initializing massive
    private String title;
    public double pause;
    // read universe from file
    public Universe(String fileName) {

        // the authors' version reads from standard input
        // our version reads from a file
        In inputStream = new In(fileName);

        // number of bodies
        N = inputStream.readInt();

        // the set scale for drawing on screen
        radius = inputStream.readDouble();
        StdDraw.setXscale(-radius, +radius);
        StdDraw.setYscale(-radius, +radius);
        inputStream.readLine();
        title = inputStream.readLine();
        System.out.println(title);
        // read in the N bodies
        orbs = new Body[N];
        for (int i = 0; i < N; i++) {
            double rx = inputStream.readDouble();
            double ry = inputStream.readDouble();
            double vx = inputStream.readDouble();
            double vy = inputStream.readDouble();
            double mass = inputStream.readDouble();
            double rad = inputStream.readDouble();
            int red = inputStream.readInt();
            int green = inputStream.readInt();
            int blue = inputStream.readInt();
            int[] c ={red,green,blue};
//            massive[i] = mass;
            double[] position = {rx, ry};
            double[] velocity = {vx, vy};
            Vector r = new Vector(position);
            Vector v = new Vector(velocity);
            orbs[i] = new Body(r, v, mass,rad,c,radius,title);
        } // for
    } // Universe()

    // increment time by dt units, assume forces are constant in given interval
    public void increaseTime(double dt) {

        // initialize the forces to zero
        Vector[] f = new Vector[N];
        for (int i = 0; i < N; i++) {
            f[i] = new Vector(new double[2]);
        } // for

        // compute the forces
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i != j) {
                    f[i] = f[i].plus(orbs[i].forceFrom(orbs[j]));
                } // if
            } // for
        } // for

        // move the bodies
        for (int i = 0; i < N; i++) {
            orbs[i].move(f[i], dt);
        } // for
    } // increaseTime( double )

    // draw the N bodies
    public void draw() {
        for (int i = 0; i < N; i++) {
            orbs[i].draw();
        } // for
    } // draw()
    
    /* Launching the simulation for a universe.
    *
    *  Drawing the background, and setting the time
    *  then use the draw function to make the image.
    *  And, the world will keep refreshing itself for all time.
    *  In addiiton, if you press the button 't', you can stop time.
    */
    public static void main(String[] args) {
        Universe newton = new Universe( args[1] );
        double dt = Double.parseDouble(args[0]);
        while (true) {
            StdDraw.clear(StdDraw.BLACK);
            newton.increaseTime(dt);
            if(StdDraw.hasNextKeyTyped()){
                if(StdDraw.nextKeyTyped() == 't'){
                    if(newton.pause > 0){
                    dt = newton.pause;
                    newton.pause = 0;
                }
                    else{
                    newton.pause = dt;
                    dt = 0;
                    }
                }
                
            }
            
            newton.draw();
            StdDraw.show(10);
        } // while
    } // main( String [] )
} // Universe
