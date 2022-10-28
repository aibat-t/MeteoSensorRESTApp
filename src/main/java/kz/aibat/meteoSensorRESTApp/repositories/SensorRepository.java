package kz.aibat.meteoSensorRESTApp.repositories;

import kz.aibat.meteoSensorRESTApp.models.Sensor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SensorRepository extends JpaRepository<Sensor, Long> {
}
