package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
public class MarksBean {
	private int marks;
	private String result;
	
	public MarksBean() {
		System.out.println("MarksBean()");
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		System.out.println("setMarks()");
		this.marks = marks;
	}
	
	public void valueChanged(ValueChangeEvent evt) 
	{
		System.out.println("valueChanged()");
		System.out.println(marks);
		System.out.println(evt.getNewValue());
	}
    // ActionListener 
	public void process(ActionEvent evt) {
		System.out.println("process()");
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
