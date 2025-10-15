package Modules.Core.Models;


public class SqlParameter<T extends Object> {
    private final T value;
    private final String name;

    public SqlParameter(String name, T value) {
        this.value = value;
        this.name = name;
    }

    public T getValue() {
        return this.value;
    }

    public String getName() {
        return this.name;
    }
}
