import java.util.*;

public class compression {
    static class HuffmanNode {
        String characters; // Stores all characters in this node's branch
        int frequency;
        HuffmanNode left;
        HuffmanNode right;

        //Leaves
        HuffmanNode(char ch, int frequency) {
            this.characters = String.valueOf(ch);
            this.frequency = frequency;
        }

        //Branches
        HuffmanNode(HuffmanNode left, HuffmanNode right) {
            this.characters = left.characters + right.characters; 
            this.frequency = left.frequency + right.frequency;
            this.left = left;
            this.right = right;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }
    private static String getCodeForChar(HuffmanNode root, char target) {
        StringBuilder code = new StringBuilder();
        HuffmanNode current = root;

        while (current.isLeaf() == false) {
            if (current.left.characters.indexOf(target) != -1) {
                code.append('0');
                current = current.left;
            } else {
                code.append('1');
                current = current.right;
            }
        }

        return code.toString();
    }

    public static void main(String[] args) {
        //Text
        Scanner read = new Scanner(System.in);
        System.out.println("Text:");
        String text = read.nextLine();

        HashMap<Character, Integer> frequencies = new HashMap<>();

        for (char c: text.toCharArray()) {
            frequencies.put(c, frequencies.getOrDefault(c, 0) + 1);
        }
        
        //Frequency sort 
        PriorityQueue<HuffmanNode> priority = new PriorityQueue<>(Comparator.comparingInt(node -> node.frequency));

        for (HashMap.Entry<Character, Integer> entry : frequencies.entrySet()) {
            priority.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        //Build huffmantree
        while (priority.size() > 1) {
            HuffmanNode left = priority.poll();
            HuffmanNode right = priority.poll();

            HuffmanNode parent = new HuffmanNode(left, right);
            priority.add(parent);
        }

        //Build huffman dictionary
        HuffmanNode root = priority.poll();
        HashMap<Character, String> huffmandict = new HashMap<>(); 

        for (char c: text.toCharArray()) {
          huffmandict.put(c, getCodeForChar(root,c));
        }

        StringBuilder encoded = new StringBuilder();

        for (char c: text.toCharArray()) {
          encoded.append(huffmandict.get(c));
        }

        System.out.println("Encoded Text:" + encoded);
        System.out.println("Huffman Dictionary:");

        for (HashMap.Entry<Character, String> entry : huffmandict.entrySet()) {
            System.out.println("`" + entry.getKey() + "'" + " = "  + entry.getValue());
        }
        System.out.println("ASCII Length:" + text.length()*8);
        System.out.println("Naive Length:" + Math.round(text.length() * Math.ceil(Math.log(frequencies.size())/Math.log(2))));
        System.out.println("Huffman Length:" + encoded.length());
    }
}
