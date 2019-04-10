package client.game;

public class Settings {
	
	private ResolutionEnum resolution;
	private ResolutionEnum defaultResolution = ResolutionEnum.Low;	
	
	public ResolutionEnum getResolution() { return this.resolution; }
	
	public Settings() {
		this.resolution = defaultResolution;
	}
	
	
	
}
