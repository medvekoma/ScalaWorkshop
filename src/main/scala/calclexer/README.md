# Integer Calculator Lexer

Write a lexer for a simple calculator which only knows integer numbers and the basic arithmetic operators (+, - , * , /) 
and is able to handle whitespaces.

##Lexer
A lexer is among the first stages of a compiler or an interpreter.
It converts a sequence of characters (the source code) to a sequence of tokens,
 which can be fed to the parser.
 
A lexer can also be referred to as tokenizer or scanner.

In our case we will have two kind of tokens Operator and Integer.
Operator can mark (+, - , * , /), Integer can mark any integer. 
 
The lexer doesn't check grammar rules, that is the responsibility of the parser which is not part of this task.
So the tokens can be in an invalid order (eg.: "+ + 2 **" )


##Description

**Input:** A list of characters representing the source code.
eg: "1 + 12 * 123". Considering we won't have any grammar,
any order of the valid characters should return the corresponding list of tokens, but keeping the order is important.

**Output:** A vector of tokens (you can find the Token type in the source file).
* Whitespaces have to be disregarded between operators and integers.
* Integers count as one integer, unless they are separated by any non-digit character. 
(This way we could implement a different notation like: * 2 4 2 == 16)
* Operators are just 1 character long

**Example:** "1 + 2" should be Vector(Integer(1), Operator('+'), Integer(2))

There are no tests for brackets, however it's quite easy to add them at this point.

## Notes
This exercise could be a first part of a simple interpreter.
If you are interested in finishing the complete interpreter for this lexer,
check out this [series of articles](https://ruslanspivak.com/lsbasi-part1/).

