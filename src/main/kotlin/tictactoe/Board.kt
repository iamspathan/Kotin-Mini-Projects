package tictactoe

class Board {
    val cells = arrayOf(
            Cell(),Cell(),Cell(),
            Cell(),Cell(),Cell(),
            Cell(),Cell(),Cell())

    override fun toString(): String =
            " " + cells[0].state.string + " | " + cells[1].state.string + " | " + cells[2].state.string + "\n" +
                    "-----------" + "\n" +
                    " " + cells[3].state.string + " | " + cells[4].state.string + " | " + cells[5].state.string + "\n" +
                    "-----------" + "\n" +
                    " " + cells[6].state.string + " | " + cells[7].state.string + " | " + cells[8].state.string + "\n"

    val tutorialBoard =
            " " + "1" + " | " + "2" + " | " + "3" + "\n" +
                    "-----------" + "\n" +
                    " " + "4" + " | " + "5" + " | " + "6" + "\n" +
                    "-----------" + "\n" +
                    " " + "7" + " | " + "8" + " | " + "9" + "\n"

    fun winState():CellState {

        //Vertical, Horizontal and Digonal
        if(             (cells[0].equals(cells[1]) && cells[0].equals(cells[2] )
                        ||cells[0].equals(cells[3]) && cells[0].equals(cells[6])
                        ||cells[0].equals(cells[4]) && cells[0].equals(cells[8])))
            return cells[0].state

        if(cells[1].equals(cells[4]) && cells[1].equals(cells[7]))
            return cells[1].state

        if(cells[2].equals(cells[4]) && cells[2].equals(cells[6])
                ||cells[2].equals(cells[5]) && cells[2].equals(cells[8]))
            return cells[2].state

        if (cells[3].equals(cells[4]) && cells[3].equals(cells[4]))
            return cells[3].state

        if (cells[6].equals(cells[7]) && cells[6].equals(cells[8]))
            return cells[6].state

        return CellState.EMPTY

    }

    fun isFull() : Boolean {
        for (cell in cells) if (cell.state.value==0) return false
        return true
    }


}