package edu.kis.powp.jobs2d.drivers.adapter;

import edu.kis.legacy.drawer.shape.ILine;
import edu.kis.powp.jobs2d.Job2dDriver;
import edu.kis.powp.jobs2d.features.DrawerFeature;

import java.util.function.Supplier;

public class LineDrawerAdapter extends DrawerFeature implements Job2dDriver {
	private int startX = 0;
	private int startY = 0;
	private final Supplier<ILine> lineSupplier;

	public LineDrawerAdapter(Supplier<ILine> lineSupplier) {
		super();
		this.lineSupplier = lineSupplier;
	}

	@Override
	public void setPosition(int x, int y) {
		this.startX = x;
		this.startY = y;
	}

	@Override
	public void operateTo(int x, int y) {
		ILine line = lineSupplier.get();
		line.setStartCoordinates(this.startX, this.startY);
		line.setEndCoordinates(x, y);
		this.startX = x;
		this.startY = y;

		getDrawerController().drawLine(line);
	}

	@Override
	public String toString() {
		return "LineDrawerAdapter";
	}
}

