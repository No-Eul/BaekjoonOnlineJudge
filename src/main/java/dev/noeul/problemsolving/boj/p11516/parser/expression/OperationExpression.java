package dev.noeul.problemsolving.boj.p11516.parser.expression;

import dev.noeul.problemsolving.boj.p11516.lexer.PunctuationToken;
import dev.noeul.problemsolving.boj.p11516.machine.Instruction;
import dev.noeul.problemsolving.boj.p11516.machine.Opcode;
import dev.noeul.problemsolving.boj.p11516.parser.ExpressionNode;

import java.util.List;

public class OperationExpression implements ExpressionNode {
	private final Operator operator;
	private final ExpressionNode[] operands;

	public OperationExpression(Operator operator, ExpressionNode... operands) {
		this.operator = operator;
		this.operands = operands;
	}

	@Override
	public void generate(List<Instruction> instructions) {
		for (ExpressionNode operand : this.operands)
			operand.generate(instructions);
		instructions.add(new Instruction(this.operator.opcode));
	}

	public enum Operator {
		OR(PunctuationToken.BARBAR, Opcode.OR),
		AND(PunctuationToken.AMPAMP, Opcode.AND),
		EQUALITY(PunctuationToken.EQEQ, Opcode.EQ),
		INEQUALITY(PunctuationToken.BANGEQ, Opcode.NE),
		LESS_THAN(PunctuationToken.LT, Opcode.LT),
		LESS_THAN_OR_EQUAL(PunctuationToken.LTEQ, Opcode.LE),
		GREATER_THAN(PunctuationToken.GT, Opcode.GT),
		GREATER_THAN_OR_EQUAL(PunctuationToken.GTEQ, Opcode.GE),
		ADDITION(PunctuationToken.PLUS, Opcode.ADD),
		SUBTRACTION(PunctuationToken.MINUS, Opcode.SUB),
		MULTIPLICATION(PunctuationToken.ASTERISK, Opcode.MUL),
		DIVISION(PunctuationToken.SLASH, Opcode.DIV),
		REMAINDER(PunctuationToken.PERCENT, Opcode.REM),
		NEGATION(PunctuationToken.MINUS, Opcode.NEG),
		LOGICAL_NEGATION(PunctuationToken.BANG, Opcode.NOT);

		public final PunctuationToken token;
		public final Opcode opcode;

		Operator(PunctuationToken token, Opcode opcode) {
			this.token = token;
			this.opcode = opcode;
		}
	}
}
