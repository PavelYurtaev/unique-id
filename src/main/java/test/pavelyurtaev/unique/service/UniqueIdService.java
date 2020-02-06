package test.pavelyurtaev.unique.service;

import org.springframework.stereotype.Service;
import test.pavelyurtaev.unique.exception.FailedUniqueIdGeneration;
import test.pavelyurtaev.unique.model.UniqueId;
import test.pavelyurtaev.unique.model.dao.UniqueIdDao;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class UniqueIdService {

    private final UniqueIdDao uniqueIdDao;

    public UniqueIdService(final UniqueIdDao uniqueIdDao) {
        this.uniqueIdDao = uniqueIdDao;
    }

    public UniqueId getUniqueId() {
        return UniqueId.createFromLong(ThreadLocalRandom.current().nextLong());
    }

    public UniqueId getUniqueIdFromSequence() {
        final Optional<Long> numberFromSequence = uniqueIdDao.getNumberFromSequence();
        if (numberFromSequence.isEmpty()) {
            throw new FailedUniqueIdGeneration("Unable to generate unique id");
        }
        return UniqueId.createFromLong(numberFromSequence.get());
    }

}
