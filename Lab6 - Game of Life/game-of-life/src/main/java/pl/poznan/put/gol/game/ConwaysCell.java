package pl.poznan.put.gol.game;

import java.util.Objects;

public class ConwaysCell implements Cell {

	protected int i;
	protected int j;

	public ConwaysCell(int i, int j) {
		this.i = i;
		this.j = j;
	}

	@Override
	public int hashCode() { return Objects.hash(i, j); }

	@Override
	public Cells neighbors() {

		Cells neighbors = new Cells();

		neighbors.add(new ConwaysCell(i - 1, j - 1));
		neighbors.add(new ConwaysCell(i - 1, j));
		neighbors.add(new ConwaysCell(i - 1, j + 1));
		neighbors.add(new ConwaysCell(i, j - 1));
		neighbors.add(new ConwaysCell(i, j + 1));
		neighbors.add(new ConwaysCell(i + 1, j - 1));
		neighbors.add(new ConwaysCell(i + 1, j));
		neighbors.add(new ConwaysCell(i + 1, j + 1));

		return neighbors;
	}

	@Override
	public boolean equals(Object o) {

		if (this == o) return true;

		if (o == null || o.getClass() != this.getClass()) return false;

		ConwaysCell oo = (ConwaysCell) o;
		if(i == oo.i && j == oo.j) return true;
		else return false;
	}

	@Override
	public String toString() {
		return "c(" + i + ":" + j + ")";
	}

}
