package publishconsume;

import javax.jws.WebService;

@WebService
public class PublishWebservice {
	private String Name;
	private String Company;
	
	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getCompany() {
		return Company;
	}

	public void setCompany(String company) {
		Company = company;
	}


		


}
