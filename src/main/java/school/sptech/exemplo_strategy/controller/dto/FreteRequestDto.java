package school.sptech.exemplo_strategy.controller.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;

public class FreteRequestDto {
//    {
//            "tipo": "NORMAL",
//            "valorEncomenda": 100.00,
//            "pesoEmKg": 2.0
//    }

    @NotNull
    private TipoFreteEnum tipo;
    @Min(10)
    private Double valorEncomenda;
    @Min(1)
    private Double pesoEmKG;

    public FreteRequestDto() {

    }

    public FreteRequestDto(TipoFreteEnum tipo, Double valorEncomenda, Double pesoEmKG) {
        this.tipo = tipo;
        this.valorEncomenda = valorEncomenda;
        this.pesoEmKG = pesoEmKG;
    }

    public TipoFreteEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoFreteEnum tipo) {
        this.tipo = tipo;
    }

    public Double getvalorEncomenda() {
        return valorEncomenda;
    }

    public void setvalorEncomenda(Double valorEncomenda) {
        this.valorEncomenda = valorEncomenda;
    }

    public Double getPesoEmKG() {
        return pesoEmKG;
    }

    public void setPesoEmKG(Double pesoEmKG) {
        this.pesoEmKG = pesoEmKG;
    }

    // Metodo para converter DTO em entidade
    static public Frete toEntity(FreteRequestDto freteRequestDto) {
        return new Frete(2,freteRequestDto);
    }

}
