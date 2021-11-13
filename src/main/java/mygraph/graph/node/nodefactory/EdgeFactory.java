package mygraph.graph.node.nodefactory;

import mygraph.graph.node.Node;
import pair.Pair;

import java.util.*;

public class EdgeFactory<NodeLabelType, NodeValueType, EdgeValueType> {
    private final List<Node<NodeLabelType, NodeValueType>> nodesList;
    private final Generator<EdgeValueType> valueGenerator;

    public EdgeFactory(List<Node<NodeLabelType, NodeValueType>> nodesList, Generator<EdgeValueType> valueGenerator) {
        this.nodesList = nodesList;
        this.valueGenerator = valueGenerator;
    }

    public Map<Pair<Node<NodeLabelType, NodeValueType>, Node<NodeLabelType, NodeValueType>>, EdgeValueType> generateNodesSet(int n) {
        Map<Pair<Node<NodeLabelType, NodeValueType>, Node<NodeLabelType, NodeValueType>>, EdgeValueType> edgesMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            var index1 = (int) (Math.random() * nodesList.size());
            var index2 = (int) (Math.random() * nodesList.size());
            if (index1 == index2) i--;
            else {
                var pair = new Pair<>(nodesList.get(index1), nodesList.get(index2));
                if (edgesMap.containsKey(pair)) i--;
                else
                    edgesMap.put(pair, valueGenerator.generate());
            }
        }
        return edgesMap;
    }
}
