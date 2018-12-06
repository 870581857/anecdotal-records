package com.xf.example.enuma;

import java.util.Arrays;
import java.util.List;
 
public enum Weather1 {
 
	Sunny(1, "晴天"), Rainy(2, "雨天"), Cloudy(3, "多云");
    private int value;
	private String label;
 
	private Weather1(int value, String label) {
		this.value = value;
		this.label = label;
	}
 
	public int getValue() {
		return value;
	}
 
	public String getLabel() {
		return label;
	}
 
	public static Weather1 parse(int value) {
		Weather1 result = Weather1.Sunny;
		switch (value) {
		case 1:
			result = Weather1.Sunny;
			break;
		case 2:
			result = Weather1.Rainy;
			break;
		case 3:
			result = Weather1.Cloudy;
			break;
		}
		return result;
	}
 
	public static List<Weather1> getEnumValues() {
		return Arrays.asList(values());
	}
 
	public static void main(String[] args) {
		System.out.println(Sunny.getValue() + ":" + Sunny.getLabel());
		Weather1 Weather1 = Cloudy;
		System.out.println(Weather1.getValue() + ":" + Weather1.getLabel());
		List<Weather1> list = getEnumValues();
		for (Weather1 sw : list) {
			System.out.println(sw.value + "--" + sw.label);
		}
	}
}
