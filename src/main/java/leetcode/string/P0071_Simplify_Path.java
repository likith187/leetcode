package leetcode.string;

import java.util.Stack;

public class P0071_Simplify_Path {
    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        Stack stack = new Stack();
        for (String folder: path.split("/")) {
            if (folder.equals(".") || folder.equals("_")) {
                continue;
            } else if (folder.equals("..")) {
                if (!stack.isEmpty())
                    stack.pop();
            } else {
                stack.push(folder);
            }
        }
        String newpath = String.join("/", stack);
        return newpath.startsWith("/") ? newpath : "/" + newpath;
    }
}
