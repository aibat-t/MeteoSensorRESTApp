package kz.aibat.meteoSensorRESTApp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "measurement")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "value", precision = 7, scale = 2)
    @NotNull(message = "Value should not be empty")
    @DecimalMin(value = "-100", message = "Value should be greater than -100")
    @DecimalMax(value = "100", message = "Value should be less than 100")
    private BigDecimal value;

    @Column(name = "raining")
    @NotNull(message = "Is raining should not be empty")
    private boolean raining;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Sensor sensor;

    @Column(name = "dateTime")
    private LocalDateTime dateTime;

}
