package pattern;

import java.util.ArrayList;
import java.util.List;

import strategy.ETLApplication;

public class FrameworkCore {
	List<ETLApplication> applicationContainer = new ArrayList();

	public void init() {
		for (ETLApplication application : applicationContainer) {
			application.init();
		}
	}

	public void run() {
		for (ETLApplication application : applicationContainer) {
			application.run();
		}
	}
}
