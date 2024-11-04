package dev.noeul.problemsolving.boj.p3203.machine;

import java.util.Arrays;

public class Instruction {
	private final Opcode opcode;
	private final Object[] arguments;

	public Instruction(Opcode opcode, Object... arguments) {
		this.opcode = opcode;
		this.arguments = arguments;
	}

	public void execute(VirtualMachine machine) throws VirtualMachineException {
		this.opcode.execute(machine, this.arguments);
	}

	@Override
	public String toString() {
		return this.opcode.name() + Arrays.toString(this.arguments);
	}
}
