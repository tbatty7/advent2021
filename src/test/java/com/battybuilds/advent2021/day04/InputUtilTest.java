package com.battybuilds.advent2021.day04;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static com.battybuilds.advent2021.day04.CoolUtil.convertToBingoBoxes;
import static org.assertj.core.api.Assertions.assertThat;

class InputUtilTest {
    @Test
    void canConvertNumbersToDrawListOf_1() {
        String numbersToDrawInput = "13";
        List<Integer> numbersToDraw = CoolUtil.convertStringToListOfIntegers(numbersToDrawInput, ",");
        assertThat(numbersToDraw.size()).isEqualTo(1);
    }

    @Test
    void canConvertNumbersToDrawListOf_5() {
        String numbersToDrawInput = "22,13,17,11,0";
        List<Integer> numbersToDraw = CoolUtil.convertStringToListOfIntegers(numbersToDrawInput, ",");
        assertThat(numbersToDraw.size()).isEqualTo(5);
    }

    @Test
    void canConvertRowOfBingoBoard() {
        String bingoBoardRow = "22 13 17 11  0";
        List<Integer> numbersToDraw = CoolUtil.convertStringToListOfIntegers(bingoBoardRow, " ");
        assertThat(numbersToDraw.size()).isEqualTo(5);
        assertThat(numbersToDraw.get(0)).isEqualTo(22);
        assertThat(numbersToDraw.get(4)).isEqualTo(0);
    }

    @Test
    void canConvertToRowsOfBingoBoxes() {
        List<String> rowsInput = buildSingleBoardRowsInput();
        List<List<Integer>> bingoBoxRows = CoolUtil.convertToRowsOfIntegers(rowsInput);
        assertThat(bingoBoxRows).isEqualTo(buildRowsForBingoBoard());
    }

    @Test
    void convertRowsOfIntegersToRowsOfBingoBoxes() {
        List<String> rowsInput = buildSingleBoardRowsInput();
        List<List<BingoBox>> rowsOfBingoBoxes = convertToBingoBoxes(rowsInput);
        assertThat(rowsOfBingoBoxes.get(0).get(0)).usingRecursiveComparison().isEqualTo(new BingoBox(22));
    }

    private List<String> buildSingleBoardRowsInput() {
        return Arrays.asList("22 13 17 11  0", " 8  2 23  4 24", "21  9 14 16  7", " 6 10  3 18  5", " 1 12 20 15 19");
    }

    private List<List<Integer>> buildRowsForBingoBoard() {
        List<Integer> row1 = Arrays.asList(22, 13, 17, 11, 0);
        List<Integer> row2 = Arrays.asList(8, 2, 23, 4, 24);
        List<Integer> row3 = Arrays.asList(21, 9, 14, 16, 7);
        List<Integer> row4 = Arrays.asList(6, 10, 3, 18, 5);
        List<Integer> row5 = Arrays.asList(1, 12, 20, 15, 19);
        return Arrays.asList(row1, row2, row3, row4, row5);
    }
}