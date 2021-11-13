package mygraph.graph.node;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * This class is used by AbstractGraph to store each node as a generic label value type.
 * Each node will have:
 * -    a label of type LabelType
 * -    a value of type ValueType
 * -    a set of Node of the same type as the current node where neighbours are kept
 *
 * @param <LabelType> the data type for the label
 * @param <ValueType> the data type for the value
 */
public class Node<LabelType, ValueType> {
    private LabelType label;
    private ValueType value;
    private final Set<Node<LabelType, ValueType>> neighboursSet;

    /**
     * Constructor by specifying both the label and the value
     *
     * @param label the label of the node
     * @param value the value of the node
     */
    public Node(LabelType label, ValueType value) {
        this.label = label;
        this.value = value;
        this.neighboursSet = new HashSet<>();
    }

    /**
     * Constructor without specifying the value (can be set later)
     *
     * @param label the node label
     */
    public Node(LabelType label) {
        this.label = label;
        this.value = null;
        this.neighboursSet = new HashSet<>();
    }

    public LabelType getLabel() {
        return label;
    }

    public void setLabel(LabelType label) {
        this.label = label;
    }

    public ValueType getValue() {
        return value;
    }

    public void setValue(ValueType value) {
        this.value = value;
    }

    public Set<Node<LabelType, ValueType>> getNeighboursSet() {
        return neighboursSet;
    }

    public void addNeighbour(Node<LabelType, ValueType> node) {
        this.neighboursSet.add(node);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node<?, ?> node = (Node<?, ?>) o;
        return label.equals(node.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
