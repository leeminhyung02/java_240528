package test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Food implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2818888265901363808L;
	private String name;
	private int kcal;
	
	public Food() {
	}
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKcal() {
		return kcal;
	}

	public void setKcal(int kcal) {
		this.kcal = kcal;
	}

	@Override
	public String toString() {
		return "[" + name + " : kcal=" + kcal + "]";
	}

	public void fileSave(String fileName) {
		String file = fileName;
		try(FileOutputStream fos = new FileOutputStream(file)){
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(new Food("사과", 20));
			oos.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  
}
