package kz.aibat.meteoSensorRESTApp.api;

import kz.aibat.meteoSensorRESTApp.dto.MeasurementDTO;
import kz.aibat.meteoSensorRESTApp.models.Measurement;
import kz.aibat.meteoSensorRESTApp.services.MeasurementService;
import kz.aibat.meteoSensorRESTApp.services.SensorService;
import kz.aibat.meteoSensorRESTApp.util.exceptions.MeasurementErrorResponse;
import kz.aibat.meteoSensorRESTApp.util.exceptions.MeasurementSensorNotExist;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/measurements")
@RequiredArgsConstructor
public class MeasurementController {

    private final MeasurementService measurementService;
    private final SensorService sensorService;

    @PostMapping(value = "/add")
    public ResponseEntity<String> add(@RequestBody @Valid MeasurementDTO measurementDTO,
                                     BindingResult bindingResult){
        if(!sensorService.checkSensorIfExits(measurementDTO.getSensor())){
            bindingResult.rejectValue("sensor", "sensor with this name do not exist");
        }

        if(bindingResult.hasErrors()){
            StringBuilder errorMsg = new StringBuilder();

            List<FieldError> errors = bindingResult.getFieldErrors();
            for(FieldError f: errors){
                errorMsg.append(f.getField())
                        .append(" - ")
                        .append(f.getDefaultMessage() != null ? f.getDefaultMessage() : f.getRejectedValue())
                        .append(";");
            }
            throw new MeasurementSensorNotExist(errorMsg.toString());
        }
        measurementService.addMeasurement(measurementDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<MeasurementDTO>> getAllMeasurements(){
        return new ResponseEntity<>(measurementService.findAllMeasurements(), HttpStatus.OK);
    }

    @GetMapping(value = "rainyDaysCount")
    public ResponseEntity<Long> getRainyDaysCount(){
        return new ResponseEntity<>(measurementService.getRainyDaysCount(), HttpStatus.OK);
    }

    @ExceptionHandler
    private ResponseEntity<MeasurementErrorResponse> handleException(MeasurementSensorNotExist e){
        MeasurementErrorResponse response = new MeasurementErrorResponse(
                e.getMessage(),
                System.currentTimeMillis()
        );
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
