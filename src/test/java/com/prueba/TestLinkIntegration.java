package com.prueba;

import testlink.api.java.client.TestLinkAPIClient;
import testlink.api.java.client.TestLinkAPIException;

public class TestLinkIntegration {
	
	public static final String TESTLINK_KEY = "71d7c83387ee0a1696b4b1bd39147b38";
	public static final String TESTLINK_URL = "http://localhost/testlink/lib/api/xmlrpc/v1/xmlrpc.php";
	public static final String TEST_PROJECT_NAME = "ProjectAnt";
	public static final String TEST_PLAN_NAME = "AntPlan";
	public static final String TEST_CASE_NAME1 = "WebTest";
	public static final String TEST_CASE_NAME2 = "WebTest2";
	public static final String TEST_CASE_NAME3 = "WebTest3";
	public static final String BUILD_NAME = "BuildAnt";
	
	public static void updateResults(String testCaseName, String exception, String results) throws TestLinkAPIException {
		TestLinkAPIClient testlink = new TestLinkAPIClient(TESTLINK_KEY, TESTLINK_URL);
		testlink.reportTestCaseResult(TEST_PROJECT_NAME, TEST_PLAN_NAME, testCaseName, BUILD_NAME, exception, results);
	}
	
}
