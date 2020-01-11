package pl.poznan.put.gol.game;

public class ConwaysRules implements Rules {

	@Override
	public boolean inNextGeneration(boolean alive, int neighbors) {

		if(alive){
			if(neighbors == 2 || neighbors == 3){ return true; }
			else { return false; }
		}

		if(neighbors == 3){ return true; }
		return false;
	}
}
