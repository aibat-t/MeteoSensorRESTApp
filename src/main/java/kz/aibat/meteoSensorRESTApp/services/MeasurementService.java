package kz.aibat.meteoSensorRESTApp.services;

import kz.aibat.meteoSensorRESTApp.dto.MeasurementDTO;
import kz.aibat.meteoSensorRESTApp.mapper.MeasurementMapper;
import kz.aibat.meteoSensorRESTApp.models.Measurement;
import kz.aibat.meteoSensorRESTApp.repositories.MeasurementRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MeasurementService {

    private final MeasurementRepository measurementRepository;
    private final MeasurementMapper measurementMapper;

    public Measurement addMeasurement(MeasurementDTO measurementDTO){
        Measurement measurement = measurementMapper.DTOToMeasurement(measurementDTO);
        return measurementRepository.save(measurement);
    }
}
