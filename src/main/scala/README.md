###People who might find these exercises interesting
* Should be somewhat familiar with Scala.
* Want to practice some functional programming.
* Are not very familiar with Scala Collections and would like to learn some useful functions

####Topics not covered in this project
* Monads
* Scala basics
* The different data types of the Scala Collections

###How to use this project
1. Clone the repo.
2. Choose an exercise which you want to solve. 
    Each object has a run function which is not implemented (marked by _???_).
    The signature of the run functions are of course different for each Exercise.
3. Implement the run function until it passes all tests.

Feel free to check out the corresponding tests as well.

Also if you find any errors let me know.

####Rules
* Don't use **var**'s, only **val**'s are allowed.
* Prefer expressions over statements.
* Don't use loops, use recursion or collections functions like map or fold.

###Useful methods on Scala collections
I think the following methods are definitely worth knowing about,
 because they can make the code easier to write and read.
 Most of these methods are defined on most of the collections data types, 
 however not all, because some operations only make sense for sequential data types.

_If you know all of these methods well enough, probably you won't benefit much from the exercises either._

* map
* filter
* collect
* fold
* reduce
* exists
* contains
* forall
* sliding
* max, min
* maxBy, minBy
* drop, take
* partition
* span
* takeWhile, dropWhile
* head, tail, headOption
* fill
* groupBy
* reverse
* zip
* zipWithIndex

For a more comprehensive list and some visual explanations:
 https://superruzafa.github.io/visual-scala-reference/index.html#product
 
#####Some methods could be composed from other methods:
* span(p)      == (takeWhile(p),  dropWhile(p)) // where p is a function returning a Boolean
* partition(p) == (filter(p), filterNot(p))
* splitAt(n)   == (take(n), drop(n)) // where n is an index
