package pair;

import java.util.Objects;

public class Pair<KeyType, ValueType> {
    KeyType key;
    ValueType value;

    public Pair(KeyType key, ValueType value) {
        this.key = key;
        this.value = value;
    }

    public KeyType getKey() {
        return key;
    }

    public void setKey(KeyType key) {
        this.key = key;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        var thisToString = (key.toString() + value.toString());
        var oToString = (pair.key.toString() + pair.value.toString());
        return thisToString.equals(oToString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key, value);
    }
}
