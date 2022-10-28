package kz.aibat.meteoSensorRESTApp.services;

import kz.aibat.meteoSensorRESTApp.dto.SensorDTO;
import kz.aibat.meteoSensorRESTApp.mapper.SensorMapper;
import kz.aibat.meteoSensorRESTApp.models.Sensor;
import kz.aibat.meteoSensorRESTApp.repositories.SensorRepository;
import kz.aibat.meteoSensorRESTApp.util.exceptions.SensorDoNotExist;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SensorService {

    private final SensorRepository sensorRepository;
    private final SensorMapper sensorMapper;

    public void addSensor(SensorDTO sensorDTO){
        Sensor sensor = sensorMapper.DTOToSensor(sensorDTO);
        sensorRepository.save(sensor);
    }

    public boolean checkSensorIfExits(SensorDTO sensorDTO){
        sensorRepository.findSensorByName(sensorDTO.getName());
        return sensorRepository.findSensorByName(sensorDTO.getName()).isPresent();
    }

    public Sensor findSensorByName(String name){
        Optional<Sensor> sensorOptional = sensorRepository.findSensorByName(name);
        return sensorOptional.orElseThrow(SensorDoNotExist::new);
    }
}

