package kadir.dev.patientservice.dto.converter;

import kadir.dev.patientservice.dto.PatientDto;
import kadir.dev.patientservice.dto.SavePatientCreateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class PatientDtoConverter {
    public PatientDto convertToDto(SavePatientCreateRequest savePatientRequestDto){
        return PatientDto.builder()
                .id(savePatientRequestDto.getId())
                .name(savePatientRequestDto.getName())
                .surname(savePatientRequestDto.getSurname())
                .tckNo(savePatientRequestDto.getTckNo())
                .phoneNumber(savePatientRequestDto.getPhoneNumber())
                .build();
    }
}
