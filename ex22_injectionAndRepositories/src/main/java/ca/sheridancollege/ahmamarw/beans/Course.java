package ca.sheridancollege.ahmamarw.beans;

public class Course {

    private Long id;
    private String prefix;
    private int code;
    private String name;

    public Course() {
    }

    public Course(Long id, String prefix, int code, String name) {
        this.setId(id);
        this.setPrefix(prefix);
        this.setCode(code);
        this.setName(name);
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

    // Generate getters, setters, toString(), equals(), and hashCode()
}
