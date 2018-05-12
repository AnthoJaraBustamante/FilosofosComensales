package comensalesFilosofos;

public class Filosofo extends Thread {

	private int id;
	private Accion controlador;
	private int nComidas;

	public Filosofo(int id, Accion c) {
		this.id = id;
		controlador = c;
		nComidas = 0;
	}

	public void pensando() {
		System.out.println("Filosofo " + id + " pensando");
		try {
			Thread.sleep((int) (Math.random() * 400));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	public void comer() {
		nComidas++;
		System.out.println("Filosofo " + id + " come: " + nComidas + " veces");
		try {
			Thread.sleep((int) (Math.random() * 500));
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void run() {
		do {
			pensando();
			controlador.tomarTenedores(id);
			comer();
			controlador.soltarTenedores(id);
		} while (true);
	}
}
