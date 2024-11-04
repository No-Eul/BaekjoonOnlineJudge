# Baekjoon Online Judge #3473 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/18.svg" height="20" align="center">
3473 Complicated Expressions](https://www.acmicpc.net/problem/3473) 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/3473) /
[제출 보기](https://www.acmicpc.net/source/87238155)

## 힌트 및 풀이
```ebnf
Expression ::= AdditiveOperation
AdditiveOperation ::= MultiplicativeOperation (("+" | "-") MultiplicativeOperation)*
MultiplicativeOperation ::= Operand (("*" | "/") Operand)*
Operand ::= Alphabet | "(" Expression ")"
```

```
a+b+c
a-b+c
a*b+c
a/b+c
a+b-c
a-b-c
a*b-c
a/b-c
(a+b)*c
(a-b)*c
a*b*c
a/b*c
(a+b)/c
(a-b)/c
a*b/c
a/b/c
a+b+c
a+b-c
a+b*c
a+b/c
a-(b+c)
a-(b-c)
a-b*c
a-b/c
a*(b+c)
a*(b-c)
a*b*c
a*b/c
a/(b+c)
a/(b-c)
a/(b*c)
a/(b/c)
```
