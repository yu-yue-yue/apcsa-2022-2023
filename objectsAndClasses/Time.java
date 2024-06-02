package objectsAndClasses;

public class Time {
	private int hours, mins;
	
	public Time(int h, int m) {
		if (h > 24) {
			throw new IllegalArgumentException();
		}
		
		if (m >= 60) {
			throw new IllegalArgumentException();
		}
		
		hours = h;
		mins = m;
	}
	
	private int toMins() {
		return hours*60 + mins;
	}
	
	public boolean lessThan(Time t) {
		return t.toMins() > this.toMins();
	}
	
	public int elapsedSince(Time t) {
		return (1440 + this.toMins()) - t.toMins();
	}
	
	public String toString() {
		return ("Hours: " + hours + "\n" + "Mins: " + mins);
	}
	
}

