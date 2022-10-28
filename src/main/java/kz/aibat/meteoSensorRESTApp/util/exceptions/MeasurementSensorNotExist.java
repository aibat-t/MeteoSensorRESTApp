package kz.aibat.meteoSensorRESTApp.util.exceptions;

public class MeasurementSensorNotExist extends RuntimeException{
    public MeasurementSensorNotExist(String msg){
        super(msg);
    }
}
