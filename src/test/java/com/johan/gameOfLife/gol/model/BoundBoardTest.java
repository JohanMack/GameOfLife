package com.johan.gameOfLife.gol.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoundBoardTest {

    private Board board;


    @BeforeEach
    void setUp() {
        this.board = new BoundBoard(5, 3);
    }

    @Test
    void copy_should_be_same_size_as_original() {
        Board copy = board.copy();

        assertEquals(5, copy.getWidth());
        assertEquals(3, copy.getHeight());
    }

    @Test
    void copy_should_change_new_instance_but_not_old_one() {
        Board copy = board.copy();
        copy.setState(3, 2, CellState.ALIVE);

        assertEquals(CellState.DEAD, board.getState(3, 2));
        assertEquals(CellState.ALIVE, copy.getState(3, 2));
    }

    @Test
    void copy_should_have_same_state_as_original() {
        board.setState(0, 0, CellState.ALIVE);
        board.setState(0, 1, CellState.ALIVE);
        board.setState(0, 2, CellState.ALIVE);

        Board copy = board.copy();
        for (int x = 0; x < copy.getWidth(); x++) {
            for (int y = 0; y < copy.getHeight(); y++) {
                assertEquals(board.getState(x, y), copy.getState(x, y));

            }
        }
    }

    @Test
    void copy_set_and_get_should_not_fail_at_out_of_bounds() {
        board.setState(-1, 0, CellState.ALIVE);
        board.setState(5, 0, CellState.ALIVE);
        board.setState(0, -1, CellState.ALIVE);
        board.setState(0, 3, CellState.ALIVE);

        board.getState(-1, 0);
        board.getState(5, 0);
        board.getState(0, -1);
        board.getState(0, 3);
    }

    @Test
    void setState_getState_should_return_updated_result() {
        board.setState(4, 1, CellState.ALIVE);

        assertEquals(CellState.ALIVE, board.getState(4, 1));
    }
}