package com.h_salvacao.ms_atendimento.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoRequest {

    private LocalDate dataInicio;
    private LocalDate dataFinal;
}
