package main;

import testCase.checkLabel;

public class MainTesting {
	
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\automation\\New folder\\chromedriver.exe");
		checkLabel tc01 = new checkLabel();
		tc01.TC_01();
		}

	
}
