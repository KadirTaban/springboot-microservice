package kadir.dev.examinationservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="examinations")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    @ManyToOne
    private Doctor doctor;
    @CreationTimestamp
    private Date createdDate;




}
