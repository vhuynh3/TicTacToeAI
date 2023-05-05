# TicTacToeAI

Compile using make


usage: ```java Program <RANDOM/MINIMAX/ALPHABETA/ITER/USER> <RANDOM/MINIMAX/ALPHABETA/ITER/USER> <# of Games> <output file>```
  
```<RANDOM/MINIMAX/ALPHABETA/ITER/USER>``` - specifies player types. Defaults to RANDOM if there is an issue.
  
```<# of Games>``` - Defaults to 100 if there is an issue with parsing
  
Run default test cases using: ```make tests```


## Playing Against AI

To play a game against one of the AI algorithms, compile and run ```java Program USER <AI selection> 1 <output file>```

Output file does not matter in this case, but is required for the program to run.

The starting player is randomized. 

To make a move, type any number 0-8. The board is as follows:

```
+-------+
| 0|1|2 |
| -+-+- |
| 3|4|5 |
| -+-+- |
| 6|7|8 |
+-------+
```

The command line will prompt you to make a move when it is your turn.
