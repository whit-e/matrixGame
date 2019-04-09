package client;

public enum ResolutionEnum {
	
	Ultra(2560, 1440), High(1920, 1080), Medium(1280, 1024), Low(1024, 768);
	
	private int height;
	private int width;
	
	private ResolutionEnum(int width, int height) {
		this.height = height;
		this.width = width;
	}
	
	public int getHeight() { return this.height; }
	public int getWidth() { return this.width; }
}
