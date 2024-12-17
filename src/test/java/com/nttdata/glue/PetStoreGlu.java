package com.nttdata.glue;

import com.nttdata.steps.PetStore;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class PetStoreGlu {
    @Steps
    PetStore Store;


    @Given("la url es {string}")
    public void laUrlEs(String url) {
        Store.definirURL(url);
    }

    @Then("valido que la respuesta sea {int}")
    public void validoQueLaRespuestaSea(int statusCode) {Store.validacionRespuesta(statusCode);}

    @When("cuando creo la orden {string} de la mascota {string}")
    public void cuandoCreoLaOrdenDeLaMascota(String IdOrder, String IdPet) {
        Store.Postorder(IdOrder,IdPet);
    }

    @When("cuando consulta la orden {string}")
    public void cuandoConsultaLaOrden(String IdOrder) {
        Store.Getorder(IdOrder);
    }
}

