package mygraph.graph;

import mygraph.graph.node.Node;
import pair.Pair;

import java.util.*;

public abstract class AbstractGraph<NodeLabelType, NodeValueType, EdgeValueType> {
    private Set<Node<NodeLabelType, NodeValueType>> nodesSet;
    private Map<Pair<Node<NodeLabelType, NodeValueType>, Node<NodeLabelType, NodeValueType>>, EdgeValueType> edgesMap;

    public AbstractGraph() {
        this.nodesSet = new HashSet<>();
        edgesMap = new HashMap<>();
    }

    public Set<Node<NodeLabelType, NodeValueType>> getNodesSet() {
        return this.nodesSet;
    }

    public void setNodesSet(Set<Node<NodeLabelType, NodeValueType>> nodesSet) {
        this.nodesSet = nodesSet;
        edgesMap = new HashMap<>();
    }

    public void addNode(Node<NodeLabelType, NodeValueType> node) {
        this.nodesSet.add(node);
    }

    /**
     * If you have objects <b>source</b> and <b>destination</b>:
     * use this method to get the value of an edge from source to <b>source</b> <b>destination</b>
     *
     * @param source      node object of type Node
     * @param destination node object of type Node
     * @return the value of the edge (itt may be null!)
     */
    public EdgeValueType getEdgeValue(Node<NodeLabelType, NodeValueType> source, Node<NodeLabelType, NodeValueType> destination) {
        var pair = new Pair<>(source, destination);
        return edgesMap.get(pair);
    }

    /**
     * Use this method to get the value of an edge from source to <b>source</b> <b>destination</b> by specifying the names of the label.
     * <p>
     * This method is much slower on big graphs than the object version.
     *
     * @param sourceLabel      node object of type Node
     * @param destinationLabel node object of type Node
     * @return the value of the edge (itt may be null!)
     */
    public EdgeValueType getEdgeValue(String sourceLabel, String destinationLabel) {
        var pair = new Pair<Node<NodeLabelType, NodeValueType>, Node<NodeLabelType, NodeValueType>>(null, null);
        for (var entry : this.edgesMap.entrySet()) {
            var entryPair = entry.getKey();
            if (entryPair.getKey().getLabel().toString().equals(sourceLabel) &&
                    entryPair.getValue().getLabel().toString().equals(destinationLabel)) {
                return entry.getValue();
            }
        }
        return edgesMap.get(pair);
    }

    public boolean containsEdge(Node<NodeLabelType, NodeValueType> source, Node<NodeLabelType, NodeValueType> destination) {
        var pair = new Pair<>(source, destination);
        return edgesMap.containsKey(pair);
    }

    public void addEdge(Node<NodeLabelType, NodeValueType> node1, Node<NodeLabelType, NodeValueType> node2, EdgeValueType edgeValue) {
        var pair = new Pair<>(node1, node2);
        edgesMap.putIfAbsent(pair, edgeValue);
    }

    public void addEdge(Node<NodeLabelType, NodeValueType> node1, Node<NodeLabelType, NodeValueType> node2) {
        var pair = new Pair<>(node1, node2);
        edgesMap.putIfAbsent(pair, null);
    }

    public void setEdgeValue(Node<NodeLabelType, NodeValueType> node1, Node<NodeLabelType, NodeValueType> node2, EdgeValueType edgeValue) {
        var pair = new Pair<>(node1, node2);
        edgesMap.put(pair, edgeValue);
    }

    public void synchronizeGraph() {
        this.edgesMap = Collections.synchronizedMap(this.edgesMap);
    }
}
