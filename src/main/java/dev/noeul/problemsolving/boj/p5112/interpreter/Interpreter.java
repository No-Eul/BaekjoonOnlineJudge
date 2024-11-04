package dev.noeul.problemsolving.boj.p5112.interpreter;

import dev.noeul.problemsolving.boj.p5112.parsing.Expression;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class Interpreter {
	private final Deque<Map<String, Integer>> variables = new LinkedList<>();
	private final Map<String, Function> functions = new HashMap<>();
	private final Map<Function, int[]> profileResults = new TreeMap<>();

	public Interpreter() {
		this.variables.add(new HashMap<>());
	}

	public int getVariable(String name) {
		for (Map<String, Integer> variables : this.variables) {
			if (variables.containsKey(name))
				return variables.get(name);
		}
		throw new EvaluationException(name + " is not defined variable");
	}

	public void putVariable(String name, int value) {
		Objects.requireNonNull(this.variables.peek()).put(name, value);
	}

	public int callFunction(String name, int argument) {
		Function function = this.functions.get(name);
		if (function == null)
			throw new EvaluationException(name + " is not defined function");
		this.profileResults.putIfAbsent(function, new int[function.size()]);
		return function.evaluate(this, argument);
	}

	public void defineFunction(String name, Function.Parameter parameter, Expression expression) {
		this.functions.computeIfAbsent(name, Function::new).define(parameter, expression);
	}

	public void printProfilingResult() {
		for (Function function : this.profileResults.keySet()) {
			System.out.printf("%s calls: ", function.name);
			int total = 0;
			for (int numbers : this.profileResults.get(function)) {
				System.out.printf("%d ", numbers);
				total += numbers;
			}
			System.out.printf("=> %d%n", total);
		}
		this.profileResults.clear();
	}

	public void increaseCalls(String functionName, int ordinal) {
		this.profileResults.get(this.functions.get(functionName))[ordinal]++;
	}

	public static void println(int value) {
		System.out.printf(">> %d%n", value);
	}

	public Map<String, Integer> increaseFrame() {
		Map<String, Integer> map = new HashMap<>();
		this.variables.push(map);
		return map;
	}

	public void decreaseFrame() {
		this.variables.pop();
	}
}
