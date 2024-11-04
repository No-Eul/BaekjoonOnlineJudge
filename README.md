# Baekjoon Online Judge #9170 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/9.svg" height="20" align="center">
9170 Single Digit Adder](https://www.acmicpc.net/problem/9170) 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/9170) /
[제출 보기](https://www.acmicpc.net/source/87374156)

## 힌트 및 풀이
```ebnf
Expression ::= BinaryOperation
BinaryOperation ::= UnaryOperation (("+" | "-") UnaryOperation)*
UnaryOperation ::= ("+" | "-")? UnaryOperation | Operand
Operand ::= Number | "(" Expression ")"
Number ::= [0-9]
```
