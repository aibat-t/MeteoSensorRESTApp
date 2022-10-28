package kz.aibat.meteoSensorRESTApp.util.exceptions;

public class SensorAlreadyExistsException extends RuntimeException{
    public SensorAlreadyExistsException(String msg){
        super(msg);
    }
}
