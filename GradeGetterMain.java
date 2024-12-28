import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class GradeGetterMain {
	public static void main (String[] args) throws IOException {
		List<Course> courseList = new ArrayList<>();
		String moreCourses = "y";
		GradeScale gc = new GradeScale();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Welcome to Grade Getter!");
		System.out.println("After you enter the grades for each course, you will be prompted with a choice to enter more courses or calculate your current or future grades.");
		while (moreCourses.equalsIgnoreCase("y")) {
			Course course = new Course();
			List<Category> categoryList = new ArrayList<>();
			String moreCategories = "y";
			
			System.out.println("What course would you like to enter your grades for?");
			
			String name = s.next();
			
			System.out.println("This calculator works with grade input by category. The next questions will ask you to input each part of each category of your grade in this course.");
			
			while (moreCategories.equalsIgnoreCase("y")) {
				System.out.println("What is the category called?");
				String cName = s.next();
				System.out.println("What percent of your total grade is this category worth?");
				double catPercent = s.nextDouble();
				System.out.println("How many assignments are there within this category?");
				int numA = s.nextInt();
				System.out.println("What percent of your total grade is each assignment within this category worth?");
				double elementPercent = s.nextDouble();
				System.out.println("Enter each grade for each assignment within this category; enter -1 if the assignment hasn't been graded yet; press enter after each grade: ");
				List<Double> gradeList = new ArrayList<>();
				for (int i = 0; i < numA; i++) {
					gradeList.add(s.nextDouble());
				}
				Category c = new Category(cName, numA, catPercent, elementPercent, gradeList);
				categoryList.add(c);
				System.out.println("Are there any more categories for this course (y/n)?");
				moreCategories = s.next();
			}
			
			course.setGrades(categoryList, name);
			courseList.add(course);
			
			System.out.println("If you would like to add more courses, press (y). If you would like to calculate your grades, press (n)");
			moreCourses = s.next();
		}
		
		System.out.println("If you would like to view your current grade in a course, press (1). If you would like to input future grades to find out what your grade would be in a hypothetical scenario, press (2). If you would like to quit Grade Getter, press (3)");
		int choice = s.nextInt();
		
		while (choice != 3) {
			if (choice == 1) {
				System.out.println("Here are the courses you entered. Press zero to select the top course, one to select the course directly below the top course, two to select the course two below the top course, etc.");
				for (Course c : courseList)
					System.out.println(c.getName());
				int selection = s.nextInt();
				OutputGrade grade = new OutputGrade(courseList.get(selection));
				List<Category> categories = courseList.get(selection).getCategories();
				double toPrint = grade.calcC(categories);
				double roundBy = 0;
				System.out.println("Will the instructor of this course round your grade (y/n)?");
				if (s.next().equalsIgnoreCase("y")) {
					System.out.println("By how much? (eg. .5 (as in 89.5 to 90), 1 (as in 89 to 90), etc.)");
					roundBy = s.nextDouble();
				}
				toPrint += roundBy;
				String letterGrade = gc.getLetterGrade(toPrint);
				System.out.println("Your current grade (with given rounding if applicable) in " + courseList.get(selection).getName() + " is a " + toPrint + " which is an " + letterGrade);
			}
			
			else if (choice == 2) {
				System.out.println("Here are the courses you entered. Press one to select the top course, two to select the course directly below the top course, three to select the course two below the top course, etc.");
				for (Course c : courseList)
					System.out.println(c.getName());
				int selection = s.nextInt();
				System.out.println("Please enter the hypothetical grades you want to test for the assignments that haven't been graded yet");
				OutputGrade grade = new OutputGrade(courseList.get(selection));
				List<Category> categories = courseList.get(selection).getCategories();
				Course futureCourse = new Course();
				for (Category c : categories) {
					System.out.println("Category Name: " + c.getName());
					int futureCount = grade.calcF(c);
					System.out.println("Number of future assignments within this category: " + futureCount);
					System.out.println("Enter each grade for each future assignment within this category; press enter after each grade: ");
					List<Double> gradeList = c.getGradeList();
					for (int i = c.getNumAssignments() - futureCount; i < c.getNumAssignments(); i++) {
						gradeList.add(s.nextDouble());
					}
					futureCourse.setGrades(categories, courseList.get(selection).getName());
				}
				OutputGrade futureGrade = new OutputGrade(futureCourse);
				double toPrint = futureGrade.calcC(categories);
				double roundBy = 0;
				System.out.println("Will the instructor of this course round your grade (y/n)?");
				if (s.next().equalsIgnoreCase("y")) {
					System.out.println("By how much? (eg. .5 (as in 89.5 to 90), 1 (as in 89 to 90), etc.)");
					roundBy = s.nextDouble();
				}
				toPrint += roundBy;
				String letterGrade = gc.getLetterGrade(toPrint);
				System.out.println("Your hypothetical grade (with given rounding if applicable) in " + courseList.get(selection).getName() + " is a " + toPrint + " which is an " + letterGrade);
			}
			System.out.println("If you would like to view your current grade in a course, press (1). If you would like to input future grades to find out what your grade would be in a hypothetical scenario, press (2). If you would like to quit Grade Getter, press (3)");
			choice = s.nextInt();
		}
		
		System.out.println("Thanks for choosing Grade Getter. Goodbye!");
		
	}
}
