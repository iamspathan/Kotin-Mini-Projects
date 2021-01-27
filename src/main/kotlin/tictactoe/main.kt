package tictactoe

import java.util.*

fun main() {

    val scanner = Scanner(System.`in`)
    val random = Random()
    val board = Board()
    var inputCell = -1
    var computerCell = -1
    println(board.tutorialBoard)

    // logic code

    while (true){
        print("Which cell no. do you want to mark ?  ")
        inputCell = scanner.nextInt() - 1
        while (board.cells[inputCell].state != CellState.EMPTY) {
            print("Cell ${inputCell + 1} has already been choosen. Pick pick a new cell")
            inputCell = scanner.nextInt() - 1
        }

        board.cells[inputCell].state == CellState.CROSS
        if (board.isFull() || !(board.winState()==CellState.EMPTY)) break
        computerCell = inputCell

        while ((board.cells[computerCell].state != CellState.EMPTY))computerCell = random.nextInt(9)
        board.cells[computerCell].state= CellState.CIRCLE

        if (board.isFull() || !(board.winState()==CellState.EMPTY)) break
        println(board)
    }

    println(board)
    println(when (board.winState()){
        CellState.EMPTY -> "This game wads draw"
        CellState.CIRCLE -> "You have lost the Game"
        CellState.CROSS -> "You have Won the Game"
    })


}