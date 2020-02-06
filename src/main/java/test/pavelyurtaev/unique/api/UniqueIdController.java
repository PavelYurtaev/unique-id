package test.pavelyurtaev.unique.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import test.pavelyurtaev.unique.api.dto.UniqueIdDto;
import test.pavelyurtaev.unique.model.UniqueId;
import test.pavelyurtaev.unique.service.UniqueIdService;

@RestController
@RequestMapping("/")
public class UniqueIdController {

    private final UniqueIdService uniqueIdService;

    public UniqueIdController(final UniqueIdService uniqueIdService) {
        this.uniqueIdService = uniqueIdService;
    }

    @GetMapping("/id")
    public ResponseEntity<UniqueIdDto> getRandomInt() {
        final UniqueId response = uniqueIdService.getUniqueId();
        return ResponseEntity.ok(UniqueIdDto.mapFromModel(response));
    }
}
