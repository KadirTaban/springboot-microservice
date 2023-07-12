package kadir.dev.patientservice.controller;

import kadir.dev.patientservice.dto.SavePatientRequestDto;
import kadir.dev.patientservice.entity.Patient;
import kadir.dev.patientservice.service.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/patient")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/generate")
    public Patient generatePatient(@RequestBody SavePatientRequestDto savePatientRequestDto){
        return patientService.savePatient(savePatientRequestDto);

    }


}
