
public class GradeScale {
	public GradeScale() {}
	
	public String getLetterGrade(double gradePercent) {
		if (gradePercent >= 93.0)
			return "A";
		else if (gradePercent >= 90.0)
			return "A-";
		else if (gradePercent >= 87.0)
			return "B+";
		else if (gradePercent >= 83.0)
			return "B";
		else if (gradePercent >= 80.0)
			return "B-";
		else if (gradePercent >= 77.0)
			return "C+";
		else if (gradePercent >= 73.0)
			return "C";
		else if (gradePercent >= 70.0)
			return "C-";
		else if (gradePercent >= 67.0)
			return "D+";
		else if (gradePercent >= 63.0)
			return "D";
		else if (gradePercent >= 60.0)
			return "D-";
		else
			return "F";
	}
}
