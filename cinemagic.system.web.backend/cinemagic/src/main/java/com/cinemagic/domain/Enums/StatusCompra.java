package com.cinemagic.domain.Enums;

public enum StatusCompra {
	PAGO(0,"Pago"), CANCELADO(1,"Cancelado"), ESPERANDO_PAGAMENTO(2,"Esperando pagamento"), ANALISE(3,"Em análise");
	
	private int cod;
	private String descricao;
	
	private StatusCompra(int cod, String descricao) {
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
	
	public static StatusCompra toStatusCompra(Integer cod) {
		for(StatusCompra x : StatusCompra.values()) {
			if(cod.equals(x.getCod())) {
				return x;
			}
		}
		throw new IllegalArgumentException("Id inválido cod: "+cod);
	}
}
