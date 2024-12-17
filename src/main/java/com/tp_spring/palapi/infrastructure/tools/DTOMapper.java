package com.tp_spring.palapi.infrastructure.tools;

import java.util.ArrayList;

import com.tp_spring.palapi.application.dto.PalDTO;
import com.tp_spring.palapi.domain.Aura;
import com.tp_spring.palapi.domain.Maps;
import com.tp_spring.palapi.domain.Pal;
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
            pal.getSize(),
            pal.getSkills()
        );
    }

    public static Pal mapToEntity(PalDTO palDTO) {
        Pal pal = new Pal();
        pal.setName(palDTO.getName());
        pal.setTypes(palDTO.getTypes());
        pal.setRarity(palDTO.getRarity());
        pal.setPrice(palDTO.getPrice());
        pal.setSize(palDTO.getSize());
        pal.setSkills(palDTO.getSkills());

        pal.setDrops(new ArrayList<String>());
        pal.setSuitability(new ArrayList<Suitability>());
        pal.setStats(new Stats());
        pal.setAura(new Aura());
        pal.setWiki(null);
        pal.setImage(null);
        pal.setImageWiki(null);
        pal.setDescription(null);
        pal.setAsset(null);
        pal.setGenus(null);
        pal.setMaps(new Maps());

        return pal;
    }
}
