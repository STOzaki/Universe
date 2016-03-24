package nbody;

/******************************************************************************
 *  Compilation:  javac Vector.java
 *  Execution:    java Vector
 *
 *  Implementation of a vector of real numbers.
 *
 *  This class is implemented to be immutable: once the client program
 *  initialize a Vector, it cannot change any of its fields
 *  (N or data[i]) either directly or indirectly. Immutability is a
 *  very desirable feature of a data type.
 *
 *
 *  % java Vector
 *  x        =  (1.0, 2.0, 3.0, 4.0)
 *  y        =  (5.0, 2.0, 4.0, 1.0)
 *  x + y    =  (6.0, 4.0, 7.0, 5.0)
 *  10x      =  (10.0, 20.0, 30.0, 40.0)
 *  |x|      =  5.477225575051661
 *  (x, y)   =  25.0
 *  |x - y|  =  5.0990195135927845
 *
 *  Note that java.util.Vector is an unrelated Java library class.
 *
 ******************************************************************************/

public class Vector { 

    private final int N;         // length of the vector
    private final double[] data;       // array of vector's components

    /**
     * sets this data to the double [N].
     * @param N takes it and puts it into double array called data.
     */
    public Vector(int N) {
        this.N = N;
        this.data = new double[N];
    } // Vector( int )

    /**
     * sets the instance variable to the parameter data.
     * 
     * @param data using this, it sets N as the length of data array.
     */
    public Vector(double[] data) {
        N = data.length;

        // defensive copy so that client can't alter our copy of data[]
        this.data = new double[N];
        for (int i = 0; i < N; i++) {
            this.data[i] = data[i];
        } // for
    } // Vector( double [] )
    
    
    /**
     * return the length of the vector.
     */
    public int length() {
        return N;
    } // length()

    /**
     * finds the inner product of this Vector a and b.
     * 
     * @param that is used to see if the parameter and the instance N are equal.
     * @return the sum of every parameter data[] and instance data in this class
     * stored.
     */
    public double dot(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        double sum = 0.0;
        for (int i = 0; i < N; i++)
            sum = sum + (this.data[i] * that.data[i]);
        return sum;
    } // dot( Vector )

    /**
     * finds the square root of the instance variable times itself.
     * 
     * @return the Euclidean norm of this Vector
     */
    public double magnitude() {
        return Math.sqrt(this.dot(this));
    } // magnitude()

    /**
     * gets that find the magnitude of this - that.
     * 
     * @param that is parameter that is used to check if it is the same as the
     * global instance variable N, then returns the magnitude of this - that.
     * @return the Euclidean distance between this and that (bodies).
     */
    public double distanceTo(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        return this.minus(that).magnitude();
    } // distanceTo( Vector )

    /**
     * checks to see if that and this are equal, if so than add both this data
     * and that data into a new data.
     * 
     * @param that is added to this to form a new data[], if the dimensions are
     * equal (this.N = that.N).
     * @return this + that
     */
    
    public Vector plus(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] + that.data[i];
        return c;
    } // plus( Vector )
    
    /**
     * This will multiply the data of the first element with negative 0.8.
     * 
     * This is used to have the orb go the opposite direction.  The 0.8 is
     * to lose energy when bouncing off the walls.
     */
    public void xrepel(){
        data[0] = data[0] * -0.8;
    } // xrepel()
    
    /**
     * This will multiply the data of the second element with negative 0.8.
     * 
     * This is used to have the orb go the opposite direction.  The 0.8 is
     * to lose energy when bouncing off the walls.
     */
    public void yrepel(){
        data[1] = data[1] * -0.8;
    } // yrepel()

    /**
     * return this - that, then it is stored in a new data[].
     * @param that is used to subtract this.
     * @return the new data[] (c).
     */
    public Vector minus(Vector that) {
        if (this.N != that.N) {
            throw new RuntimeException("Dimensions don't agree");
        } // if
        
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = this.data[i] - that.data[i];
        return c;
    } // minus( Vector )

    /**
     * 
     * @param i is the coordinate in the data that you want to return.
     * @return the corresponding coordinate.
     */
    public double cartesian(int i) {
        return data[i];
    } // cartesian( int )

    /**
     * create and return a new object whose value is (this * factor)
     * 
     * @param factor * each data[].
     * then stored.
     * @return c.
     */
    public Vector times(double factor) {
        Vector c = new Vector(N);
        for (int i = 0; i < N; i++)
            c.data[i] = factor * data[i];
        return c;
    } // times( double factor )


    /**
     * finds out the new vector.
     * @return the corresponding unit vector
     */
    public Vector direction() {
        if (this.magnitude() == 0.0) {
            throw new RuntimeException("Zero-vector has no direction");
        } // if
        
        return this.times(1.0 / this.magnitude());
    } // direction()

    /**
     * overrides the original string and replace with a new one, then returns
     * the new string (s).
     * 
     * @return a string representation of the vector
     */
    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("(");
        for (int i = 0; i < N; i++) {
            s.append(data[i]);
            if (i < N-1) s.append(", ");
        } // for
        s.append(")");
        return s.toString();
    } // toString()


    /**
     * this will test the program.
     * 
     * @param args main's argument.
     */
    public static void main(String[] args) {
        double[] xdata = { 1.0, 2.0, 3.0, 4.0 };
        double[] ydata = { 5.0, 2.0, 4.0, 1.0 };

        Vector x = new Vector(xdata);
        Vector y = new Vector(ydata);

        System.out.println("x        =  " + x);
        System.out.println("y        =  " + y);
        System.out.println("x + y    =  " + x.plus(y));
        System.out.println("10x      =  " + x.times(10.0));
        System.out.println("|x|      =  " + x.magnitude());
        System.out.println("<x, y>   =  " + x.dot(y));
        System.out.println("|x - y|  =  " + x.minus(y).magnitude());
    } // main( String [] )
} // Vector
