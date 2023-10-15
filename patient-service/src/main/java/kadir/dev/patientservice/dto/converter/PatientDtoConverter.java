package kadir.dev.patientservice.dto.converter;

import kadir.dev.patientservice.dto.PatientDto;
import kadir.dev.patientservice.dto.SavePatientCreateRequest;
import kadir.dev.patientservice.entity.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class PatientDtoConverter {
    public PatientDto convertToDto(SavePatientCreateRequest savePatientRequestDto){
        return PatientDto.builder()
                .name(savePatientRequestDto.getName())
                .surname(savePatientRequestDto.getSurname())
                .tckNo(savePatientRequestDto.getTckNo())
                .phoneNumber(savePatientRequestDto.getPhoneNumber())
                .build();
    }

    public PatientDto convertAsDto(Patient patient){
        return PatientDto.builder()
                .tckNo(patient.getTckNo())
                .surname(patient.getSurname())
                .phoneNumber(patient.getPhoneNumber())
                .name(patient.getName())
                .id(patient.getId())
                .build();
    }
}
