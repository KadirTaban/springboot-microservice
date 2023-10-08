package kadir.dev.examinationservice.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import kadir.dev.examinationservice.entity.Doctor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ExaminationCreateRequest {

    @NotBlank
    private String description;
    @NotNull
    private Doctor doctor;

}
