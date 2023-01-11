package Ex2_2;

import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class AdapterCall<T> extends FutureTask<T> implements Comparable<AdapterCall<T>> {
    private int p; /** The priority of the task */

    /**
     * Constructor.
     * @param callable Callable<T>
     * @param p - int
     */
    public AdapterCall(Callable<T> callable , int p) {
        super(callable);
        this.p = p;
    }

    /**
     * Returns the priority
     * @return int
     */
    public int getP() {
        return p;
    }

    /**
     * This method set the priority
     * @param p - int
     */
    public void setP(int p) {
        this.p = p;
    }

    /**
     * Compares this object with the another object.
     * @param other - the object to be compared.
     * @return the value 0 if they are equals;
     * a value less than 0 if this "<" other;
     * and a value greater than 0 if this ">" other
     */
    @Override
    public int compareTo(AdapterCall<T> other) {
        return Integer.compare(this.p , other.p);
    }

    /**
     * This method indicates whether some other object is "equal to" this one.
     * @param other - the reference object with which to compare.
     * @return true if this object is the same as the other argument; false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        return super.equals(other);
    }

    /**
     * Generates a hash code for the object.
     * @return a hash value
     */
    @Override
    public int hashCode() {
        return Objects.hash(p);
    }

    /**
     * Returns a string representation of the object.
     * @return a string representation of the object.
     */
    @Override
    public String toString() {
        return "" + p ;
    }

}
