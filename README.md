# Baekjoon Online Judge #16228 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/13.svg" height="20" align="center">
16228 GCC의 유산](https://www.acmicpc.net/problem/16228) 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/16228) /
[제출 보기](https://www.acmicpc.net/source/87265980)

## 힌트 및 풀이
```ebnf
Expression ::= AdditiveOperation
AdditiveOperation ::= MinMaxOperation (("+" | "-") MinMaxOperation)*
MinMaxOperation ::= Operand (("<?" | ">?") Operand)*
Operand ::= Number | "(" Expression ")"
Number ::= [0-9]+
```
