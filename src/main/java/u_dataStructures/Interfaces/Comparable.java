package u_dataStructures.Interfaces;

public interface Comparable {
    /**
     * Method to compare two objects.
     * @param object the other object to compare
     * @return 1 if both are equal, higher to 1 if this. is bigger and lower to 1 if other is bigger
     */
    double compareTo(Object object);
    boolean hasNullAtributtes();
}
