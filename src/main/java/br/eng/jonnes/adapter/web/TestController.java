package br.eng.jonnes.adapter.web;

import br.eng.jonnes.core.domain.exception.TestException;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")
@Tag(name = "Test", description = "Endpoints para testes")
public class TestController {

    @GetMapping(
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK!")
    })
    public ResponseEntity<String> checkOk() {
        return ResponseEntity.ok("Here's everything OK!");
    }

    @GetMapping(value = "/testException",
            produces = MediaType.TEXT_PLAIN_VALUE
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "418", description = "I refuse to accept this request, your bastard >:/")
    })
    public ResponseEntity<String> testException() {
        throw new TestException("I refuse to accept this request, your bastard >:/");
    }
}
