# Baekjoon Online Judge #11516 in Java 8
Java 8로 작성한 [BOJ 11516번 문제](https://www.acmicpc.net/problem/11516) 답안입니다.

```ebnf
Expression ::= OrOperand ("||" OrOperand)*
OrOperand ::= AndOperand ("&&" AndOperand)*
AndOperand ::= EqualityOperand (("==" | "!=") EqualityOperand)*
EqualityOperand ::= RelationalOperand (("<" | "<=" | ">" | ">=") RelationalOperand)*
RelationalOperand ::= AdditiveOperand (("+" | "-") AdditiveOperand)*
AdditiveOperand ::= MultiplicativeOperand (("*" | "/") MultiplicativeOperand)*
MultiplicativeAndUnaryOperand ::= ("-" | "!")? MultiplicativeAndUnaryOperand | Operand
Operand ::= Number | Variable | WrappedExpression
Number ::= [0-9]+
Variable ::= [a-z]
WrappedExpression ::= "(" Expression ")"

Program ::= Statements
Statements ::= Statement*
Statement ::= (IfStatement | WhileStatement | AssignmentStatement | PrintStatement) "\n"
IfStatement ::= "if" Expression "\n" Statements ("else" "\n" Statements)? "end" "if"
WhileStatement ::= "while" Expression "\n" Statements "end" "while"
AssignmentStatement ::= "set" Variable "=" Expression
PrintStatement ::= "print" Expression
```
