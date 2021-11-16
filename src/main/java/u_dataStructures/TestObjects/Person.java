package u_dataStructures.TestObjects;

import u_dataStructures.Interfaces.Comparable;

public class Person implements Comparable {
    private String firstName;
    private String lastName;

    public Person(String firstName, String lastName){
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    // Retorna 1 si son iguales 
    // Retorna mayor a 1 si this. es mas grande
    // Retorna menor a 1 si other es mas grande
    
    public double compareTo(Object object){
        if(object != null && object instanceof Person){
            Person other = (Person) object;
            char this_firstChar = this.lastName.charAt(0);
            char other_firstChar = other.lastName.charAt(0);
            return (this_firstChar/other_firstChar);
        }else{
            throw new RuntimeException("Se intento comparar un objeto diferente de Person");
        }
    }

    @Override
    public String toString() {
        return this.lastName + " "+this.firstName;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result  = false;
        if(obj != null && obj instanceof Person){
            Person other = (Person) obj;
            if(this.getFirstName().equals(other.getFirstName()) && this.getLastName().equals(other.getLastName())){
                result = true;
            }
        }
        return result;
    }

    @Override
    public boolean hasNullAtributtes() {
        return this.lastName == null || this.firstName == null;
    }
}
