package kadir.dev.examinationservice.controller;

import jakarta.validation.Valid;
import kadir.dev.examinationservice.model.dto.DoctorDto;
import kadir.dev.examinationservice.model.request.DoctorCreateRequest;
import kadir.dev.examinationservice.service.DoctorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public void createDoctor(@RequestBody @Valid DoctorCreateRequest doctorCreateRequest) {
        doctorService.create(doctorCreateRequest);
    }

    @GetMapping("/all")
    public List<DoctorDto> getAll(){
        return doctorService.getAll();
    }
}
