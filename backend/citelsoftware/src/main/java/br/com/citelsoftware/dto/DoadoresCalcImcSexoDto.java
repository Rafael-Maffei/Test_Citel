package br.com.citelsoftware.dto;

import br.com.citelsoftware.entities.SexoEnum;

public interface DoadoresCalcImcSexoDto {
    SexoEnum getSexo();
    int getPeso();
    Double getAltura();
}
