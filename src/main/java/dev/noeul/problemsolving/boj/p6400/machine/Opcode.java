package dev.noeul.problemsolving.boj.p6400.machine;

public enum Opcode {
	PUSH(Integer.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			machine.push(this.getArgument(operands, 0));
		}
	},
	GETVAR(Character.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			machine.push(machine.getVariable(this.getArgument(operands, 0)));
		}
	},
	PUTVAR(Character.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			machine.putVariable(this.getArgument(operands, 0), machine.peek());
		}
	},
	ADD {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value2 + value1);
		}
	},
	SUBTRACT {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value2 - value1);
		}
	},
	MULTIPLY {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value2 * value1);
		}
	},
	DIVIDE {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value2 / value1);
		}
	},
	NEG {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			machine.push(-machine.pop());
		}
	},
	PRINT {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			machine.printChanges();
		}
	};

	private final Class<?>[] operandTypes;

	Opcode(Class<?>... operandTypes) {
		this.operandTypes = operandTypes;
	}

	public abstract void execute(VirtualMachine machine, Object... operands);

	@SuppressWarnings("unchecked")
	public <T> T getArgument(Object[] args, int index) {
		if (!this.operandTypes[index].isInstance(args[index]))
			throw new VirtualMachineException("Operand type mismatch");
		return (T) args[index];
	}
}
