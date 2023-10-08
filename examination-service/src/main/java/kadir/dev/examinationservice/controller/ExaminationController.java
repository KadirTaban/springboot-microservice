package kadir.dev.examinationservice.controller;

import jakarta.validation.Valid;
import kadir.dev.examinationservice.model.dto.DoctorDto;
import kadir.dev.examinationservice.model.dto.ExaminationDto;
import kadir.dev.examinationservice.model.request.DoctorCreateRequest;
import kadir.dev.examinationservice.model.request.ExaminationCreateRequest;
import kadir.dev.examinationservice.service.DoctorService;
import kadir.dev.examinationservice.service.ExaminationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/examinations")
@RequiredArgsConstructor
public class ExaminationController {

    private final ExaminationService examinationService;
    @PostMapping
    public void create(@RequestBody @Valid ExaminationCreateRequest examinationCreateRequest) {
        examinationService.create(examinationCreateRequest);
    }

    @GetMapping("/all")
    public List<ExaminationDto> getAll(){
        return examinationService.getAll();
    }

}
