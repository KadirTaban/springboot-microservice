package kadir.dev.examinationservice.model.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Getter
public class PatientDto {

    private String tckNo;

}