package mygraph.graph.node.nodefactory;

import mygraph.graph.node.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * This class is used to generate random nodes.
 * In order to generate the nodes, you need to specify:
 * -    the type of the nodes label
 * -    the type of the nodes value
 * -    a class that implements the LabelGenerator interface with the same type as node label type.
 * -    a class that implements the ValueGenerator interface with the same type as node value type.
 *
 * @param <NodeLabelType> the type of the node label
 * @param <NodeValueType> the type of the node value
 */
public class NodeFactory<NodeLabelType, NodeValueType> {
    private final Generator<NodeLabelType> labelGenerator;
    private final Generator<NodeValueType> valueGenerator;

    public NodeFactory(Generator<NodeLabelType> labelGenerator, Generator<NodeValueType> valueGenerator) {
        this.labelGenerator = labelGenerator;
        this.valueGenerator = valueGenerator;
    }

    /**
     * This method returns random n nodes with random labels and values
     *
     * @param n the number of nodes to be generated
     * @return a list of nodes
     */
    public List<Node<NodeLabelType, NodeValueType>> generateRandomNodes(int n) {
        List<Node<NodeLabelType, NodeValueType>> nodesList = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            var node = new Node<>(labelGenerator.generate(), valueGenerator.generate());
            nodesList.add(node);
        }
        return nodesList;
    }
}
