all: Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java MemPlayer.java UserPlayer.java
	javac Program.java Game.java Board.java Player.java RandomPlayer.java MinimaxPlayer.java ABPlayer.java MemPlayer.java UserPlayer.java

tests:
	java Program RANDOM RANDOM 100 RANDvRAND.txt
	java Program MINIMAX MINIMAX 100 MINIMAXvMINIMAX.txt
	java Program ALPHABETA ALPHABETA 100 ALPHABETAvALPHABETA.txt
	java Program MEM MEM 100 MEMvMEM.txt
	java Program ALPHABETA MINIMAX 100 ALPHABETAvMINIMAX.txt
	java Program MEM MINIMAX 100 MEMvMINIMAX.txt
	java Program RANDOM MINIMAX 100 RANDOMvMINIMAX.txt
	java Program RANDOM MEM 100 RANDOMvMEM.txt
	java Program RANDOM ALPHABETA 100 RANDOMvALPHABETA.txt

playO:
	java Program USER ALPHABETA 1 output.txt

playX:
	java Program ALPHABETA USER 1 output.txt

clean:
	rm *.class