class thread implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		try {
			Thread.sleep(1500);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("State of thread1 while it called join() method" + Test.thread1.getState());

		try {
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
}

public class Test implements Runnable {
	public static Thread thread1;
	public static Test obj;

	public static void main(String[] args) {
		obj = new Test();
		thread1 = new Thread(obj);

		System.out.println("State of thread1 after creating it - " + thread1.getState());
		thread1.start();

		System.out.println("State of thread after calling .start() method on it - " + thread1.getState());

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		thread myThread = new thread();
		Thread thread2 = new Thread(myThread);

		System.out.println("State of thread2 after creating it - " + thread2.getState());
		thread2.start();

		System.out.println("State of thread2 after calling .start() metod on it - " + thread2.getState());

		try {
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		System.out.println("State of thread2 after calling .sleep() method on it - " + thread2.getState());

		try {
			thread2.join();
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		System.out.println("State of thread2 when it has finished it's execution - " + thread2.getState());

	}
}
