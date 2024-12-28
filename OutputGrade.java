import java.util.ArrayList;
import java.util.List;

public class OutputGrade implements Observer {
	private List<Category> categories = new ArrayList<>();
	private String name;
	private Subject course;
	
	public OutputGrade(Subject course) {
		this.course = course;
		course.registerObserver(this);
	}
	
	public void update(List<Category> categories, String name) {
		this.categories = categories;
		this.name = name;
	}
	
	public int calcF(Category c) {
		double finalGrade = 0;
		int futureCount = 0;
			double catGrade;
			double gradeSum = 0;
			int gradeCount = 0;
			String name1 = c.getName();
			int numAssignments = c.getNumAssignments();
			double catPercent = c.getCatPercent();
			double elementPercent = c.getElementPercent();
			List<Double> gradeList = c.getGradeList();
			for (Double grade : gradeList) {
				if (grade != -1) {
					gradeSum += grade * (elementPercent / 100.0);
					gradeCount++;
				}
				else {
					futureCount++;
				}
			}
		
		return futureCount;
	}
	
	public double calcC(List<Category> categories) {
		double finalGrade = 0;
		for (Category c : categories) {
			double catGrade;
			double gradeSum = 0;
			int gradeCount = 0;
			String name1 = c.getName();
			int numAssignments = c.getNumAssignments();
			double catPercent = c.getCatPercent();
			double elementPercent = c.getElementPercent();
			List<Double> gradeList = c.getGradeList();
			for (Double grade : gradeList) {
				if (grade != -1) {
					gradeSum += grade * (elementPercent / 100.0);
					gradeCount++;
				}
			}
			catGrade = gradeSum / (gradeCount * elementPercent);
			finalGrade += catGrade * catPercent;
		}
		return finalGrade;
	}
	
	public void display() {
		System.out.println("");
	}
}
