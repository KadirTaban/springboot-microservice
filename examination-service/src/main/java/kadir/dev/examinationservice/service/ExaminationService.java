package kadir.dev.examinationservice.service;

import kadir.dev.examinationservice.client.PatientClient;
import kadir.dev.examinationservice.entity.Examination;
import kadir.dev.examinationservice.model.converter.DoctorConverter;
import kadir.dev.examinationservice.model.dto.ExaminationDto;
import kadir.dev.examinationservice.model.dto.PatientDto;
import kadir.dev.examinationservice.model.request.ExaminationCreateRequest;
import kadir.dev.examinationservice.repository.ExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExaminationService {

    private final ExaminationRepository examinationRepository;
    private final DoctorConverter doctorConverter;
    private final PatientClient patientClient;

    public void create(ExaminationCreateRequest examinationCreateRequest){

        final PatientDto patientDto = patientClient.get(examinationCreateRequest.getPatientTckno());
        if (StringUtils.isNotEmpty(patientDto.getTckNo())){
            return;
        }
        examinationRepository.save(Examination.builder()
                        .description(examinationCreateRequest.getDescription())
                        .doctorId(examinationCreateRequest.getDoctorId())
                        .patientTckno(examinationCreateRequest.getPatientTckno())
                        .build());
    }

    public List<ExaminationDto> getAll() {
        final List<Examination> examinationList = examinationRepository.findAll();
        return examinationList.stream().map(examination -> ExaminationDto.builder()
                        .id(examination.getId())
                        .description(examination.getDescription())
                        .doctor(doctorConverter.convertAsDto(examination.getDoctor()))
                        .createdDate(examination.getCreatedDate())
                        .build())
                .collect(Collectors.toList());
    }
}
