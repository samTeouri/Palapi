package com.tp_spring.palapi.infrastructure.tools;

import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.domain.Pal;

public class DTOMapper {

public static PalDTO mapToDTO(Pal pal) {
        if (pal == null) {
            return null;
        }

        return new PalDTO(
            pal.getId(),
            pal.getName(),
            pal.getTypes(),
            pal.getRarity(),
            pal.getPrice(),
            pal.getSize()
        );
    }
}
