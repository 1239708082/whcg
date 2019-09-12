package com.ltsk.whcg.utils;

import java.util.ArrayList;
import java.util.List;

import com.ltsk.whcg.entity.TreeNode;

public class TreeBuilder {
	public static List<TreeNode> bulid(List<TreeNode> treeNodes,List<String> role) {
		List<TreeNode> trees = new ArrayList<TreeNode>();

		for (TreeNode treeNode : treeNodes) {
			for (String r : role) {
				if(r.equals(treeNode.getTitle())){
					trees.add(treeNode);
				}
			}

			for (TreeNode it : treeNodes) {
//				System.out.println("ParentTitle="+it.getParentTitle());
//				System.out.println("Title="+treeNode.getTitle());
				if (it.getParentTitle() == treeNode.getTitle()) {
					System.out.println("=========");
					if (treeNode.getChildren() == null) {
						treeNode.setChildren(new ArrayList<TreeNode>());
					}
					treeNode.getChildren().add(it);
				}
			}
		}
		return trees;
	}

	public static void main(String[] args) {
//		TreeNode treeNode1 = new TreeNode("基础数据", "0-5", "jichushuju", "jichushuju2", "");
//		TreeNode treeNode2 = new TreeNode("环境卫生", "0-0", "hjws", "hjws2", "");
//		TreeNode treeNode3 = new TreeNode("市政设施", "0-1", "szss", "szss2", "");
//		TreeNode treeNode11 = new TreeNode("区", "0-5-0", "qu", "qu2", treeNode1);
//		TreeNode treeNode12 = new TreeNode("街", "0-5-1", "jie", "jie2", treeNode1);
//		TreeNode treeNode13 = new TreeNode("社区", "0-5-2", "shequ", "shequ2", treeNode1);
//		TreeNode treeNode14 = new TreeNode("单元网格", "0-5-3-0", "danyuanwangge", "danyuanwangge2", treeNode1);
//		TreeNode treeNode15 = new TreeNode("城市部件", "0-5-4", "citybujian", "citybujian2", treeNode1);
//		TreeNode treeNode21 = new TreeNode("生活垃圾处理", "0-0-0", null, null, treeNode2);
//		TreeNode treeNode211 = new TreeNode("处理厂", "0-0-0-0", "shljclc", "shljclc2", treeNode21);
//		TreeNode treeNode212 = new TreeNode("运输车辆", "0-0-0-2", "shljysc", "shljysc2", treeNode21);
		
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(new TreeNode("基础数据", "0-5", "jichushuju", "jichushuju2"));
		list.add(new TreeNode("环境卫生", "0-0", "hjws", "hjws2"));
		list.add(new TreeNode("市政设施", "0-1", "szss", "szss2"));
		list.add(new TreeNode("区", "0-5-0", "qu", "qu2", "基础数据"));
		list.add(new TreeNode("街", "0-5-1", "jie", "jie2","基础数据"));
		
//		list.add(treeNode11);
//		list.add(treeNode12);
//		list.add(treeNode13);
//		list.add(treeNode14);
//		list.add(treeNode15);
//		list.add(treeNode21);
//		list.add(treeNode211);
//		list.add(treeNode212);
		
		List<String> role=new ArrayList<>();
		role.add("基础数据");
		role.add("环境卫生");
		role.add("市政设施");
		role.add("市容市貌");
		List<TreeNode> trees = TreeBuilder.bulid(list,role);
		for (TreeNode treeNode : trees) {
			System.out.println(treeNode.toString());
		}
	}
}
