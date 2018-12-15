# Quine and McCluskey optimisation
Implementation of the algorithm of Quine and McCluskey
in Kotlin.

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
