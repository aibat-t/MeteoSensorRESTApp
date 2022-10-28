package kz.aibat.meteoSensorRESTApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "sensors")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sensor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotNull
    @Size(min = 3, max = 30, message = "Sensor's name should be between 3 and 30")
    private String name;
}
