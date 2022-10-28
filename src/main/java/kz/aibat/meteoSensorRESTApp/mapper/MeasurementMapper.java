package kz.aibat.meteoSensorRESTApp.mapper;

import kz.aibat.meteoSensorRESTApp.dto.MeasurementDTO;
import kz.aibat.meteoSensorRESTApp.models.Measurement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MeasurementMapper {

    Measurement DTOToMeasurement(MeasurementDTO measurementDTO);
    MeasurementDTO measurementToDTO(Measurement measurement);
    List<MeasurementDTO> measurementListToDTOList(List<Measurement> measurementList);
}
