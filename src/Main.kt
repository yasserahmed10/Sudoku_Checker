// checking Board that must be square
fun validSudoku(board: Array<Array<Char>>): Boolean {
    val n = board.size
    if(n == 0) return false
    for(row in board) { if (row.size != n) return false }

    // checking the subgrid size that must be square
    val boxSize = kotlin.math.sqrt(n.toDouble()).toInt()
    if(boxSize * boxSize != n) return false

    // Checking rows for duplicates
    for(i in 0 until n) {
        var rowSet = mutableSetOf<Char>()
        for(j in 0 until n) {
            val c = board[i][j]
            if(c != '-') {
                if(c in rowSet) return false
                rowSet.add(c)
            }
        }
    }

    // Checking columns for duplicates
    for(j in 0 until n) {
        var colSet = mutableSetOf<Char>()
        for(i in 0 until n) {
            val c = board[i][j]
            if(c != '-') {
                if(c in colSet) return false
                colSet.add(c)
            }
        }
    }

    // Check each subgrid (box)
    for(boxRow in 0 until boxSize) {
        for(boxCol in 0 until boxSize) {
            var boxSet = mutableSetOf<Char>()
            // Iterate inside each box
            for(i in 0 until boxSize) {
                for(j in 0 until boxSize) {
                    val r = boxRow * boxSize + i
                    val c = boxCol * boxSize + j
                    val ch = board[r][c]
                    if(ch != '-') {
                        if(ch in boxSet) return false
                        boxSet.add(ch)
                    }
                }
            }
        }
    }
    return true
}

fun main() {

    // 9x9 Valid Sudoku board
    val valid9 = arrayOf(
        arrayOf('5','3','-','-','7','-','-','-','-'),
        arrayOf('6','-','-','1','9','5','-','-','-'),
        arrayOf('-','9','8','-','-','-','-','6','-'),
        arrayOf('8','-','-','-','6','-','-','-','3'),
        arrayOf('4','-','-','8','-','3','-','-','1'),
        arrayOf('7','-','-','-','2','-','-','-','6'),
        arrayOf('-','6','-','-','-','-','2','8','-'),
        arrayOf('-','-','-','4','1','9','-','-','5'),
        arrayOf('-','-','-','-','8','-','-','7','9')
    )
    println("Test Valid 9x9: " + validSudoku(valid9))

    // 9x9 Invalid Sudoku board - duplicate in row
    val invalidRow9 = arrayOf(
        arrayOf('5','3','-','-','7','-','-','-','-'),
        arrayOf('6','-','-','1','9','5','-','-','-'),
        arrayOf('-','9','8','-','-','-','-','6','-'),
        arrayOf('8','-','-','-','6','-','-','-','3'),
        arrayOf('4','-','-','8','-','3','-','-','1'),
        arrayOf('7','-','-','-','2','-','-','-','6'),
        arrayOf('-','6','-','-','-','-','2','8','-'),
        arrayOf('-','-','-','4','1','9','-','-','5'),
        arrayOf('-','-','-','-','8','-','-','7','7')
    )
    println("Test Invalid Row 9x9: " + validSudoku(invalidRow9))

    // 9x9 Invalid Sudoku board - duplicate in column
    val invalidCol9 = arrayOf(
        arrayOf('5','3','-','-','7','-','-','-','-'),
        arrayOf('6','-','-','1','9','5','-','-','-'),
        arrayOf('-','9','8','-','-','-','-','6','-'),
        arrayOf('8','-','-','-','6','-','-','-','3'),
        arrayOf('4','-','-','8','-','3','-','-','1'),
        arrayOf('7','-','-','-','2','-','-','-','6'),
        arrayOf('-','6','-','-','-','-','2','8','-'),
        arrayOf('-','-','-','4','1','9','-','-','5'),
        arrayOf('5','-','-','-','8','-','-','7','9')
    )
    println("Test Invalid Column 9x9: " + validSudoku(invalidCol9))

    // 9x9 Invalid Sudoku board - duplicate in subgrid
    val invalidBox9 = arrayOf(
        arrayOf('5','3','5','-','7','-','-','-','-'),
        arrayOf('6','-','-','1','9','5','-','-','-'),
        arrayOf('-','9','8','-','-','-','-','6','-'),
        arrayOf('8','-','-','-','6','-','-','-','3'),
        arrayOf('4','-','-','8','-','3','-','-','1'),
        arrayOf('7','-','-','-','2','-','-','-','6'),
        arrayOf('-','6','-','-','-','-','2','8','-'),
        arrayOf('-','-','-','4','1','9','-','-','5'),
        arrayOf('-','-','-','-','8','-','-','7','9')
    )
    println("Test Invalid Box 9x9: " + validSudoku(invalidBox9))

        // 9x9 Invalid Sudoku board - contains invalid character
        val invalidChar9 = arrayOf(
            arrayOf('5','3','-','-','7','-','-','-','-'),
            arrayOf('6','-','-','1','9','5','-','-','-'),
            arrayOf('-','9','8','-','-','-','-','6','-'),
            arrayOf('8','-','-','-','6','-','-','-','3'),
            arrayOf('4','-','-','8','-','3','-','-','1'),
            arrayOf('7','-','-','-','2','-','-','-','6'),
            arrayOf('-','6','-','-','-','-','2','8','-'),
            arrayOf('-','-','-','4','1','9','-','-','5'),
            arrayOf('-','-','-','-','8','-','-','7','X')
        )
        println("Test Invalid Char 9x9: " + validSudoku(invalidChar9))

    // Non-square board (9x8)
    val nonSquareBoard = arrayOf(
        arrayOf('5','3','-','-','7','-','-','-','-'),
        arrayOf('6','-','-','1','9','5','-','-','-'),
        arrayOf('-','9','8','-','-','-','-','6','-'),
        arrayOf('8','-','-','-','6','-','-','-','3'),
        arrayOf('4','-','-','8','-','3','-','-','1'),
        arrayOf('7','-','-','-','2','-','-','-','6'),
        arrayOf('-','6','-','-','-','-','2','8','-'),
        arrayOf('-','-','-','4','1','9','-','-','5')
    )
    println("Test Non-Square Board: " + validSudoku(nonSquareBoard))

    // 9x9 Invalid Sudoku board - contains number greater than 9
    val invalidNumber9 = arrayOf(
        arrayOf('5','3','-','-','7','-','-','-','-'),
        arrayOf('6','-','-','1','9','5','-','-','-'),
        arrayOf('-','9','8','-','-','-','-','6','-'),
        arrayOf('8','-','-','-','6','-','-','-','3'),
        arrayOf('4','-','-','8','-','3','-','-','1'),
        arrayOf('7','-','-','-','2','-','-','-','6'),
        arrayOf('-','6','-','-','-','-','2','8','-'),
        arrayOf('-','-','-','4','1','9','-','-','5'),
        arrayOf('-','-','-','-','8','-','-','7', "10")
    )
    println("Test Invalid Number 9x9: " + validSudoku(invalidNumber9 as Array<Array<Char>>))

    val invalidNumberLessThan1 = arrayOf(
        arrayOf('5','3','-','-','7','-','-','-','-'),
        arrayOf('6','-','-','1','9','5','-','-','-'),
        arrayOf('-','9','8','-','-','-','-','6','-'),
        arrayOf('8','-','-','-','6','-','-','-','3'),
        arrayOf('4','-','-','8','-','3','-','-','1'),
        arrayOf('7','-','-','-','2','-','-','-','6'),
        arrayOf('-','6','-','-','-','-','2','8','-'),
        arrayOf('-','-','-','4','1','9','-','-','5'),
        arrayOf('-','-','-','-','8','-','-','7','0')
    )
    println("Test Invalid Number Less Than 1 9x9: " + validSudoku(invalidNumberLessThan1 as Array<Array<Char>>))

    // 4x4 Valid Sudoku board (extra dynamic test)
    val valid4 = arrayOf(
        arrayOf('1','-','-','4'),
        arrayOf('-','4','1','-'),
        arrayOf('-','1','4','-'),
        arrayOf('4','-','-','1')
    )
    println("Test Valid 4x4: " + validSudoku(valid4))

    // 4x4 Invalid Sudoku board - duplicate in subgrid
    val invalidBox4 = arrayOf(
        arrayOf('1','1','-','4'),
        arrayOf('-','4','1','-'),
        arrayOf('-','1','4','-'),
        arrayOf('4','-','-','1')
    )
    println("Test Invalid Box 4x4: " + validSudoku(invalidBox4))
}
