package edu.kis.powp.jobs2d.events;

public enum FigureType {
    FIGURE_JOE_1("Figure Joe 1"),
    FIGURE_JOE_2("Figure Joe 2"),
    RECTANGLE("Rectangle"),
    TRIANGLE("Triangle");

    public final String label;

    private FigureType (String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return this.label;
    }
}
