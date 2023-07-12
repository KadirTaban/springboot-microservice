package kadir.dev.patientservice.dto;

import lombok.Data;

@Data
public class VerifyPhoneResponseDto {
    private String phone;
    private boolean phone_valid;

}
