package kadir.dev.examinationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="examination")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    @Column(name = "doctor_id")
    private long doctorId;
    @Column(name = "patient_tckno")
    private String patientTckno;
    @CreationTimestamp
    private Date createdDate;

    @ManyToOne
    @JoinColumn(name = "doctor_id", insertable = false, updatable = false ,nullable = false, foreignKey = @ForeignKey(name = "FK__examination__doctor"))
    private Doctor doctor;



}
