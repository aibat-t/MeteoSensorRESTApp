package kz.aibat.meteoSensorRESTApp.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MeasurementDTO {

    @NotNull(message = "Value should not be empty")
    @Size(min = -100, max = 100, message = "Value should be between -100 and 100")
    private Float value;

    @NotNull(message = "Is raining should not be empty")
    private boolean raining;

    @NotNull(message = "Sensor should not be empty")
    private SensorDTO sensor;
}
