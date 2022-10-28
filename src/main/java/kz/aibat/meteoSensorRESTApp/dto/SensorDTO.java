package kz.aibat.meteoSensorRESTApp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class SensorDTO {

    @NotNull
    @Size(min = 3, max = 30, message = "Sensor's name should be between 3 and 30")
    private String name;
}
