# Sudoku_Checker

This project is a Sudoku_Checker implemented in Kotlin. It checks if a given Sudoku board is valid based on the standard Sudoku rules.

## Features

- Validates if the Sudoku board is square.
- Checks if the subgrid size is valid.
- Ensures there are no duplicate numbers in rows, columns, and subgrids.
- Handles various invalid inputs such as non-square boards, invalid characters, and numbers outside the valid range (1-9).

## Requirements

- Kotlin 1.5 or higher
- IntelliJ IDEA 2024.3.3 or any other compatible IDE

## Usage

1. Clone the repository:
    ```sh
    git clone https://github.com/yasserahmed10/Sudoku_Checker.git
    cd Sudoku_Checker
    ```

2. Open the project in IntelliJ IDEA.

3. Run the `main` function in `src/Main.kt` to execute the test cases.

## Test Cases

The `main` function includes several test cases to validate different scenarios:

- **Valid Sudoku board**
- **Invalid Sudoku board with duplicate in row**
- **Invalid Sudoku board with duplicate in column**
- **Invalid Sudoku board with duplicate in subgrid**
- **Invalid Sudoku board with invalid character**
- **Non-square board**
- **Invalid Sudoku board with number greater than 9**
- **Invalid Sudoku board with number less than 1**
- **Valid 4x4 Sudoku board**
- **Invalid 4x4 Sudoku board with duplicate in subgrid**

## Example

Here is an example of a valid 9x9 Sudoku board:

```kotlin
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
println("Test Valid 9x9: " + validSudoku(valid9)) // Expected: true