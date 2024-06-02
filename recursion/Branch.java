package recursion;

public class Branch {
	private float baseX, baseY, length, angle, endX, endY;
	
	public Branch(float baseX, float baseY, float length, float angle) {
		this.baseX = baseX;
		this.baseY = baseY;
		this.length = length;
		this.angle = angle;
		endX = (float) (baseX + Math.cos(Math.toRadians(angle))*length);
		endY = (float) (baseY + Math.sin(Math.toRadians(angle))*length);
	}

	public float getBaseX() {
		return baseX;
	}

	public void setBaseX(float baseX) {
		this.baseX = baseX;
	}

	public float getBaseY() {
		return baseY;
	}

	public void setBaseY(float baseY) {
		this.baseY = baseY;
	}

	public float getLength() {
		return length;
	}

	public void setLength(float length) {
		this.length = length;
	}
	public float getEndX() {
		return endX;
	}
	
	public float getEndY() {
		return endY;
	}
	

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	
	
}
