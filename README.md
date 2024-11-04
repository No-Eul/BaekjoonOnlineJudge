# Baekjoon Online Judge #3203 in Java 8
Java 8로 작성한 [BOJ 3203번 문제](https://www.acmicpc.net/problem/3203) 초안 답안입니다.

본 답안은 **초안**으로, 정답으로 인정되지 않는 답안입니다.

```ebnf
Program ::= "BEGIN" Block

Block ::= (AssignmentStatement | RepeatStatement | PrintStatement)* BlockTermination

BlockTermination ::= "STOP"

AssignmentStatement ::= Variable "=" Expression

Variable ::= [a-z]

Expression ::= Term ([+-] Term)*

Term ::= ConstantLiteral Variable? | Variable

ConstantLiteral ::= [0-9]+

RepeatStatement ::= "REPEAT" ConstantLiteral Block

PrintStatement ::= "PRINT" Variable
```
