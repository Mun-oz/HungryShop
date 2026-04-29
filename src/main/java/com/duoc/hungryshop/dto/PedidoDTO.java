package com.duoc.hungryshop.dto;

import java.time.LocalDateTime;
import lombok.Data;
import java.util.List;

@Data
public class PedidoDTO {
    private Long id;
    private LocalDateTime fecha;
    private Double total;
    private Long clienteId; 
    private List<Long> productosIds;
}
