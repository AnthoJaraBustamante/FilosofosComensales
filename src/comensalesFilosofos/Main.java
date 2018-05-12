package comensalesFilosofos;

public class Main {

	public static void main(String[] args) {
		Accion c = new Accion(3); 
		Filosofo f[] = new Filosofo[3];

		for (int cont = 0; cont < 3; cont++) {
			f[cont] = new Filosofo(cont, c);
			f[cont].start();
		}

		try {
			Thread.sleep((int) (8000));
		} catch (InterruptedException ex1) {
			System.out.println(ex1);
		}
		System.exit(0);
	}
}
