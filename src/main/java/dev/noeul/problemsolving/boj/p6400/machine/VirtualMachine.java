package dev.noeul.problemsolving.boj.p6400.machine;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

public class VirtualMachine {
	private final List<Instruction> instructions;
	private final Stack<Integer> operandStack = new Stack<>();
	private final Map<Character, Integer> variables = new HashMap<>();
	private final Set<Character> changes = new TreeSet<>();
	private int instructionPointer = 0;

	public VirtualMachine(List<Instruction> instructions) {
		this.instructions = instructions;
	}

	public void execute() throws VirtualMachineException {
		while (this.instructionPointer < this.instructions.size())
			this.instructions.get(this.instructionPointer++).execute(this);
	}

	public void push(int value) {
		this.operandStack.push(value);
	}

	public int pop() {
		return this.operandStack.pop();
	}

	public int peek() {
		return this.operandStack.peek();
	}

	public int getVariable(Character name) {
		return this.variables.computeIfAbsent(name, k -> 0);
	}

	public void putVariable(Character name, int value) {
		Integer oldValue = this.variables.put(name, value);
		if (value != (oldValue == null ? 0 : oldValue))
			this.changes.add(name);
	}

	public void printChanges() {
		StringBuilder builder = new StringBuilder();
		Iterator<Character> iterator = this.changes.iterator();
		while (iterator.hasNext()) {
			Character key = iterator.next();
			iterator.remove();
			builder.append(key).append(" = ").append(this.getVariable(key));
			if (iterator.hasNext())
				builder.append(", ");
		}
		System.out.println(builder.length() > 0 ? builder : "No Change");
	}
}
