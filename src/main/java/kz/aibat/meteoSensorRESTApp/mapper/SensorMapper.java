package kz.aibat.meteoSensorRESTApp.mapper;

import kz.aibat.meteoSensorRESTApp.dto.SensorDTO;
import kz.aibat.meteoSensorRESTApp.models.Sensor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SensorMapper {

    Sensor DTOToSensor(SensorDTO sensorDTO);
    SensorDTO sensorToDTO(Sensor sensor);
}
