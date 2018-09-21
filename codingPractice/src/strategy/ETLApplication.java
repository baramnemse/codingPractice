package strategy;

public class ETLApplication {
	IETLService etlService;

	public void setEtlService(IETLService etlService) {
		this.etlService = etlService;
	}

	public void init() {
		etlService = new IETLService(){

			@Override
			public void extract() {
				System.out.println("Strategy");
				
			}
		};
		//setEtlService(() ->{ System.out.println("걸어서 이동 !")});
	}

	public void run() {
		etlService.extract();
	}
}
