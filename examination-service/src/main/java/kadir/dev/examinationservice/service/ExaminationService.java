package kadir.dev.examinationservice.service;

import jakarta.validation.Valid;
import kadir.dev.examinationservice.entity.Examination;
import kadir.dev.examinationservice.model.converter.DoctorConverter;
import kadir.dev.examinationservice.model.dto.ExaminationDto;
import kadir.dev.examinationservice.model.request.ExaminationCreateRequest;
import kadir.dev.examinationservice.repository.ExaminationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ExaminationService {

    private final ExaminationRepository examinationRepository;
    private final DoctorConverter doctorConverter;

    public void create(ExaminationCreateRequest examinationCreateRequest){
        examinationRepository.save(Examination.builder()
                        .description(examinationCreateRequest.getDescription())
                        .doctor(doctorConverter.convertAsEntity(examinationCreateRequest.getDoctor()))
                        .patientTckno(examinationCreateRequest.getPatient().getTckNo())
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
