package app.spotify.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.boot.context.properties.bind.DefaultValue;

public record UserDto(
        int id,

        @NotBlank
        @Size(min = 5, max = 30, message = "Nickname should be from 5 to 30 symbols length") String nickname,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Invalid email format") String email
) {
}
