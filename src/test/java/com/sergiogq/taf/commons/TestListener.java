package com.sergiogq.taf.commons;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

/*
 * Class to lister each test
 */
public class TestListener implements ITestListener {

	// It executes for on each test Start
    @Override
    public void onTestStart(ITestResult result) {
        Log.info("*****************************************************************");
        Log.info("Test Method Started: " + result.getName());
    }

    // It executes for only Passed tests
    @Override
    public void onTestSuccess(ITestResult result) {
    	Log.info("Test Method Passed: " + result.getName());
    }

    // It executes for only Failed tests
    @Override
    public void onTestFailure(ITestResult result) {
    	Log.info("Test Method Failed: " + result.getName());
    }

    // It executes for only Skipped tests
    @Override
    public void onTestSkipped(ITestResult result) {
    	Log.info("Test Method Skipped: " + result.getName());
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // No need to implement all the methods. Can leave empty.
    }

    // It executes for on Suite start
    @Override
    public void onStart(ITestContext context) {
    	Log.info("Test on Start: " + context.getName());
    }

    // It executes for on Suite finish
    @Override
    public void onFinish(ITestContext context) {
    	Log.info("Test on Finish: " + context.getName());
    }

}
