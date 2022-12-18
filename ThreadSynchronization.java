//~ A simple Java program to demonstrate thread synchronization using Movie ticket booking as an example 
class Movie extends Thread {
	int vacant = 1, required;
	Movie(int reqd) {
		required = reqd;
	}
	
	public synchronized void run() {
		if(vacant >= required) {
			System.out.println(required + " ticket(s) booked for " + Thread.currentThread().getName());
			try {
				Thread.sleep(1000);
			} catch (Exception e) {}
			vacant = vacant - required;

		} else {
			System.out.println("Housefull " + Thread.currentThread().getName());	
		}
	}
}

class ThreadSynchronization {
	public static void main(String args[]) {
		Movie m = new Movie(1);
		Thread t1 = new Thread(m);
		Thread t2 = new Thread(m);
		
		t1.setName("Sky");
		t2.setName("Valor");
		t1.start();
		t2.start();
		
	}
}