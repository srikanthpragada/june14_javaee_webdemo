package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

@ManagedBean
public class MarksBean {
	private int marks;
	private String result;

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}
    // ActionListener 
	public void process(ActionEvent evt) {
		if (marks > 80)
			result = "Grade A";
		else if (marks > 60)
			result = "Grade B";
		else
			result = "Grade C";
	}

	public String getResult() {
		return result;
	}

}
