package dev.noeul.problemsolving.boj.p6400.parser;

import dev.noeul.problemsolving.boj.p6400.lexer.PunctuationToken;
import dev.noeul.problemsolving.boj.p6400.machine.Instruction;
import dev.noeul.problemsolving.boj.p6400.machine.Opcode;

import java.util.List;

public class BinaryOperation implements Expression {
	private final Operator operator;
	private final Expression left, right;

	public BinaryOperation(Operator operator, Expression left, Expression right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		this.right.generate(instructions);
		this.left.generate(instructions);
		instructions.add(new Instruction(this.operator.opcode));
	}

	public enum Operator {
		ADDITION(PunctuationToken.PLUS, Opcode.ADD),
		SUBTRACTION(PunctuationToken.MINUS, Opcode.SUBTRACT),
		MULTIPLICATION(PunctuationToken.ASTERISK, Opcode.MULTIPLY),
		DIVISION(PunctuationToken.SLASH, Opcode.DIVIDE);

		public final PunctuationToken token;
		private final Opcode opcode;

		Operator(PunctuationToken token, Opcode opcode) {
			this.token = token;
			this.opcode = opcode;
		}
	}
}
