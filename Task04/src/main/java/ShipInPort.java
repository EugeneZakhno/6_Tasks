package port;

/* Корабли заходят в порт для разгрузки/загрузки контейнеров. Число контейнеров,
 * находящихся в текущий момент в порту и на корабле, должно быть неотрицательным
 * и превышающим заданную грузоподъемность судна и вместимость порта. В порту
 * работает несколько причалов. У одного причала может стоять один корабль.
 * Корабль может загружаться у причала или разгружаться.
 * */

public class ShipInPort {
	private static Decision mt1;
	private static Decision mt2;
	private static Decision mt4;
	private static Decision mt5;
	private static Decision mt3;

	public static void main(String args[]) {
		System.out.println("Старт");
		setMt1(Decision.createAndStart("Корабль 1"));
		setMt2(Decision.createAndStart("Корабль 2"));
		setMt3(Decision.createAndStart("Корабль 3"));
		setMt4(Decision.createAndStart("Корабль 4"));
		setMt5(Decision.createAndStart("Корабль 5"));

		for (int i = 0; i < 50; i++) {
			try {
				Thread.sleep(10);
			} catch (InterruptedException exc) {
				System.out.println("Main thread interrupted.");
			}
		}
	}

	public static Decision getMt1() {
		return mt1;
	}

	public static void setMt1(Decision mt1) {
		ShipInPort.mt1 = mt1;
	}

	public static Decision getMt2() {
		return mt2;
	}

	public static void setMt2(Decision mt2) {
		ShipInPort.mt2 = mt2;
	}

	public static Decision getMt4() {
		return mt4;
	}

	public static void setMt4(Decision mt4) {
		ShipInPort.mt4 = mt4;
	}

	public static Decision getMt5() {
		return mt5;
	}

	public static void setMt5(Decision mt5) {
		ShipInPort.mt5 = mt5;
	}

	public static Decision getMt3() {
		return mt3;
	}

	public static void setMt3(Decision mt3) {
		ShipInPort.mt3 = mt3;
	}
}