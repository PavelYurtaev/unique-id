package test.pavelyurtaev.unique.service;

import org.springframework.stereotype.Service;
import test.pavelyurtaev.unique.model.UniqueId;

import java.util.concurrent.ThreadLocalRandom;

@Service
public class UniqueIdService {

    public UniqueId getUniqueId() {
        return UniqueId.createFromRandomLong(ThreadLocalRandom.current().nextLong());
    }

}
