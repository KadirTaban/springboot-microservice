package kadir.dev.examinationservice.model.converter;

import kadir.dev.examinationservice.entity.Doctor;
import kadir.dev.examinationservice.model.dto.DoctorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class DoctorConverter {

    public DoctorDto convertAsDto(Doctor doctor){
        return DoctorDto.builder()
                .id(doctor.getId())
                .firstName(doctor.getFirstName())
                .branch(doctor.getBranch())
                .lastName(doctor.getLastName())
                .build();
    }

    public Doctor convertAsEntity(DoctorDto dto){
        return Doctor.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .branch(dto.getBranch())
                .createdDate(dto.getCreatedDate())
                .build();
    }
}
