package dev.noeul.problemsolving.boj.p5112.parsing.expressions;

import dev.noeul.problemsolving.boj.p5112.interpreter.Interpreter;
import dev.noeul.problemsolving.boj.p5112.parsing.Expression;

public class ArithmeticOperationExpression implements Expression {
	private final Operator operator;
	private final Expression left, right;

	public ArithmeticOperationExpression(Operator operator, Expression left, Expression right) {
		this.operator = operator;
		this.left = left;
		this.right = right;
	}

	@Override
	public int evaluate(Interpreter interpreter) {
		return this.operator.evaluate(interpreter, this.left, this.right);
	}

	public enum Operator {
		ADDITION {
			@Override
			public int evaluate(Interpreter interpreter, Expression left, Expression right) {
				return left.evaluate(interpreter) + right.evaluate(interpreter);
			}
		},
		SUBTRACTION {
			@Override
			public int evaluate(Interpreter interpreter, Expression left, Expression right) {
				return left.evaluate(interpreter) - right.evaluate(interpreter);
			}
		},
		MULTIPLICATION {
			@Override
			public int evaluate(Interpreter interpreter, Expression left, Expression right) {
				return left.evaluate(interpreter) * right.evaluate(interpreter);
			}
		},
		DIVISION {
			@Override
			public int evaluate(Interpreter interpreter, Expression left, Expression right) {
				return left.evaluate(interpreter) / right.evaluate(interpreter);
			}
		},
		REMAINDER {
			@Override
			public int evaluate(Interpreter interpreter, Expression left, Expression right) {
				return left.evaluate(interpreter) % right.evaluate(interpreter);
			}
		};

		public abstract int evaluate(Interpreter interpreter, Expression left, Expression right);
	}
}
