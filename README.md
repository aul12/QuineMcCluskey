# Quine and McCluskey optimisation
Implementation of the algorithm of Quine and McCluskey
in Kotlin.

# Kotlin
## Installing the kotlin compiler
Follow this tutorial to install kotlin: [https://kotlinlang.org/docs/tutorials/command-line.html](https://kotlinlang.org/docs/tutorials/command-line.html) for your OS.
## Compilation
In the source directory run
```
kotlinc Main.kt MinTerm.kt
```
to compile the programm.

To execute the programm run:
```
kotlin MainKt
```


## Usage
This program takes the path to a truth table in csv
format and prints the minified term to the stdout.

The csv file needs to contain n+1 columns and 2^n rows, 
with the first n columns being the value of each 
variable and the n+1-th column being the corresponding
output of the function.

### Example
The following example is taken from the 
"Grundlagen der Rechnerarchitektur" worksheet:
```
0 0 0 0 0 0
0 0 0 0 1 1
0 0 0 1 0 1
0 0 0 1 1 0
0 0 1 0 0 1
0 0 1 0 1 0
0 0 1 1 0 0
0 0 1 1 1 1
0 1 0 0 0 0
0 1 0 0 1 1
0 1 0 1 0 1
0 1 0 1 1 0
0 1 1 0 0 1
0 1 1 0 1 0
0 1 1 1 0 0
0 1 1 1 1 1
1 0 0 0 0 0
1 0 0 0 1 1
1 0 0 1 0 1
1 0 0 1 1 0
1 0 1 0 0 1
1 0 1 0 1 0
1 0 1 1 0 0
1 0 1 1 1 1
1 1 0 0 0 0
1 1 0 0 1 1
1 1 0 1 0 1
1 1 0 1 1 0
1 1 1 0 0 1
1 1 1 0 1 0
1 1 1 1 0 0
1 1 1 1 1 1
```
