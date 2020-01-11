package pl.poznan.put.gol.game;

public class Generation {

	private Rules rules;
	private Cells aliveCells;

	public Generation(Rules rules, Cell... aliveCells) {
		this(rules, new Cells(aliveCells));
	}

	public Generation(Rules rules, Cells aliveCells) {
		this.rules = rules;
		this.aliveCells = aliveCells;
	}

	public void evolve() {

		Cells gen = new Cells();

		for(Cell c : aliveCells.getNeighbors()){
			if(rules.inNextGeneration(isAlive(c), countAliveNeighbors(c))){
				gen.add(c);
			}
		}

		aliveCells = gen;
	}

	public boolean isAlive(Cell cell) {
		return aliveCells.contains(cell);
	}

	public int countAliveNeighbors(Cell cell) {

		int count = 0;

		for(Cell c : cell.neighbors()){
			if(isAlive(c)){ count++; }
		}

		return count;
	}

	public boolean extinct() {
		return aliveCells.isEmpty();
	}

	public Cells getAliveCells() {
		return aliveCells;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Generation)) {
			return false;
		}
		Generation other = (Generation) obj;
		return aliveCells.equals(other.aliveCells);
	}
}
