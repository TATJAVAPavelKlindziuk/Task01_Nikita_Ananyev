package com.ananyev.task8.test.numbercontroller;

import org.testng.annotations.Test;

import com.ananyev.task6.NumberController;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

/*
 * Unit tests for controlNumbers() of task8.NumberController.class
 */
public class ControlNumbersTest  {
	NumberController controller;	
	
	@BeforeClass
	public void beforeClass() {
		controller = new NumberController();
	}

	@AfterClass
	
	public void afterClass() {
        controller = null;
	}

	@Test(priority = 1)
	public void controlNumberPositiveTrue() {
		String[] args = { "1", "1" };
		Assert.assertTrue(controller.controlNumbers(args));
	}
	
	@Test(priority = 2,expectedExceptions = IllegalArgumentException.class)
	public void controlNumberPositiveFalseTooMany() {
		String[] args = { "1", "1", "4" };
		Assert.assertTrue(controller.controlNumbers(args));
	}
	
	@Test(priority = 3)
	public void controlNumberPositiveNotEnought() {
		String[] args = {"1", "2"};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	
	@Test(priority = 4)
	public void controlNumberPositiveSpecialSymbolValidArgsFalse() {
		String[] args = {"1&*", "2"};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	
	@Test(priority = 5)
	public void controlNumberPositiveValidSpecialSymbolsValidFalse() {
		String[] args = {"12", "2&*"};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	
	
	@Test(priority = 6)
	public void controlNumberPositiveLettersFalse() {
		String[] args = {"1ffsf", "2gg"};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	
	@Test(priority = 7)
	public void controlNumberPositiveLettersValidArgsFalse() {
		String[] args = {"2", "2hf1"};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	
	@Test(priority = 8)
	public void controlNumberPositiveEmptyStringValidArgFalse() {
		String[] args = {"1", ""};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	
	@Test(priority = 9)
	public void controlNumberPositiveValidEmptyStringFalse() {
		String[] args = {"", "2"};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	@Test(priority = 10)
	public void controlNumberPositiveValidUTF16() {
		String[] args = {"\uD835\uDD0A", "2"};
		Assert.assertFalse(controller.controlNumbers(args));
	}
	
	@Test(priority = 11)
	public void controlNumberNegativeTrue() {
		String[] args = { "1", "-6" };
		Assert.assertFalse(controller.controlNumbers(args));
	}
}
