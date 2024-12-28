import java.util.ArrayList;
import java.util.List;

public class Course implements Subject {
	private List<Observer> observers = new ArrayList<>();
	private List<Category> categories = new ArrayList<>();
	private String name;
	
	public Course() {
		observers = new ArrayList();
	}
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		int i = observers.indexOf(o);
		if (i >= 0) {
			observers.remove(i);
		}
	}
	
	public List<Category> getCategories() {
		return categories;
	}

	public String getName() {
		return name;
	}

	public void notifyObservers() {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(categories, name);
		}
	}
	
	public void gradesChanged() {
		notifyObservers();
	}
	
	public void setGrades(List<Category> categories, String name) {
		this.categories = categories;
		this.name = name;
		gradesChanged();
	}
}
