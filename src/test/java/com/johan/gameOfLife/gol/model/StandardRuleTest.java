package com.johan.gameOfLife.gol.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StandardRuleTest {
    private Board board;
    private SimulationRule simulationRule;

    @BeforeEach
    void setUp() {
        board = new BoundBoard(3, 3);
        simulationRule = new StandardRule();
    }

    @Test
    void getNextState_with_no_live_neighbours() {
        board.setState(1, 1, CellState.ALIVE);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }

    @Test
    void getNextState_with_fewer_than_two_live_neighbours_should_die() {
        board.setState(1, 1, CellState.ALIVE);
        board.setState(0, 0, CellState.ALIVE);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }

    @Test
    void getNextState_with_two_alive_neighbours() {
        board.setState(1, 1, CellState.ALIVE);
        board.setState(2, 2, CellState.ALIVE);
        board.setState(1, 2, CellState.ALIVE);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.ALIVE, nextState);
    }

    @Test
    void getNextState_with_three_alive_neighbours() {
        board.setState(1, 1, CellState.ALIVE);
        board.setState(0, 2, CellState.ALIVE);
        board.setState(2, 1, CellState.ALIVE);
        board.setState(2, 2, CellState.ALIVE);


        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.ALIVE, nextState);
    }

    @Test
    void getNextState_with_four_alive_neighbours() {
        board.setState(1, 1, CellState.ALIVE);
        board.setState(0, 2, CellState.ALIVE);
        board.setState(2, 1, CellState.ALIVE);
        board.setState(0, 1, CellState.ALIVE);
        board.setState(1, 0, CellState.ALIVE);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }

    @Test
    void getNextState_with_eight_alive_neighbours() {
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                board.setState(x, y, CellState.ALIVE);
            }
        }

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }

    @Test
    void getNextState_dead_cell_with_no_neighbours() {
        board.setState(1, 1, CellState.DEAD);
        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }
    @Test
    void getNextState_dead_cell_with_two_neighbours() {
        board.setState(1, 1, CellState.DEAD);
        board.setState(2, 2, CellState.ALIVE);
        board.setState(1, 2, CellState.ALIVE);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }

    @Test
    void getNextState_dead_cell_with_three_live_neighbours_should_be_alive() {
        board.setState(1, 1, CellState.DEAD);
        board.setState(2, 2, CellState.ALIVE);
        board.setState(1, 2, CellState.ALIVE);
        board.setState(0, 1, CellState.ALIVE);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.ALIVE, nextState);
    }
    @Test
    void getNextState_dead_cell_with_four_live_neighbours_should_be_alive() {
        board.setState(1, 1, CellState.DEAD);
        board.setState(2, 2, CellState.ALIVE);
        board.setState(1, 2, CellState.ALIVE);
        board.setState(0, 1, CellState.ALIVE);
        board.setState(0, 2, CellState.ALIVE);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }
    @Test
    void getNextState_dead_cell_with_eight_alive_neighbours() {
        for (int y = 0; y < board.getHeight(); y++) {
            for (int x = 0; x < board.getWidth(); x++) {
                board.setState(x, y, CellState.ALIVE);
            }
        }
        board.setState(1,1,CellState.DEAD);

        CellState nextState = simulationRule.getNextState(1, 1, board);
        assertEquals(CellState.DEAD, nextState);
    }
}