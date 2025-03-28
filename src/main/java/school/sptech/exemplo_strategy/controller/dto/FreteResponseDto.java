package school.sptech.exemplo_strategy.controller.dto;

import school.sptech.exemplo_strategy.entity.Frete;
import school.sptech.exemplo_strategy.entity.TipoFreteEnum;

public class FreteResponseDto {

    private Integer id;
    private TipoFreteEnum tipo;
    private Double valorFrete;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TipoFreteEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoFreteEnum tipo) {
        this.tipo = tipo;
    }

    public String descricao() {
        return tipo.getDescricao();
    }

    public Double getValorFrete() {
        return valorFrete;
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }

    // Metodo estático para converter entidade em DTO
    public static FreteResponseDto toResponse(Frete frete) {
        FreteResponseDto dto = new FreteResponseDto();
        dto.setId(frete.getId());
        dto.setTipo(frete.getTipo());
        dto.setValorFrete(frete.getValorFrete());
        return dto;
    }
}
