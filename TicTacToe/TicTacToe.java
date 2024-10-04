package game;

import java.util.Scanner;

public class TicTacToe {
	private static char[][] board;
	private static int fill =0;
	private static char player = 'O';
	
	private TicTacToe(){
		board = new char[3][3];
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				board[i][j] = '_';
			}
		}
	}
	
	private char getPlayer() {
		player = (player == 'O')? 'X' : 'O';
		return player;
	}
	private void printBoard() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	private boolean isBoardFull() {
		return fill == 9;
	}
	
	private char winsCheck() {
		char wins = '-';
		if(board[0][0] == board[0][1] && board[0][0] == board[0][2] && board[0][0] != '_') {
			wins = board[0][0];
		}
		if(board[1][0] == board[1][1] && board[1][0] == board[1][2] && board[1][0] != '_') {
			wins = board[1][0];
		}
		if(board[2][0] == board[2][1] && board[2][0] == board[2][2] && board[2][0] != '_') {
			wins = board[2][0];
		}
		if(board[0][0] == board[1][0] && board[0][0] == board[2][0] && board[0][0] != '_') {
			wins = board[0][0];
		}
		if(board[0][1] == board[1][1] && board[0][1] == board[2][1] && board[0][1] != '_') {
			wins = board[0][1];
		}
		if(board[0][2] == board[1][2] && board[0][2] == board[2][2] && board[0][2] != '_') {
			wins = board[0][2];
		}
		if(board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] != '_') {
			wins = board[0][0];
		}
		if(board[2][0] == board[1][1] && board[1][1] == board[0][2] && board[2][0] != '_') {
			wins = board[2][0];
		}
		return wins;
	}
	
	private boolean gameFinish() {
		char wins = winsCheck();
		
		if(wins!='-') {
			System.out.println("Congratulations, Player " + wins + " wins the game.");
			return true;
		}
		else if(isBoardFull()) {
			System.out.println("Game Over. It is a draw match.");
			return true;
		}
		return false;
	}
	
	private void ui() {
		Scanner sc = new Scanner(System.in);
		printBoard();
		char turn = getPlayer();
		while(!gameFinish()) {
			System.out.print("Player " + turn );
			
			int row = -1, col =-1;
			do { 
				System.out.println(", Enter your move (row and column):");
				row = sc.nextInt();
				col = sc.nextInt();
				
				if(row>2 || col>2 || row<0 || col<0 || board[row][col] != '_') {
					if( board[row][col] != '_' ) System.out.println("Selected cell is already occupied.");
					System.out.println("Enter valid position.");
					row=-1;
					col=-1;
				} 				
				
			} while(row==-1 && col==-1) ;
			board[row][col] = turn;
			fill++;
			turn = (turn=='O') ? 'X' : 'O';
			printBoard();
		}
		
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		game.ui();
	}
}
