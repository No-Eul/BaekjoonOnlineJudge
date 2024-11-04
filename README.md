# Baekjoon Online Judge #4831 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/0.svg" height="20" align="center">
4831 Resistors](https://www.acmicpc.net/problem/4831) 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/4831) /
[제출 보기](https://www.acmicpc.net/source/87195715)

## 풀이 및 힌트
```ebnf
Impedance ::= Parallel
Parallel ::= Serial ("|" Serial)*
Serial ::= Node ("&" Node)*
Node ::= Value | "(" Impedance ")"
Value ::= Digits "/" Digits
```
