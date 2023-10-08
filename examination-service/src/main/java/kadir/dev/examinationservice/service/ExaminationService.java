package kadir.dev.examinationservice.service;

import jakarta.validation.Valid;
import kadir.dev.examinationservice.entity.Examination;
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

    public void create(@RequestBody @Valid ExaminationCreateRequest examinationCreateRequest){
        examinationRepository.save(Examination.builder()
                        .description(examinationCreateRequest.getDescription())
                        .doctor(examinationCreateRequest.getDoctor())
                        .build());
    }

    public List<ExaminationDto> getAll() {
        final List<Examination> examinationList = examinationRepository.findAll();
        return examinationList.stream().map(examination -> ExaminationDto.builder()
                        .id(examination.getId())
                        .description(examination.getDescription())
                        .doctor(examination.getDoctor())
                        .createdDate(examination.getCreatedDate())
                        .build())
                .collect(Collectors.toList());
    }
}
