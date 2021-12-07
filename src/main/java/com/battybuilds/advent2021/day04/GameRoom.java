package com.battybuilds.advent2021.day04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.battybuilds.advent2021.day04.CoolUtil.convertStringToListOfIntegers;

public class GameRoom {
    private List<BingoBoard> bingoBoards;

    public List<BingoBoard> getBingoBoards() {
        return bingoBoards;
    }

    public BingoBoard setupAndPlayBingoAndReturnWinner(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertStringToListOfIntegers(numbersToDrawInput, ",");
        this.bingoBoards = new BoardBuilder().convertToBingoBoards(boardsInput);
        return playBingoAndReturnWinner(numbersToDraw);
    }

    public BingoBoard setupAndPlayBingoAndReturnLoser(String numbersToDrawInput, List<String> boardsInput) {
        List<Integer> numbersToDraw = convertStringToListOfIntegers(numbersToDrawInput, ",");
        this.bingoBoards = new BoardBuilder().convertToBingoBoards(boardsInput);
        return playBingoAndReturnLoser(numbersToDraw);
    }

    private BingoBoard playBingoAndReturnLoser(List<Integer> numbersToDraw) {
        ArrayList<BingoBoard> boardsByLoser = new ArrayList<>();
        AtomicInteger orderOfWinning = new AtomicInteger(1);
        for (Integer number : numbersToDraw) {
            bingoBoards.forEach(bingoBoard -> {
                if (!bingoBoard.isBingo()) {
                    bingoBoard.markNumberCalled(number);
                    if (bingoBoard.isBingo()) {
                        bingoBoard.setWinningNumber(number);
                        bingoBoard.setWinOrderTo(orderOfWinning.get());
                        orderOfWinning.getAndIncrement();
                        boardsByLoser.add(0, bingoBoard);
                    }
                }
            });
        }
        if (boardsByLoser.size() > 1)
            return boardsByLoser.get(0);
        return null;
    }

    BingoBoard playBingoAndReturnWinner(List<Integer> numbersToDraw) {
        int orderOfWinning = 1;
        for (Integer number : numbersToDraw) {
            bingoBoards.forEach(bingoBoard -> bingoBoard.markNumberCalled(number));
            List<BingoBoard> winningBoardList = checkForWinner();
            if (someoneCalledBingo(winningBoardList, orderOfWinning)) {
                BingoBoard winningBingoBoard = winningBoardList.get(0);
                winningBingoBoard.setWinningNumber(number);
                winningBingoBoard.setWinOrderTo(orderOfWinning);
                return winningBingoBoard;
            }
        }
        return null;
    }

    private List<BingoBoard> checkForWinner() {
        return bingoBoards.stream()
                .filter(BingoBoard::isBingo)
                .collect(Collectors.toList());
    }

    private boolean someoneCalledBingo(List<BingoBoard> winningBoardList, int numberOfPreviousWinners) {
        return winningBoardList.size() == numberOfPreviousWinners;
    }
}
