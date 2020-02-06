package test.pavelyurtaev.unique.api.dto;

import test.pavelyurtaev.unique.model.UniqueId;

public class UniqueIdDto {

    private Long id;

    private UniqueIdDto(final Long id) {
        this.id = id;
    }

    public UniqueIdDto() {
    }

    public static UniqueIdDto mapFromModel(final UniqueId uniqueId) {
        return new UniqueIdDto(uniqueId.getId());
    }

    public Long getId() {
        return id;
    }

}
