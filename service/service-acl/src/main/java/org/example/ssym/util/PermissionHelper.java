package org.example.ssym.util;

import com.ssym.model.acl.Permission;

import java.util.ArrayList;
import java.util.List;

/// 把节点 处理为树形
// 叶子节点加一 添加children
public class PermissionHelper {
    public static List<Permission> buildPermission(List<Permission> list) {
        List<Permission> trees = new ArrayList<>();
        for (Permission permission : list) {
            if (permission.getPid() == 0) {
                permission.setLevel(1);
                trees.add(findChildren(permission, list));
            }
        }
        return trees;
    }

    private static Permission findChildren(Permission permission, List<Permission> list) {
        permission.setChildren(new ArrayList<>());
        for (Permission it : list) {
            if (permission.getPid().longValue() == it.getPid().longValue()) {
                int level = permission.getLevel() + 1;
                it.setLevel(level);
                //
                permission.getChildren().add(findChildren(it, list));
            }
        }
        return permission;
    }
}
