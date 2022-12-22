import java.util.ArrayDeque;

public class SimplifyPath {
    public String simplifyPath(String path) {
        String[] pathArr = path.split("/");
        ArrayDeque<String> deque = new ArrayDeque<>();

        for (String s : pathArr) {
            if ("..".equals(s) && !deque.isEmpty()) {
                deque.removeLast();
            } else if (!"".equals(s) && !"..".equals(s) && !".".equals(s)) {
                deque.add(s);
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append("/");

        while (!deque.isEmpty()) {
            sb.append(deque.poll());
            if (!deque.isEmpty()) {
                sb.append("/");
            }
        }

        return sb.toString();
    }
}
