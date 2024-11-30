package com.tp_spring.palapi.infrastructure.tools;

import java.util.ArrayList;

import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.domain.Pal;
import com.tp_spring.palapi.domain.Skill;
import com.tp_spring.palapi.domain.Stats;
import com.tp_spring.palapi.domain.Suitability;

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

    public static Pal mapToEntity(PalDTO palDTO) {
        Pal pal = new Pal();
        pal.setName(palDTO.getName());
        pal.setTypes(palDTO.getTypes());
        pal.setRarity(palDTO.getRarity());
        pal.setPrice(palDTO.getPrice());
        pal.setSize(palDTO.getSize());

        pal.setDrops(new ArrayList<String>());
        pal.setSkills(new ArrayList<Skill>());
        pal.setSuitability(new ArrayList<Suitability>());
        pal.setStats(new Stats());
        pal.setWiki(null);
        return pal;
    }
}
