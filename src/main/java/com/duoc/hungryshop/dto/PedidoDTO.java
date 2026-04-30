package com.duoc.hungryshop.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PedidoDTO {
    
    private Long id;
    private LocalDateTime fecha;
    private Double total;
    private Long clienteId; 
    private List<Long> productosIds;
}
