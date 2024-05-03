package meu.pacote.entities.enums;

public enum OrderStatus {

	AGUARDANDO_PAGAMENTO(1), //coloca um numero correspondende a cada ação
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(4);

	private int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	public static OrderStatus valueOf(int code) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getCode() == code) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}



