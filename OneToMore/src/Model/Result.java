package Model;

public class Result extends Command{
	private Command command;
	private String state;
	
	public Result(Command command, String state) {
		super();
		this.command = command;
		this.state = state;
	}
	public Command getCommand() {
		return command;
	}
	public void setCommand(Command command) {
		this.command = command;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
}