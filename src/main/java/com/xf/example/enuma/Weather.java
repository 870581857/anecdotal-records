package com.xf.example.enuma;

import java.util.Arrays;
import java.util.List;
 
public enum Weather{

    Sunny(1, "晴天") {
		@Override
		public String test() {
			return "今天阳光明媚！！！\n";
		}
	},
	Rainy(2, "雨天") {
		@Override
		public String test() {
			return "出门别忘带把雨伞哦！！！\n";
		}
	},
	Cloudy(3, "多云") {
		@Override
		public String test() {
			return "别出去登高望远了，你看不远的，呵呵呵！！！\n";
		}
	};

	public abstract String test();
 
	private int value;
	private String label;

	private Weather(int value, String label) {
		this.value = value;
		this.label = label;
	}
 
	public int getValue() {
		return value;
	}
 
	public String getLabel() {
		return label;
	}

	public static Weather parse(int value) {
		Weather result = Weather.Sunny;
		switch (value) {
		case 1:
			result = Weather.Sunny;
			break;
		case 2:
			result = Weather.Rainy;
			break;
		case 3:
			result = Weather.Cloudy;
			break;
		}
		return result;
	}
 
	public static List<Weather> getEnumValues() {
		return Arrays.asList(values());
	}
 
	public static void main(String[] args) {
		System.out.println(Weather.Sunny.getValue() + ":" + Weather.Sunny.getLabel());
		Weather weather = Weather.Cloudy;
		System.out.println(weather.getValue() + ":" + weather.getLabel() + "\n\n");
		List<Weather> list = getEnumValues();
		for (Weather sw : list) {
			System.out.println(sw.value + "--" + sw.label + "--" + sw.test());
		}
	}
}
