public class Code {
	public final Instruction instruction;
	public final String[] arguments;

	public Code(Instruction instruction, String... arguments) {
		this.instruction = instruction;
		this.arguments = arguments;
	}
}
