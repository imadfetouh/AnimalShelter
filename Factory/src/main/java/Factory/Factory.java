package Factory;

public class Factory {

    public static Object buildInstance(ICreateInstance iCreateInstance){
        return iCreateInstance.create();
    }

}
