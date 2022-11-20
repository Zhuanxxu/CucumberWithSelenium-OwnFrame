package cleanTest;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;

public class TestWithCucumber extends TestBaseCucumber {
    private int start;
    private int left;

    @Given("El usuario se encuentra en la pagina Home de imalittletester")
    public void el_usuario_se_encuentra_en_la_pagina_home_de_imalittletester() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        Thread.sleep(3000);
        mainPage.loginButton.click();
        Thread.sleep(3000);
    }

    @When("Hace click sobre el titulo The little tester comics")
    public void hace_click_sobre_el_titulo_the_little_tester_comics() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("paso 1");
    }

    @Then("Se debe redirigir a la pantalla Comics")
    public void se_debe_redirigir_a_la_pantalla_comics() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("paso 1");
    }

    @Given("El usuario")
    public void el_usuario() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("paso 1");
    }

    @When("Hace click")
    public void hace_click() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("paso 1");
    }

    @Then("Se debe redirigir")
    public void se_debe_redirigir() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("paso 1");
    }

    @Given("Hay {int} tareas")
    public void hay_tareas(Integer start) {
        this.start = start;
    }

    @When("Creo {int} tareas")
    public void creo_tareas(Integer tasks) {
        this.left = this.start - tasks;
    }

    @Then("Deberian quedar {int} tareas")
    public void deberian_quedar_tareas(Integer total) {
        Assertions.assertEquals(total + 1, this.left);
    }

    @Given("Un blog llamado {string} con el siguiente contenido")
    public void un_blog_llamado_con_el_siguiente_contenido(String string1, String string2) {
        System.out.println(string1);
        System.out.println(string2);
    }

    @Given("Los siguientes usuarios existentes:")
    public void los_siguientes_usuarios_existentes(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        List<List<String>> rowsWithoutHeading = rows.subList(1, rows.size());

        for (List<String> row : rowsWithoutHeading)
            System.out.println("nombre: " + row.get(0) + " email: " + row.get(1) + " twitter: " + row.get(2));
    }
}
