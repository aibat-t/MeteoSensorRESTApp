package kz.aibat.meteoSensorRESTApp.repositories;

import kz.aibat.meteoSensorRESTApp.models.Measurement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<Measurement, Long> {

    Long countAllByRainingIsTrue();
}
