package client;

public class Settings {
	
	private ResolutionEnum resolution;
	private ResolutionEnum defaultResolution = ResolutionEnum.Medium;	
	
	public ResolutionEnum getResolution() { return this.resolution; }
	
	public Settings() {
		this.resolution = defaultResolution;
	}
	
	
	
}
