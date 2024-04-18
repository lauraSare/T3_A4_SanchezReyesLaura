public class ThreadStateDemo {
	public static void main(String[] args) {
		// Crear un nuevo hilo
		Thread thread = new Thread();

		// Comprobar el estado del hilo (debería ser NEW)
		System.out.println(thread.getState());

		// Iniciar el hilo
		thread.start();

		// Comprobar el estado del hilo (debería ser RUNNABLE)
		System.out.println(thread.getState());

		// Hacer que el hilo espere
		synchronized(thread) {
			try {
				thread.wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Comprobar el estado del hilo (debería ser WAITING)
		System.out.println(thread.getState());

		// Notificar al hilo
		synchronized(thread) {
			thread.notify();
		}

		// Comprobar el estado del hilo (debería ser TERMINATED)
		System.out.println(thread.getState());
	}
}
