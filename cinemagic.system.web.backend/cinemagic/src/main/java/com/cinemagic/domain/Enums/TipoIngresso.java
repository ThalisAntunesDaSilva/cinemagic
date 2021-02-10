package com.cinemagic.domain.Enums;

public enum TipoIngresso {
	INTEIRA(0,"Inteira"),MEIA(1,"Meia");
	private int cod;
	private String descricao;
	
	private TipoIngresso(int cod, String descricao) {
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
	public static TipoIngresso toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		for(TipoIngresso x: TipoIngresso.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido "+cod);
	}
	
}
