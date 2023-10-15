package kadir.dev.examinationservice.client;

import kadir.dev.examinationservice.model.dto.PatientDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "patientApiClient", url = "${patient.api.url}")
public interface PatientClient {

    @GetMapping
    PatientDto get(@RequestParam String tckNo);


}
