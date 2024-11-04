# Baekjoon Online Judge #4817 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/16.svg" height="20" align="center">
4817 괄호](https://www.acmicpc.net/problem/4817) 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/4817) /
[제출 보기](https://www.acmicpc.net/source/87367246)

## 힌트 및 풀이
```ebnf
Expression ::= Term ("+" Term)*
Term ::= Factor Factor*
Factor ::= Variable | "(" Expression ")"
```

```
a+b+c
ab+c
(a+b)c
abc

a+b+c
a+bc
a(b+c)
abc
```
