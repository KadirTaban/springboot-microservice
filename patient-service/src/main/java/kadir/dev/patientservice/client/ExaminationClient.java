package kadir.dev.patientservice.client;

import kadir.dev.patientservice.dto.ExaminationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(value = "examinationApiClient", url = "${examination.api.url}")
public interface ExaminationClient {

    @GetMapping("examinations/all")
    List<ExaminationDto> getAll();

}
