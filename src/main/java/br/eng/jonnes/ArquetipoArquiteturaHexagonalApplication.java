package br.eng.jonnes;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "br.eng.jonnes"
})
@OpenAPIDefinition(info = @Info(title = "Ports and Adapters",
        description = "Arquetipo Arquitetura Hexagonal"))
public class ArquetipoArquiteturaHexagonalApplication {

    public static void main(String[] args) {
        SpringApplication.run(ArquetipoArquiteturaHexagonalApplication.class, args);
    }

}
