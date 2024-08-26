package br.com.wsp.xlocation.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record PointOfInterestRecord(Long id, @NotNull @NotEmpty String name, @NotNull @NotEmpty Long x,
                                    @NotNull @NotEmpty Long y) {
}
