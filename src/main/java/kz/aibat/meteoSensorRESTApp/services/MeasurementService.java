package kz.aibat.meteoSensorRESTApp.services;

import kz.aibat.meteoSensorRESTApp.dto.MeasurementDTO;
import kz.aibat.meteoSensorRESTApp.mapper.MeasurementMapper;
import kz.aibat.meteoSensorRESTApp.models.Measurement;
import kz.aibat.meteoSensorRESTApp.repositories.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;
    private final SensorService sensorService;

    public void addMeasurement(MeasurementDTO measurementDTO){

        Measurement measurement = measurementMapper.DTOToMeasurement(measurementDTO);
        measurement.setSensor(sensorService.findSensorByName(measurementDTO.getSensor().getName()));
        enrichMeasurement(measurement);
        measurementRepository.save(measurement);
    }

    public List<MeasurementDTO> findAllMeasurements(){
        List<MeasurementDTO> measurementDTOList = measurementMapper
                .measurementListToDTOList(measurementRepository.findAll());
        return measurementDTOList;
    }

    public Long getRainyDaysCount(){
        return measurementRepository.countAllByRainingIsTrue();
    }

    public void enrichMeasurement(Measurement measurement){

        measurement.setDateTime(LocalDateTime.now());
    }
}
