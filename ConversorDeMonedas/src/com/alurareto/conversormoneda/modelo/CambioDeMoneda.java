package com.alurareto.conversormoneda.modelo;

public record CambioDeMoneda( String base_code,    //Codigo de la moneda base.
                              String target_code,                           //Codigo de la moneda de destino.
                              double conversion_rate,                    //Tasa de cambio.
                              double conversion_result) {               //Resultado de la conversion.) {
}
