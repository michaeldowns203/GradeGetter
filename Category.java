import java.util.List;
import java.util.ArrayList;

public class Category {
	private String name;
	private int numAssignments;
	private double catPercent;
	private double elementPercent;
	private List<Double> gradeList = new ArrayList<>();
	
	public Category(String name, int numAssignments, double catPercent, double elementPercent, List<Double> gradeList) {
		this.name = name;
		this.numAssignments = numAssignments;
		this.catPercent = catPercent;
		this.elementPercent = elementPercent;
		this.gradeList = gradeList;
	}

	public String getName() {
		return name;
	}

	public int getNumAssignments() {
		return numAssignments;
	}

	public double getCatPercent() {
		return catPercent;
	}

	public double getElementPercent() {
		return elementPercent;
	}
	
	public List<Double> getGradeList() {
		return gradeList;
	}

}

