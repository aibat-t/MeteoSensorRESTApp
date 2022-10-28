package kz.aibat.meteoSensorRESTApp.util.validators;

import kz.aibat.meteoSensorRESTApp.dto.SensorDTO;
import kz.aibat.meteoSensorRESTApp.models.Sensor;
import kz.aibat.meteoSensorRESTApp.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class SensorValidator implements Validator {

    private final SensorRepository sensorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Sensor.class.equals(clazz) || SensorDTO.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SensorDTO sensorDTO = (SensorDTO) target;
        if(sensorRepository.findSensorByName(sensorDTO.getName()).isPresent()){
            errors.rejectValue("name", "", "This sensor name is already taken");
        }
    }
}
