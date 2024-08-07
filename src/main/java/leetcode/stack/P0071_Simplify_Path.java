package leetcode.stack;

import java.util.Stack;

public class P0071_Simplify_Path {
    public String simplifyPath(String path) {
        path = path.replaceAll("/+", "/");
        Stack stack = new Stack();
        for (String folder: path.split("/")) {
            if (folder.equals(".") || folder.equals("_")) {
                continue;
            } else if (folder.equals("..")) {
                stack.pop();
            } else {
                stack.push(folder);
            }
        }
        String newpath = String.join("/", stack);
        return newpath.startsWith("/") ? newpath : "/" + newpath;
    }

    public static void main(String[] args) {
        var obj = new P0071_Simplify_Path();
        System.out.println(obj.simplifyPath("/home/user/Documents/../Pictures"));
    }
}
