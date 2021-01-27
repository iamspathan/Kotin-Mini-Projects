package tictactoe

enum class CellState(val string: String, val value:Int){
    EMPTY(" ",0),
    CIRCLE("O", 1),
    CROSS("X",2)
}

data class Cell(var state: CellState=CellState.EMPTY){
    fun equals(other:Cell):Boolean = this.state==other.state
}