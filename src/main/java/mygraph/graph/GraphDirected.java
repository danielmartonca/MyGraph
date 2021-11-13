package mygraph.graph;

/**
 * This class is used for storing a directed graph.
 * <p>
 * Each node in the graph will have a label, a value and node neighbours.
 * In order to use the class, you need to specify:
 * -    the type of the label (value mandatory)
 * -    the type of the label value  (value NOT mandatory)
 * -    the type of the edge value (value NOT mandatory)
 *
 * @param <NodeLabelType> the type of each node label
 * @param <NodeValueType> the type of each node value
 * @param <EdgeValueType> the type of each edge value
 */
public class GraphDirected<NodeLabelType, NodeValueType, EdgeValueType> extends AbstractGraph<NodeLabelType, NodeValueType, EdgeValueType> {
}
