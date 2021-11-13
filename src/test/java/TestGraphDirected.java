import com.github.javafaker.Faker;
import mygraph.graph.GraphDirected;
import mygraph.graph.node.nodefactory.EdgeFactory;

import mygraph.graph.node.nodefactory.Generator;
import mygraph.graph.node.nodefactory.NodeFactory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class TestGraphDirected {
    public static GraphDirected<String, Integer, Integer> graph;

    public static final int nrOfNodesToBeGenerated = 10;
    public static final int nrOfEdgesToBeGenerated = 20;

    static {
        assert nrOfEdgesToBeGenerated < (nrOfNodesToBeGenerated * (nrOfNodesToBeGenerated - 1)) / 2;
    }

    @BeforeAll
    static void beforeAll() {
    }

    @Test
    public void testGraphCreation() {
        Generator<String> nodeLabelGenerator = () -> new Faker().funnyName().name();
        Generator<Integer> nodeValueGenerator = () -> (int) (Math.random() * 1000);
        Generator<Integer> edgeValueGenerator = () -> (int) (Math.random() * 100);

        var nodesList = new NodeFactory<>(nodeLabelGenerator, nodeValueGenerator).generateRandomNodes(nrOfNodesToBeGenerated);
        var edgesMap = new EdgeFactory<>(nodesList, edgeValueGenerator).generateNodesSet(nrOfEdgesToBeGenerated);
//        graph = new GraphDirected<>(nodesList, edgesMap);
    }
}
