package client.old.game;

public class Settings {
	
	private ResolutionEnum resolution;
	private ResolutionEnum defaultResolution = ResolutionEnum.High;	
	
	public ResolutionEnum getResolution() { return this.resolution; }
	
	public Settings() {
		this.resolution = defaultResolution;
	}
	
	
	
}
