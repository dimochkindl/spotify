package app.dto;

import jakarta.validation.constraints.*;

public record SubscriptionDto (
        int id,

        @NotBlank @Size(max = 30) String name,


        @PositiveOrZero float price,


        @NotBlank String description

){
}
