package kz.aibat.meteoSensorRESTApp.api;

import kz.aibat.meteoSensorRESTApp.dto.SensorDTO;
import kz.aibat.meteoSensorRESTApp.services.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/sensor")
@RequiredArgsConstructor
public class SensorController {

    private final SensorService sensorService;

    @PostMapping(value = "/registration")
    public ResponseEntity<String> registration(@RequestBody @Valid SensorDTO sensorDTO,
                                               BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            //TODO add Exception handler and custom exceptions for each error
        }
        sensorService.addSensor(sensorDTO);
        return new ResponseEntity<>("success", HttpStatus.OK);
    }
}
