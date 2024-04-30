//@Enumerated(EnumType.STRING)
AGUARDANDO_PAGAMENTO(1), //coloca um numero correspondende a cada ação
PAGO(2),
ENVIADO(3),
ENTREGUE(4),
CANCELADO(5);

	private final int code;

	private OrderStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}

	@SneakyThrows
	public static OrderStatus valueOff(int code) {
		for (OrderStatus value : OrderStatus.values()) { // passar por todas as constantes do enum
			if(value.getCode() == code) {//se o int code for igual a se valor, retorna
				return value;
			}
		}
		throw new IllegalArgumentException("Código de OrderStatus inválido: " + code);

	}
}