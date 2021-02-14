package com.cinemagic.domain.Enums;

public enum TipoPagamento {
	CARTAO(0,"Cartão"), PONTOS(1,"Pontos");
	
	private int cod;
	private String descricao;
	
	private TipoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public static TipoPagamento toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoPagamento x : TipoPagamento.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido Cod: "+cod);
		
		
	}
	
}
