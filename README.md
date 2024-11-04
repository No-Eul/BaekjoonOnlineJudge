# Baekjoon Online Judge #2504 in Java 8
Java 8로 작성한 [<img src="https://static.solved.ac/tier_small/11.svg" height="20" align="center">
2504 괄호의 값](https://www.acmicpc.net/problem/2504) 답안입니다.

[문제 풀기](https://www.acmicpc.net/problem/2504) /
[제출 보기](https://www.acmicpc.net/source/87357636)

```ebnf
Brackets ::= CoupledBracket
CoupledBracket ::= Bracket Bracket*
Bracket ::= SingleBracket | NestedBracket
SingleBracket ::= "()" | "[]"
NestedBracket ::= "(" Brackets ")" | "[" Brackets "]"
```
