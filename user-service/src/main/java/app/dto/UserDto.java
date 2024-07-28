package app.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserDto(
        int id,

        @NotBlank String name,

        @NotBlank @Size(min = 8) String password,

        @Email String email,

        String subscription
) {
}
