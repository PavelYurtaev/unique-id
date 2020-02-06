package test.pavelyurtaev.unique.model;

public class UniqueId {

    private final Long id;

    private UniqueId(final Long id) {
        this.id = id;
    }

    public static UniqueId createFromRandomLong(final Long number) {
        return new UniqueId(number);
    }

    public Long getId() {
        return id;
    }
}
