# Baekjoon Online Judge #5112 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/21.svg" height="20" align="center">
5112 Functional Programming Counts](https://www.acmicpc.net/problem/5112) 초안 답안입니다.

본 답안은 **초안**으로, 정답으로 인정되지 않는 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/5112) /
~~[제출 보기](https://www.acmicpc.net/source/00000000)~~

## 힌트 및 풀이
```ebnf
Program ::= EOL* Statement* EOF
Statement ::= (FunctionDeclaration | VariableDeclaration | Profiling | ProgramEnd | Expression) (EOL | EOF)
FunctionDeclaration ::= "def" Identifier "(" Parameter ")" "=" Expression
Parameter ::= Number | Identifier
VariableDeclaration ::= "set" Identifier "=" Expression
Profiling ::= "profile"
ProgramEnd ::= "exit"

Expression ::= AdditiveOperation
AdditiveOperation ::= MultiplicativeOperation (("+" | "-") MultiplicativeOperation)*
MultiplicativeOperation ::= Operand (("*" | "/" | "%") Operand)*
Operand ::= Number | FunctionCall | Identifier | WrappedExpression
Number ::= [0-9]+
Identifier ::= [A-Za-z]+
WrappedExpression ::= "(" Expression ")"
FunctionCall ::= Identifier WrappedExpression
```
