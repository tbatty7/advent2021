package com.battybuilds.advent2021.day04;

import java.util.ArrayList;
import java.util.List;

import static com.battybuilds.advent2021.day04.CoolUtil.convertToBingoBoxes;

public class BoardBuilder {
    public List<BingoBoard> convertToBingoBoards(List<String> boardsInput) {
        List<BingoBoard> boards = new ArrayList<>();
        int boardNumber = 1;
        for (int i = 0; i < boardsInput.size(); i += 6) {
            List<String> boardInput = boardsInput.subList(i, i + 5);
            BingoBoard bingoBoard = new BoardBuilder().buildBingoBoard(boardInput, boardNumber);
            boards.add(bingoBoard);
            boardNumber++;
        }
        return boards;
    }

    BingoBoard buildBingoBoard(List<String> boardInput, int boardNumber) {
        List<List<BingoBox>> rowsOfBingoBoxes = convertToBingoBoxes(boardInput);
        return new BingoBoard(rowsOfBingoBoxes, boardNumber);
    }
}
