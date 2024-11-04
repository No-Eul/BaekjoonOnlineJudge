package dev.noeul.problemsolving.boj.p3203.machine;

public enum Opcode {
	PUSH(Integer.class) {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) throws VirtualMachineException {
			machine.push(this.<Integer>getArgument(operands, 0));
		}
	},
	POP {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) {
			machine.pop();
		}
	},
	DUP {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) {
			machine.push(machine.peek());
		}
	},
	GETVAR(String.class) {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) throws VirtualMachineException {
			machine.push(machine.getVariable(this.getArgument(operands, 0)));
		}
	},
	PUTVAR(String.class) {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) throws VirtualMachineException {
			machine.putVariable(this.getArgument(operands, 0), machine.pop() % 10000);
		}
	},
	JUMP(Integer.class) {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) throws VirtualMachineException {
			machine.setInstructionPointer(this.<Integer>getArgument(operands, 0) - 1);
		}
	},
	IFGE(Integer.class) {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) throws VirtualMachineException {
			int value2 = machine.pop();
			int value1 = machine.pop();
			if (value1 >= value2)
				machine.setInstructionPointer(this.<Integer>getArgument(operands, 0) - 1);
		}
	},
	ADD {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) {
			int value2 = machine.pop();
			int value1 = machine.pop();
			machine.push(value1 + value2);
		}
	},
	SUBTRACT {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) {
			int value2 = machine.pop();
			int value1 = machine.pop();
			machine.push(value1 - value2);
		}
	},
	MULTIPLY {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) {
			int value2 = machine.pop();
			int value1 = machine.pop();
			machine.push(value1 * value2);
		}
	},
	PRINT(String.class) {
		@Override
		public void execute(VirtualMachine machine, Object[] operands) throws VirtualMachineException {
			String varName = this.getArgument(operands, 0);
			machine.println(String.format("%s = %s", varName, machine.getVariable(varName)));
		}
	};

	private final Class<?>[] operandType;

	Opcode(Class<?>... operandType) {
		this.operandType = operandType;
	}

	public abstract void execute(VirtualMachine machine, Object[] operands) throws VirtualMachineException;

	@SuppressWarnings("unchecked")
	public <T> T getArgument(Object[] args, int index) throws VirtualMachineException {
		if (!this.operandType[index].isInstance(args[index]))
			throw new VirtualMachineException("Operand type mismatch");
		return (T) args[index];
	}
}
