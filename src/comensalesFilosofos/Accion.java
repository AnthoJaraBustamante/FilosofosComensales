package comensalesFilosofos;

public class Accion {

	private static final int piensa = 0;
	private static final int come = 2;
	private static final int hambre = 1;

	private int n;
	private int estado[];

	public Accion(int n) {
		this.n = n;
		estado = new int[n];
	}

	public synchronized void tomarTenedores(int id) {

		estado[id] = hambre;
		prueba(id);

		while (estado[id] != come)
		{
			try {
				wait();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	public synchronized void soltarTenedores(int id) {
		int der, izq;
		der = (id + 1) % n;
		izq = id - 1;
		if (izq < 0) {
			izq = n - 1;
		}

		estado[id] = piensa;
		prueba(izq);
		prueba(der);
	}

	public void prueba(int id) {
		int der, izq;
		der = (id + 1) % n;
		izq = id - 1;
		if (izq < 0) {
			izq = n - 1;
		}
		if (estado[id] == hambre && estado[izq] != come && estado[der] != come) {
			estado[id] = come;
			notifyAll();
		}
	}
}
