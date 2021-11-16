package u_dataStructures.TestObjects;

import u_dataStructures.Interfaces.Comparable;

public class Planet implements Comparable{
    private String name;
    private double radius;
    public Planet(String name, double radius){
        this.name = name;
        this.radius = radius;
    }

    public String getName() {
        return name;
    }
    public double getRadius() {
        return radius;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Planet:[ "+this.name + " - "+this.radius + "]";
    }
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if(obj != null && obj instanceof Planet){
            Planet other = (Planet) obj;
            if(this.name.equals(other.name) && this.radius == other.radius ){
                result = true;
            }
        }
        return result;
    }

    @Override
    public double compareTo(Object object) {
        if(object != null && object instanceof Planet){
            Planet other = (Planet) object;
            return this.radius / other.radius;
        }else{
            throw new RuntimeException("Se intento comparar con nulo o con un objeto diferente a Planet");
        }
    }
    @Override
    public boolean hasNullAtributtes() {
        return this.name == null || this.radius == 0;
    }
}
