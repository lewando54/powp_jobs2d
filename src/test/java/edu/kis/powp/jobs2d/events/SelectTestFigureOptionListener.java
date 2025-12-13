package edu.kis.powp.jobs2d.events;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

import edu.kis.powp.jobs2d.drivers.DriverManager;
import edu.kis.powp.jobs2d.magicpresets.FiguresJoe;

public class SelectTestFigureOptionListener implements ActionListener {

	private DriverManager driverManager;

	public SelectTestFigureOptionListener(DriverManager driverManager) {
		this.driverManager = driverManager;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        if (Objects.equals(e.getActionCommand(), FigureType.FIGURE_JOE_1.toString())) {
            FiguresJoe.figureScript1(driverManager.getCurrentDriver());
        }
        else if (Objects.equals(e.getActionCommand(), FigureType.FIGURE_JOE_2.toString())) {
            FiguresJoe.figureScript2(driverManager.getCurrentDriver());
        }
	}
}

