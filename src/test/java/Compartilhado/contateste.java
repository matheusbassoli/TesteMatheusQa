package Compartilhado;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/TesteCucumber/TesteMatheus.feature", tags = "@TesteQA", 
glue = "passos.testes", monochrome = true, dryRun = false)
public class contateste {
}