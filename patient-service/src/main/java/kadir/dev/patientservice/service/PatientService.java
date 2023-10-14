package kadir.dev.patientservice.service;

import kadir.dev.patientservice.client.ExaminationClient;
import kadir.dev.patientservice.dto.ExaminationDto;
import kadir.dev.patientservice.dto.PatientDto;
import kadir.dev.patientservice.dto.SavePatientCreateRequest;
import kadir.dev.patientservice.dto.converter.PatientDtoConverter;
import kadir.dev.patientservice.entity.Patient;
import kadir.dev.patientservice.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;
    private final PatientDtoConverter converter;
    private final ExaminationClient examinationClient;

    public Patient createPatient(SavePatientCreateRequest savePatientRequestDto) {

        PatientDto patientDto = converter.convertToDto(savePatientRequestDto);
            return patientRepository.save(Patient.builder()
                .name(patientDto.getName())
                .surname(patientDto.getSurname())
                .tckNo(patientDto.getTckNo())
                .phoneNumber(patientDto.getPhoneNumber())
                .build());
    }


    public List<ExaminationDto> getAllExamination(){
        return examinationClient.getAll();
    }
}
