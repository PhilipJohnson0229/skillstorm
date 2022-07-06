package collections;

public class Pokemon {
	private String name;
	private String type;
	int level;
	
	public Pokemon() 
	{
		super();
	}

	public Pokemon(String name, String type, int level) {
		super();
		this.name = name;
		this.type = type;
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	@Override
	public String toString() {
		return "name = " + name + ", type = " + type + ", level = " + level;
	}
	
	

}
