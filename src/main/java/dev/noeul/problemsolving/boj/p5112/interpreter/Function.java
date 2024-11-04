package dev.noeul.problemsolving.boj.p5112.interpreter;

import dev.noeul.problemsolving.boj.p5112.parsing.Expression;

import java.util.ArrayList;
import java.util.List;

public class Function implements Comparable<Function> {
	public final String name;
	private final List<PartialDefinedFunction> subFunctions = new ArrayList<>();

	public Function(String name) {
		this.name = name;
	}

	public void define(Parameter parameter, Expression expression) {
		this.subFunctions.add(new PartialDefinedFunction(
				this, this.subFunctions.size(),
				parameter, expression
		));
	}

	public int evaluate(Interpreter interpreter, int argument) {
		for (PartialDefinedFunction function : this.subFunctions) {
			if (function.parameter.value != null) {
				if (function.parameter.value == argument)
					return function.evaluate(interpreter);
			} else {
				try {
					interpreter.increaseFrame().put(function.parameter.name, argument);
					return function.evaluate(interpreter);
				} finally {
					interpreter.decreaseFrame();
				}
			}
		}
		throw new EvaluationException("Rest case is not defined");
	}

	public int size() {
		return this.subFunctions.size();
	}

	@Override
	public int compareTo(Function other) {
		return this.name.compareTo(other.name);
	}

	public static class PartialDefinedFunction {
		private final Function function;
		private final int ordinal;
		private final Parameter parameter;
		private final Expression expression;

		public PartialDefinedFunction(
				Function function, int ordinal,
				Parameter parameter, Expression expression
		) {
			this.function = function;
			this.ordinal = ordinal;
			this.parameter = parameter;
			this.expression = expression;
		}

		public int evaluate(Interpreter interpreter) {
			interpreter.increaseCalls(this.function.name, this.ordinal);
			return this.expression.evaluate(interpreter);
		}
	}

	public static class Parameter {
		private final String name;
		private final Integer value;

		public Parameter(String name) {
			this.name = name;
			this.value = null;
		}

		public Parameter(int value) {
			this.name = null;
			this.value = value;
		}
	}
}
