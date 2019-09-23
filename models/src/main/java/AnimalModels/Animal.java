package AnimalModels;

import java.io.Serializable;
import java.util.UUID;

public abstract class Animal implements Serializable {

    private String serialVersionUID = "";
    private TypeAnimal typeAnimal;
    private String name;
    private Gender gender;
    private Reservor reservedBy;

    public Animal(String name, Gender gender, TypeAnimal typeAnimal){
        serialVersionUID = UUID.randomUUID().toString();
        this.name = name;
        this.gender = gender;
        this.typeAnimal = typeAnimal;
    }

    public String getSerialVersionUID(){
        return this.serialVersionUID;
    }

    public String getName(){
        return this.name;
    }

    public Gender getGender(){
        return this.gender;
    }

    public TypeAnimal getTypeAnimal(){
        return this.typeAnimal;
    }

    public void setReservedBy(Reservor reservedBy){
        this.reservedBy = reservedBy;
    }

    public Reservor getReservedBy(){
        return reservedBy;
    }

    public boolean checkReserved()
    {
        return this.reservedBy != null;
    }

    @Override
    public String toString() {
        String reserved = (this.reservedBy != null) ? "reserved by " + this.reservedBy.getName() : "not reserved";
        return this.name + "(" + this.gender + ") is " + reserved;
    }
}
