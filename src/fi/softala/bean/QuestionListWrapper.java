package fi.softala.bean;

import java.util.List;

public class QuestionListWrapper {
	private List<AChoice> acList;

	public List<AChoice> getAcList() {
		return acList;
	}

	public void setAcList(List<AChoice> acList) {
		this.acList = acList;
	}
	
	public void add(AChoice ac) {
		this.acList.add(ac);
	}
}
