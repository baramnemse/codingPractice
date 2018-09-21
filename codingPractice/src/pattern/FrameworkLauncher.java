package pattern;

import strategy.ETLApplication;

public class FrameworkLauncher {

	public static void main(String[] args) {
		FrameworkCore core = new FrameworkCore();
		core.applicationContainer.add(new ETLApplication());
		core.init();
		core.run();

	}

}
