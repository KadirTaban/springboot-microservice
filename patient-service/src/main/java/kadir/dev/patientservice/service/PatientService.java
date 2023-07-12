package kadir.dev.patientservice.service;

import jakarta.transaction.Transactional;
import kadir.dev.patientservice.dto.PatientDto;
import kadir.dev.patientservice.dto.SavePatientRequestDto;
import kadir.dev.patientservice.dto.VerifyPhoneResponseDto;
import kadir.dev.patientservice.dto.converter.PatientDtoConverter;
import kadir.dev.patientservice.entity.Patient;
import kadir.dev.patientservice.exception.UserException;
import kadir.dev.patientservice.repository.PatientRepository;
import kadir.dev.patientservice.restcall.openfeign.RapidFeignCaller;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    @Value("${rapid-key}")
    private String rapidKey;

    private final RapidFeignCaller rapidFeignCaller;
    private final PatientRepository patientRepository;
    private final PatientDtoConverter converter;

    public Patient savePatient(SavePatientRequestDto savePatientRequestDto) {

        PatientDto patientDto = converter.convertToDto(savePatientRequestDto);
        if (!validatePhoneNumber(savePatientRequestDto.getPhoneNumber())) {
            throw new UserException("Invalid Number !");
        }
            return patientRepository.save(Patient.builder()
                .name(patientDto.getName())
                .surname(patientDto.getSurname())
                .tckNo(patientDto.getTckNo())
                .phoneNumber(patientDto.getPhoneNumber())
                .build());
    }

    private boolean validatePhoneNumber(String phoneNumber) {
        VerifyPhoneResponseDto verifyPhoneResponseDto = rapidFeignCaller.verifyPhoneNumber("veriphone.p.rapidapi.com",  rapidKey,phoneNumber);
        return verifyPhoneResponseDto.isPhone_valid();
    }
}
