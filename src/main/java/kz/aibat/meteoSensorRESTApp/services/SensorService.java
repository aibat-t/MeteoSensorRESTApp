package kz.aibat.meteoSensorRESTApp.services;

import kz.aibat.meteoSensorRESTApp.dto.SensorDTO;
import kz.aibat.meteoSensorRESTApp.mapper.SensorMapper;
import kz.aibat.meteoSensorRESTApp.models.Sensor;
import kz.aibat.meteoSensorRESTApp.repositories.SensorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public void addSensor(SensorDTO sensorDTO){
        Sensor sensor = sensorMapper.DTOToSensor(sensorDTO);
        sensorRepository.save(sensor);
    }
}

