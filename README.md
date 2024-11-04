# Baekjoon Online Judge #6400 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/19.svg" height="20" align="center">
6400 Calculator Language](https://www.acmicpc.net/problem/6400) 초안 답안입니다.

본 답안은 **초안**으로, 정답으로 인정되지 않는 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/6400) /
~~[제출 보기](https://www.acmicpc.net/source/00000000)~~

## 힌트 및 풀이
```ebnf
Program ::= (EOL* Statement)* EOF
Statement ::= AssignmentStatement (EOL | EOF)
AssignmentStatement ::= Variable "=" Expression

Expression ::= AssignmentExpression
AssignmentExpression ::= (Variable "=")? BinaryOperation
BinaryOperation ::= NegationOperation ([+-*/] BinaryOperation)*
NegationOperation ::= "_"? NegationOperation | Operand
Operand ::= Number | Variable | "(" Expression ")"
Number ::= [0-9]+
Variable ::= [A-Z]
```
