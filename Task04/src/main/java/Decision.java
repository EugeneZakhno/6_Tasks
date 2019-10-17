package port;

public class Decision implements Runnable {
	Thread thrd;
	static int current = 0;

	Port port = new Port();
	static int docksIs = 1;

	// Construct a new thread.
	Decision(String name) {
		thrd = new Thread(this, name);
	}

	// A factory method that creates and starts a thread.
	public static Decision createAndStart(String name) {
		Decision myThrd = new Decision(name);
		myThrd.thrd.start(); // start the thread
		return myThrd;
	}

	// Entry point of thread.
	@SuppressWarnings("static-access")
	synchronized public void run() {

		System.out.println(thrd.getName() + " плывет к порту.");
		try {
			for (int count = 0; count < 10; count++) {
				Ship ship = new Ship();

				while ((this.docksIs >= this.port.docks || current >= this.port.capacityPort)) {
					System.out.println(thrd.getName() + " вошел в порт и ожидает очередь  ");
					if (ship.bool) {
						System.out.print("Трюм полон" + "\n");
					} else {
						System.out.print("Трюм пуст" + "\n");
					}
					Thread.sleep(40 + (int) (Math.random() * ((40 - 20) + 1)));
				}

				Thread.sleep(20 + (int) (Math.random() * ((40 - 20) + 1)));

				if (this.docksIs < (this.port.docks) && current < Port.capacityPort && ship.bool) {
					System.out.println(
							thrd.getName() + " вошел в порт и стал на разгрузку у причала " + "№" + (this.docksIs));

					int doks = this.docksIs;
					this.docksIs++;
					current += ship.capacity;

					Thread.sleep(20 + (int) (Math.random() * ((40 - 20) + 1)));
					System.out.println(thrd.getName() + " закончил разгрузку" + " у причала №" + (doks) + "\nВ порту "
							+ current + " контейнеров ");
					Thread.sleep(20 + (int) (Math.random() * ((40 - 20) + 1)));
					System.out.println(thrd.getName() + " вышел из порта");
					this.docksIs--;
				}

				while ((this.docksIs >= this.port.docks || current >= this.port.capacityPort)) {
					System.out.println(thrd.getName() + " вошел в порт и ожидает очередь ");

					if (ship.bool) {
						System.out.print("Трюм полон" + "\n");
					} else {
						System.out.print("Трюм пуст" + "\n");
					}
					Thread.sleep(40 + (int) (Math.random() * ((40 - 20) + 1)));
				}
				if (this.docksIs < port.docks && current > 10 && ship.capacity == 0) {
					System.out.println(
							thrd.getName() + " вошел в порт и стал на погрузку у причала" + " №" + (this.docksIs));

					int dooks = this.docksIs;
					this.docksIs++;
					current -= 10;
					Thread.sleep(20 + (int) (Math.random() * ((40 - 20) + 1)));

					System.out.println(thrd.getName() + " закончил погрузку" + " №" + (dooks) + "\nВ порту " + current
							+ " контейнеров ");

					Thread.sleep(20 + (int) (Math.random() * ((40 - 20) + 1)));

					System.out.println(thrd.getName() + " вышел из порта");
					this.docksIs--;
				}
			}
		} catch (InterruptedException exc) {
			System.out.println(thrd.getName() + " ошибка запуска.");
		}
	}
}