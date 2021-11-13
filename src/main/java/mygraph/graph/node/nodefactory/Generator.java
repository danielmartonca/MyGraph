package mygraph.graph.node.nodefactory;

/**
 * This interface is used to specify how a certain value will be generated.
 *
 * @param <Type>> the type of the value to be generated
 */
public interface Generator<Type> {
    /**
     * This method needs to be implemented in order to specify how the value will be generated
     *
     * @return an object of type Type
     */
    Type generate();
}
