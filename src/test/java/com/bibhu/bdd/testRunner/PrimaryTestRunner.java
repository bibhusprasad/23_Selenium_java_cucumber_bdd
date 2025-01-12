package com.bibhu.bdd.testRunner;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.FEATURES_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.FILTER_TAGS_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("com/bibhu/bdd/stepDefinitions")
@ConfigurationParameter(key = FEATURES_PROPERTY_NAME,value = "src/test/resources/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com/bibhu/bdd/stepDefinitions")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@contact-us or @login")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@regression")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@contact-us")
//@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@login")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty, html:target/cucumber-report/cucumber.html, json:target/cucumber-report/cucumber.json")
public class PrimaryTestRunner {
}
