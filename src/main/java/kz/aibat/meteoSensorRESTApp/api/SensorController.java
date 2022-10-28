package kz.aibat.meteoSensorRESTApp.api;

import kz.aibat.meteoSensorRESTApp.dto.SensorDTO;
import kz.aibat.meteoSensorRESTApp.services.SensorService;
import kz.aibat.meteoSensorRESTApp.util.exceptions.SensorAlreadyExistsException;
import kz.aibat.meteoSensorRESTApp.util.exceptions.SensorErrorResponse;
import kz.aibat.meteoSensorRESTApp.util.validators.SensorValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/sensors")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;
    private final SensorValidator sensorValidator;

    @PostMapping(value = "/registration")
    public ResponseEntity<String> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                               BindingResult bindingResult){
        sensorValidator.validate(sensorDTO, bindingResult);

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError f: errors){
                errorMsg.append(f.getField())
                        .append(" - ")
                        .append(f.getDefaultMessage())
                        .append(";");
            }
            throw new SensorAlreadyExistsException(errorMsg.toString());
        }
        sensorService.addSensor(sensorDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }



    @ExceptionHandler
    private ResponseEntity<SensorErrorResponse> handleException(SensorAlreadyExistsException e){
        SensorErrorResponse response = new SensorErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
