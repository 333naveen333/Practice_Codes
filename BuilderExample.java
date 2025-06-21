package Codes;

public class BuilderExample {

	private String name;
	private String id;
	private int number;
	
	
	@Override
	public String toString() {
		return "BuilderExample [name=" + name + ", id=" + id + ", number=" + number + "]";
	}
	public BuilderExample(Builder builder) {
		this.id=builder.id;
		this.name=builder.name;
		this.number=builder.number;
	}
	public static Builder getBuilder() {
        return new Builder();
    }
	public static class Builder{
		private String name;
		private String id;
		private int number;
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withId(String id) {
			this.id = id;
			return this;
		}
		public Builder withNumber(int num) {
			this.number = num;
			return this;
		}
		
		public BuilderExample build() {
			return new BuilderExample(this);
		}
		
		
	}
	public static void main(String[] args) {
		System.out.print(BuilderExample.getBuilder().withId("1").withNumber(3).build().toString());
	}
	
}
