# Baekjoon Online Judge #16133 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/19.svg" height="20" align="center">
16133 공학용 계산기 (Calculator)](https://www.acmicpc.net/problem/16133) 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/16133) /
[제출 보기](https://www.acmicpc.net/source/87278167)

## 힌트 및 풀이
```ebnf
Expression ::= AdditiveOperation
AdditiveOperation ::= MultiplicativeOperation (("+" | "-") MultiplicativeOperation)*
MultiplicativeOperation ::= PowerOperation (("*" | "/") PowerOperation)*
PowerOperation ::= RootOperation ("^" RootOperation)*
RootOperation ::= "#"? RootOperation | Operand
Operand ::= Number | "(" Expression ")"
Number ::= [0-9]+
```
