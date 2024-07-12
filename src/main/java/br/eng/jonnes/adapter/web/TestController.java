package br.eng.jonnes.adapter.web;

import br.eng.jonnes.core.domain.model.Friend;
import br.eng.jonnes.core.domain.model.FriendCheckMajorityRequest;
import br.eng.jonnes.core.domain.model.FriendRegisterRequest;
import br.eng.jonnes.core.port.in.CheckFriendMajorityInputPort;
import br.eng.jonnes.core.port.in.RegisterFriendInputPort;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

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
}
