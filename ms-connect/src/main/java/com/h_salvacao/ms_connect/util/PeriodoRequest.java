package com.h_salvacao.ms_connect.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PeriodoRequest {

    private LocalDate dataInicio;
    private LocalDate dataFinal;
}
