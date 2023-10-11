/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Stack<Node> pilha = new Stack<>();
        List<Node> ret = new LinkedList<>();

        Node atual;
        pilha.push(node);

        if (node == null || node.neighbors.isEmpty())
            return node;

        List<Integer> flag = new ArrayList<>();
        Stack<Node> pilha2 = new Stack<>();

        while (!(pilha.isEmpty())){
            atual = pilha.pop();
            for (int i = 0; i < atual.neighbors.size(); i++) {
                if (!(flag.contains(atual.neighbors.get(i).val))) {
                    flag.add(atual.neighbors.get(i).val);
                    Node novo = new Node(atual.val);
                    pilha.push(atual.neighbors.get(i));
                    ret.add(novo);
                }
            }
            if (!(pilha2.contains(atual))){
                pilha2.push(atual);
            }
        }

        while (!(pilha2.isEmpty())){
            atual = pilha2.pop();
            int index = -1;

            for (int i = 0; i < ret.size(); i++){
                if (ret.get(i).val == atual.val) {
                    index = i;
                    break;
                }
            }

            for (int i = 0; i < atual.neighbors.size(); i++){
                for (int j = 0; j < ret.size(); j++)
                    if (ret.get(j).val == atual.neighbors.get(i).val){
                        ret.get(index).neighbors.add(ret.get(j));
                        break;
                    }
            }
        }

        return ret.get(0);
    }
}
