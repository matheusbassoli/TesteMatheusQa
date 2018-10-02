package Compartilhado;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/TesteCucumber/TesteMatheus.feature", tags = "@TesteQA",
plugin = {"json:/var/lib/jenkins/jobs/teste_PreProd/workspace/RoteiroTesteSPCBrasil_Vinicius/target/cucumber-reports/1.json", "html:/var/lib/jenkins/jobs/teste_PreProd/workspace/RoteiroTesteSPCBrasil_Vinicius/target/cucumber-reports/1", "rerun:/var/lib/jenkins/jobs/teste_PreProd/workspace/RoteiroTesteSPCBrasil_Vinicius/target/cucumber-reports/1.txt", "pretty"},
glue = "passos.testes", monochrome = true, dryRun = false)
public class contateste {
}