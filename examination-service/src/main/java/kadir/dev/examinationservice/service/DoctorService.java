package kadir.dev.examinationservice.service;

import kadir.dev.examinationservice.entity.Doctor;
import kadir.dev.examinationservice.model.dto.DoctorDto;
import kadir.dev.examinationservice.model.request.DoctorCreateRequest;
import kadir.dev.examinationservice.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public void create(@RequestBody DoctorCreateRequest doctorCreateRequest){
        doctorRepository.save(Doctor.builder()
                .firstName(doctorCreateRequest.getFirstName())
                .lastName(doctorCreateRequest.getLastName())
                .build());
    }

    public List<DoctorDto> getAll() {
        final List<Doctor> doctorList = doctorRepository.findAll();
        return doctorList.stream().map(doctor -> DoctorDto.builder()
                        .firstName(doctor.getFirstName())
                        .lastName(doctor.getLastName())
                        .branch(doctor.getBranch())
                        .build())
                .collect(Collectors.toList());
    }
}
