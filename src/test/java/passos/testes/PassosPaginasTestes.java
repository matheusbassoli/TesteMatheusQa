package passos.testes;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import Compartilhado.SetConfiguracao;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import passos.paginas.PassosTestes;

public class PassosPaginasTestes {

	SetConfiguracao setConfiguracao;
	PassosTestes passostestes;
	Scenario scenario;
	String result = null;

	@Before("@Firefox")
	public void beforeScenario() {
		setConfiguracao = new SetConfiguracao(1);
	}

	@Before("@Chrome")
	public void beforeScenario1() {
		setConfiguracao = new SetConfiguracao(3);
	}

	@Before("@IE")
	public void driverFactory() {
		setConfiguracao = new SetConfiguracao(2);
	}

	@After
	public void FechaNavegador(Scenario scenario) {
		this.scenario = scenario;
		if (scenario.isFailed()) {
			scenario.write("FAIL_" + scenario.getName() + "_" + scenario.getStatus());
			byte[] screenshot = ((TakesScreenshot) SetConfiguracao.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			result = "FAIL";
		} else {
			scenario.write("SUCESS_" + scenario.getName() + "_" + scenario.getStatus());
			byte[] screenshot = ((TakesScreenshot) SetConfiguracao.getDriver()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
			result = "SUCESS";
		}
//		 setConfiguracao.closeBrowser();
	}

	@Dado("^o usuario acessa a url (.*)$")
	public void o_usuario_acessa_a_url(String arg) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.AcessaPagina(arg);
	}

	@Quando("^o usuario acessar a primeira tela de acesso o mesmo clicara no item criar conta$")
	public void o_usuario_acessar_a_primeira_tela_de_acesso_o_mesmo_clicara_no_item_criar_conta() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.CriarConta();
	}

	@Quando("^digitar na tela Criar sua Conta do Google o nome (.*)$")
	public void digitar_na_tela_criar_sua_conta_do_google_o_nome(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vNome(arg1);
	}

	@Quando("^digitar na tela Criar sua Conta do Google o Sobrenome (.*)$")
	public void digitar_na_tela_criar_sua_conta_do_google_o_sobrenome(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vSobreNome(arg1);
	}

	@Quando("^digitar na tela Criar sua Conta do Google o item nome de usuario (.*)$")
	public void digitar_na_tela_criar_sua_conta_do_google_o_item_nome_de_usuario(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vNomeUsuario(arg1);
	}

	@Quando("^digitar na tela Criar sua Conta do Google a senha (.*)$")
	public void digitar_na_tela_criar_sua_conta_do_google_a_senha(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vSenha(arg1);
	}

	@Quando("^digitar na tela Criar sua Conta do Google confirmar senha (.*)$")
	public void digitar_na_tela_criar_sua_conta_do_google_confirmar_senha(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vConfirmarSenha(arg1);
	}

	@Quando("^na tela Criar sua Conta do Google clicar em proximo$")
	public void na_tela_criar_sua_conta_do_google_clicar_em_proximo() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.Proximo();
	}

	@Quando("^digitar na tela bem vindo ao google o numero de telefone (.*)$")
	public void digitar_na_tela_bem_vindo_ao_google_o_numero_de_telefone(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vTelefone(arg1);
	}

	@Quando("^digitar na tela bem vindo ao google o endereco de email de recuperacao (.*)$")
	public void digitar_na_tela_bem_vindo_ao_google_o_endereco_de_email_de_recuperacao(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vEmailRecu(arg1);
	}

	@Quando("^digitar na tela bem vindo ao google o dia de nascimento (.*)$")
	public void digitar_na_tela_bem_vindo_ao_google_o_dia_de_nascimento(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vDia(arg1);
	}

	@Quando("^selecionar na tela bem vindo ao google o mes de nascimento (.*)$")
	public void selecionar_na_tela_bem_vindo_ao_google_o_mes_de_nascimento(String arg) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vMes(arg, arg);
	}

	@Quando("^digitar na tela bem vindo ao google o ano de nascimento (.*)$")
	public void digitar_na_tela_bem_vindo_ao_google_o_ano_de_nascimento(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vAno(arg1);
	}

	@Quando("^selecionar na tela bem vindo ao google o genero (.*)$")
	public void selecionar_na_tela_bem_vindo_ao_google_o_genero(String arg1) {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vGenero(arg1, arg1);
	}

	@Quando("^na tela bem vindo ao google clicar em proximo$")
	public void na_tela_bem_vindo_ao_google_clicar_em_proximo() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vProximo2();
	}
    
	@Quando("^na tela verifique seu numero de telefone clicar no item agora nao$")
	public void na_tela_verifique_seu_numero_de_telefone_clicar_no_item_agora_nao() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vAgoraNao();
	}
	
	@Quando("^clicar na tela Privacidade e Termos no item proximo$")
	public void clicar_na_tela_privacidade_e_termos_no_item_proximo() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vIproximo();
	}
		
	@Quando("^clicar na tela Privacidade e Termos no item proximo2$")
	public void clicar_na_tela_privacidade_e_termos_no_item_proximo2() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vIproximo2();
	}
	@Quando("^clicar na tela Privacidade e Termos no item proximo3$")
	public void clicar_na_tela_privacidade_e_termos_no_item_proximo3() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vIproximo3();
	}
	@Quando("^clicar na tela Privacidade e Termos no item concordo$")
	public void clicar_na_tela_privacidade_e_termos_no_item_concordo() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vConcordo();
	}
	@Quando("^clicar na tela inicial no item proximo$")
	public void clicar_na_tela_inicial_no_item_proximo() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vProximoFim();
	}
	@Quando("^clicar na tela inicial no item ok$")
	public void clicar_na_tela_inicial_no_item_ok() {
		passostestes = new PassosTestes(SetConfiguracao.getDriver());
		passostestes.vOk();
	}
}
