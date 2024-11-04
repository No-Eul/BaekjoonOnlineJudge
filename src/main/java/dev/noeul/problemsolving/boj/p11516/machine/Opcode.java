package dev.noeul.problemsolving.boj.p11516.machine;

public enum Opcode {
	PUSH(Integer.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) throws VirtualMachineException {
			machine.push(this.getArgument(operands, 0));
		}
	},
	GETVAR(String.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) throws VirtualMachineException {
			machine.push(machine.getVariable(this.getArgument(operands, 0)));
		}
	},
	PUTVAR(String.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) throws VirtualMachineException {
			machine.putVariable(this.getArgument(operands, 0), machine.pop());
		}
	},
	JUMP(Integer.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) throws VirtualMachineException {
			machine.setInstructionPointer(this.getArgument(operands, 0));
		}
	},
	IFEQ(Integer.class) {
		@Override
		public void execute(VirtualMachine machine, Object... operands) throws VirtualMachineException {
			if (machine.pop() == 0)
				machine.setInstructionPointer(this.getArgument(operands, 0));
		}
	},
	AND {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 != 0 && value2 != 0) ? 1 : 0);
		}
	},
	OR {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 != 0 || value2 != 0) ? 1 : 0);
		}
	},
	NOT {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			machine.push((machine.pop() == 0) ? 1 : 0);
		}
	},
	EQ {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 == value2) ? 1 : 0);
		}
	},
	NE {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 != value2) ? 1 : 0);
		}
	},
	LT {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 < value2) ? 1 : 0);
		}
	},
	LE {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 <= value2) ? 1 : 0);
		}
	},
	GT {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 > value2) ? 1 : 0);
		}
	},
	GE {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push((value1 >= value2) ? 1 : 0);
		}
	},
	ADD {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value1 + value2);
		}
	},
	SUB {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value1 - value2);
		}
	},
	MUL {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value1 * value2);
		}
	},
	DIV {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value1 / value2);
		}
	},
	REM {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
			int value2 = machine.pop(), value1 = machine.pop();
			machine.push(value1 % value2);
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
			machine.println(machine.pop());
		}
	},
	END {
		@Override
		public void execute(VirtualMachine machine, Object... operands) {
		}
	};

	private final Class<?>[] operandTypes;

	Opcode(Class<?>... operandTypes) {
		this.operandTypes = operandTypes;
	}

	public abstract void execute(VirtualMachine machine, Object... operands) throws VirtualMachineException;

	@SuppressWarnings("unchecked")
	public <T> T getArgument(Object[] args, int index) throws VirtualMachineException {
		if (!this.operandTypes[index].isInstance(args[index]))
			throw new VirtualMachineException("Operand type mismatch");
		return (T) args[index];
	}
}
