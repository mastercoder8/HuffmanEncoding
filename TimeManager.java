import java.util.HashMap;

class TimeManager {
	private long startT;
	TimeManager(){
		startT = 0;
	}
	public double start(){
		startT = System.nanoTime();
		return startT;
	}
	private long duration(){
		return (System.nanoTime() - startT)/1000000;
	}
	private double durationS(){
		return duration()/1000;
	}
	public double now(){
//		System.out.println("Now: "+duration()+"ms");
		return duration();
	}
	public double nowS(){
		System.out.println("Now: "+durationS()+"s");
		return durationS();
	}
	public double end(){
		System.out.println("Duration: "+duration()+" ms");
		// Reset Start time
		startT = 0;
		return duration();
	}
	public void reset(){
		startT = 0;
		startT = System.nanoTime();
	}
	public double endS(){
		System.out.println("Duration: "+durationS()+" s");
		// Reset Start time
		startT = 0;
		return duration();
	}
}
