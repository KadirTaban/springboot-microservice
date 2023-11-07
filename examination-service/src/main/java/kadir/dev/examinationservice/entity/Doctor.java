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
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Table(name="doctor")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Doctor {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private long id;
        private String firstName;
        private String lastName;
        private String branch;
        @CreationTimestamp
        private Date createdDate;

}
