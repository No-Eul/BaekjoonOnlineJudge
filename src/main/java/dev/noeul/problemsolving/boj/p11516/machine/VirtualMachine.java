package dev.noeul.problemsolving.boj.p11516.machine;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class VirtualMachine {
	private final List<Instruction> instructions;
	private final PrintStream stdout;
	private final Map<String, Integer> variables = new HashMap<>();
	private final Stack<Integer> operandStack = new Stack<>();
	private int instructionPointer = 0;

	public VirtualMachine(List<Instruction> instructions, PrintStream stdout) {
		this.instructions = instructions;
		this.stdout = stdout;
	}

	public void execute() throws VirtualMachineException {
		for (; this.instructionPointer < this.instructions.size(); this.instructionPointer++)
			this.instructions.get(this.instructionPointer).execute(this);
	}

	public void push(int value) {
		this.operandStack.push(value);
	}

	public int pop() {
		return this.operandStack.pop();
	}

	public int getVariable(String name) {
		return this.variables.computeIfAbsent(name, k -> 0);
	}

	public void putVariable(String name, int value) {
		this.variables.put(name, value);
	}

	public void setInstructionPointer(int ptr) {
		this.instructionPointer = ptr - 1;
	}

	public void println(int value) {
		this.stdout.println(value);
	}
}
