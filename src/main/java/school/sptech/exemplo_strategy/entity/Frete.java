package school.sptech.exemplo_strategy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import school.sptech.exemplo_strategy.controller.dto.FreteRequestDto;

@Entity
public class Frete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Double pesoEmKg;

    @Enumerated(EnumType.STRING)
    private TipoFreteEnum tipo;

    private Double valorEncomenda;
    private Double valorFrete;

    public Frete(){}

    public Frete(Integer id, Double pesoEmKg, TipoFreteEnum tipo, Double valorEncomenda, Double valorFrete) {
        this.id = id;
        this.pesoEmKg = pesoEmKg;
        this.tipo = tipo;
        this.valorEncomenda = valorEncomenda;
        this.valorFrete = valorFrete;
    }

    public Frete(Integer id , FreteRequestDto frete) {
        this.id = id;
        this.pesoEmKg = frete.getPesoEmKG();
        this.tipo = frete.getTipo();
        this.valorEncomenda = frete.getvalorEncomenda();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPesoEmKg() {
        return pesoEmKg;
    }

    public void setPesoEmKg(Double pesoEmKg) {
        this.pesoEmKg = pesoEmKg;
    }

    public TipoFreteEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoFreteEnum tipo) {
        this.tipo = tipo;
    }

    public Double getValorEncomenda() {
        return valorEncomenda;
    }

    public void setValorEncomenda(Double valorEncomenda) {
        this.valorEncomenda = valorEncomenda;
    }

    public Double getValorFrete() {
        switch (this.tipo) {
            case TipoFreteEnum.NORMAL:
                valorFrete = TipoFreteEnum.NORMAL.getValor() + this.pesoEmKg * 1.1;
                return valorFrete;
            case TipoFreteEnum.EXPRESSO:
                valorFrete = TipoFreteEnum.EXPRESSO.getValor() + this.pesoEmKg * 1.5;
                return valorFrete;
            case TipoFreteEnum.TRANSPORTADORA:
                valorFrete = TipoFreteEnum.TRANSPORTADORA.getValor() + this.pesoEmKg * 1.2;
                return valorFrete;
            default:
                return null;
        }
    }

    public void setValorFrete(Double valorFrete) {
        this.valorFrete = valorFrete;
    }
}
