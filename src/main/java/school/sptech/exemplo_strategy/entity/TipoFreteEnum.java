package school.sptech.exemplo_strategy.entity;

public enum TipoFreteEnum {
    NORMAL("Entrega em até 12 dias úteis",10.0),
    EXPRESSO("Entrega em até 3 dias úteis",30.0),
    TRANSPORTADORA("Entrega em até 6 dias úteis",20.0);

    private final String descricao;
    private final double valor;

    TipoFreteEnum(String descricao , double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }
}
