package kadir.dev.patientservice.controller;

import kadir.dev.patientservice.dto.ExaminationDto;
import kadir.dev.patientservice.dto.PatientDto;
import kadir.dev.patientservice.dto.SavePatientCreateRequest;
import kadir.dev.patientservice.entity.Patient;
import kadir.dev.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/generate")
    public Patient generatePatient(@RequestBody SavePatientCreateRequest savePatientRequestDto){
        return patientService.createPatient(savePatientRequestDto);
    }

    @GetMapping("/all-examinations")
    public List<ExaminationDto> getAllExaminations(){
        return patientService.getAllExamination();
    }

    @GetMapping
    public PatientDto get(@RequestParam String tckNo)  {
        return patientService.getExamination(tckNo);
    }

}
