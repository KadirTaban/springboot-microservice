package kadir.dev.examinationservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}