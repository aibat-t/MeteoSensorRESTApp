package kz.aibat.meteoSensorRESTApp.dto;

import lombok.Data;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class MeasurementDTO {

    @NotNull(message = "Value should not be empty")
    @DecimalMin(value = "-100", message = "Value should be greater than -100")
    @DecimalMax(value = "100", message = "Value should be less than 100")
    private BigDecimal value;

    @NotNull(message = "Is raining should not be empty")
    private boolean raining;

    @NotNull(message = "Sensor should not be empty")
    private SensorDTO sensor;
}
