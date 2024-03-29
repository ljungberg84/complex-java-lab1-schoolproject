package se.alten.schoolproject.errorhandling;

@FunctionalInterface
public interface ThrowingConsumer <T, E extends Exception> {

    void accept(T t) throws E;
}
