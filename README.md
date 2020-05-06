# 个人博客介绍
基于SpringBoot开发的个人博客
所用技术栈：

前端：html+css+javaScript，Semantic-Ui ，jQuery。

后端：SpringBoot，SpringMVC, Spring Data Jpa，Shiro，thymeleaf模板。

数据库：Mysql

开发环境：java1.8 ，IDEA

部署环境：linux（centos7.6）

访问ip：http://129.204.233.29/

# sql文件

CREATE DATABASE  IF NOT EXISTS `blog` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `blog`;
-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: blog
-- ------------------------------------------------------
-- Server version	8.0.18

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (146),(146),(146),(146),(146);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog`
--

DROP TABLE IF EXISTS `t_blog`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog` (
  `id` bigint(20) NOT NULL,
  `appreciation` bit(1) NOT NULL,
  `commentabled` bit(1) NOT NULL,
  `content` longblob,
  `create_time` datetime(6) DEFAULT NULL,
  `first_picture` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `published` bit(1) NOT NULL,
  `recommend` bit(1) NOT NULL,
  `share_statement` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `views` int(11) DEFAULT NULL,
  `type_id` bigint(20) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK8ky5rrsxh01nkhctmo7d48p82` (`user_id`),
  KEY `FK292449gwg5yf7ocdlmswv9w4j` (`type_id`),
  CONSTRAINT `FK292449gwg5yf7ocdlmswv9w4j` FOREIGN KEY (`type_id`) REFERENCES `t_type` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FK8ky5rrsxh01nkhctmo7d48p82` FOREIGN KEY (`user_id`) REFERENCES `t_user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog`
--

LOCK TABLES `t_blog` WRITE;
/*!40000 ALTER TABLE `t_blog` DISABLE KEYS */;
INSERT INTO `t_blog` VALUES (10,_binary '',_binary '',_binary '一、线性表\r\n  1.数组实现\r\n  2.链表\r\n二、栈与队列\r\n三、树与二叉树\r\n  1.树\r\n  2.二叉树基本概念\r\n  3.二叉查找树\r\n  4.平衡二叉树\r\n  5.红黑树\r\n四、图\r\n五、总结\r\n一、线性表\r\n线性表是最常用且最简单的一种数据结构，它是n个数据元素的有限序列。\r\n\r\n实现线性表的方式一般有两种，一种是使用数组存储线性表的元素，即用一组连续的存储单元依次存储线性表的数据元素。另一种是使用链表存储线性表的元素，即用一组任意的存储单元存储线性表的数据元素（存储单元可以是连续的，也可以是不连续的）。\r\n\r\n数组实现\r\n数组是一种大小固定的数据结构，对线性表的所有操作都可以通过数组来实现。虽然数组一旦创建之后，它的大小就无法改变了，但是当数组不能再存储线性表中的新元素时，我们可以创建一个新的大的数组来替换当前数组。这样就可以使用数组实现动态的数据结构。\r\n\r\n代码1 创建一个更大的数组来替换当前数组\r\nint[] oldArray = new int[10];\r\n        \r\nint[] newArray = new int[20];\r\n        \r\nfor (int i = 0; i < oldArray.length; i++) {\r\n    newArray[i] = oldArray[i];\r\n}\r\n\r\n// 也可以使用System.arraycopy方法来实现数组间的复制     \r\n// System.arraycopy(oldArray, 0, newArray, 0, oldArray.length);\r\n        \r\noldArray = newArray;\r\n代码2 在数组位置index上添加元素e\r\n//oldArray 表示当前存储元素的数组\r\n//size 表示当前元素个数\r\npublic void add(int index, int e) {\r\n\r\n    if (index > size || index < 0) {\r\n        System.out.println(\"位置不合法...\");\r\n    }\r\n\r\n    //如果数组已经满了 就扩容\r\n    if (size >= oldArray.length) {\r\n        // 扩容函数可参考代码1\r\n    }\r\n\r\n    for (int i = size - 1; i >= index; i--) {\r\n        oldArray[i + 1] = oldArray[i];\r\n    }\r\n\r\n    //将数组elementData从位置index的所有元素往后移一位\r\n    // System.arraycopy(oldArray, index, oldArray, index + 1,size - index);\r\n\r\n    oldArray[index] = e;\r\n\r\n    size++;\r\n}\r\n上面简单写出了数组实现线性表的两个典型函数，具体我们可以参考Java里面的ArrayList集合类的源码。数组实现的线性表优点在于可以通过下标来访问或者修改元素，比较高效，主要缺点在于插入和删除的花费开销较大，比如当在第一个位置前插入一个元素，那么首先要把所有的元素往后移动一个位置。为了提高在任意位置添加或者删除元素的效率，可以采用链式结构来实现线性表。\r\n\r\n链表\r\n链表是一种物理存储单元上非连续、非顺序的存储结构，数据元素的逻辑顺序是通过链表中的指针链接次序实现的。链表由一系列节点组成，这些节点不必在内存中相连。每个节点由数据部分Data和链部分Next，Next指向下一个节点，这样当添加或者删除时，只需要改变相关节点的Next的指向，效率很高。\r\n\r\n \r\n\r\n单链表的结构\r\n下面主要用代码来展示链表的一些基本操作，需要注意的是，这里主要是以单链表为例，暂时不考虑双链表和循环链表。\r\n\r\n代码3 链表的节点\r\nclass Node<E> {\r\n\r\n    E item;\r\n    Node<E> next;\r\n    \r\n    //构造函数\r\n    Node(E element) {\r\n       this.item = element;\r\n       this.next = null;\r\n   }\r\n}\r\n代码4 定义好节点后，使用前一般是对头节点和尾节点进行初始化\r\n//头节点和尾节点都为空 链表为空\r\nNode<E> head = null;\r\nNode<E> tail = null;\r\n代码5 空链表创建一个新节点\r\n//创建一个新的节点 并让head指向此节点\r\nhead = new Node(\"nodedata1\");\r\n\r\n//让尾节点也指向此节点\r\ntail = head;\r\n代码6 链表追加一个节点\r\n//创建新节点 同时和最后一个节点连接起来\r\ntail.next = new Node(\"node1data2\");\r\n\r\n//尾节点指向新的节点\r\ntail = tail.next;\r\n代码7 顺序遍历链表\r\nNode<String> current = head;\r\nwhile (current != null) {\r\n    System.out.println(current.item);\r\n    current = current.next;\r\n}\r\n代码8 倒序遍历链表\r\nstatic void printListRev(Node<String> head) {\r\n//倒序遍历链表主要用了递归的思想\r\n    if (head != null) {\r\n        printListRev(head.next);\r\n        System.out.println(head.item);\r\n    }\r\n}\r\n代码 单链表反转\r\n//单链表反转 主要是逐一改变两个节点间的链接关系来完成\r\nstatic Node<String> revList(Node<String> head) {\r\n\r\n    if (head == null) {\r\n        return null;\r\n    }\r\n\r\n    Node<String> nodeResult = null;\r\n\r\n    Node<String> nodePre = null;\r\n    Node<String> current = head;\r\n\r\n    while (current != null) {\r\n\r\n        Node<String> nodeNext = current.next;\r\n\r\n        if (nodeNext == null) {\r\n            nodeResult = current;\r\n        }\r\n\r\n        current.next = nodePre;\r\n        nodePre = current;\r\n        current = nodeNext;\r\n    }\r\n\r\n    return nodeResult;\r\n}\r\n上面的几段代码主要展示了链表的几个基本操作，还有很多像获取指定元素，移除元素等操作大家可以自己完成，写这些代码的时候一定要理清节点之间关系，这样才不容易出错。\r\n\r\n链表的实现还有其它的方式，常见的有循环单链表，双向链表，循环双向链表。 循环单链表 主要是链表的最后一个节点指向第一个节点，整体构成一个链环。 双向链表 主要是节点中包含两个指针部分，一个指向前驱元，一个指向后继元，JDK中LinkedList集合类的实现就是双向链表。** 循环双向链表** 是最后一个节点指向第一个节点。\r\n\r\n二、栈与队列\r\n栈和队列也是比较常见的数据结构，它们是比较特殊的线性表，因为对于栈来说，访问、插入和删除元素只能在栈顶进行，对于队列来说，元素只能从队列尾插入，从队列头访问和删除。\r\n\r\n栈\r\n\r\n栈是限制插入和删除只能在一个位置上进行的表，该位置是表的末端，叫作栈顶，对栈的基本操作有push(进栈)和pop(出栈)，前者相当于插入，后者相当于删除最后一个元素。栈有时又叫作LIFO(Last In First Out)表，即后进先出。\r\n\r\n \r\n\r\n栈的模型\r\n下面我们看一道经典题目，加深对栈的理解。\r\n\r\n \r\n\r\n关于栈的一道经典题目\r\n上图中的答案是C，其中的原理可以好好想一想。\r\n\r\n因为栈也是一个表，所以任何实现表的方法都能实现栈。我们打开JDK中的类Stack的源码，可以看到它就是继承类Vector的。当然，Stack是Java2前的容器类，现在我们可以使用LinkedList来进行栈的所有操作。\r\n\r\n队列\r\n\r\n队列是一种特殊的线性表，特殊之处在于它只允许在表的前端（front）进行删除操作，而在表的后端（rear）进行插入操作，和栈一样，队列是一种操作受限制的线性表。进行插入操作的端称为队尾，进行删除操作的端称为队头。\r\n\r\n \r\n\r\n队列示意图\r\n我们可以使用链表来实现队列，下面代码简单展示了利用LinkedList来实现队列类。\r\n\r\n代码9 简单实现队列类\r\npublic class MyQueue<E> {\r\n\r\n    private LinkedList<E> list = new LinkedList<>();\r\n\r\n    // 入队\r\n    public void enqueue(E e) {\r\n        list.addLast(e);\r\n    }\r\n\r\n    // 出队\r\n    public E dequeue() {\r\n        return list.removeFirst();\r\n    }\r\n}\r\n普通的队列是一种先进先出的数据结构，而优先队列中，元素都被赋予优先级。当访问元素的时候，具有最高优先级的元素最先被删除。优先队列在生活中的应用还是比较多的，比如医院的急症室为病人赋予优先级，具有最高优先级的病人最先得到治疗。在Java集合框架中，类PriorityQueue就是优先队列的实现类，具体大家可以去阅读源码。\r\n\r\n三、树与二叉树\r\n树型结构是一类非常重要的非线性数据结构，其中以树和二叉树最为常用。在介绍二叉树之前，我们先简单了解一下树的相关内容。\r\n\r\n树\r\n\r\n** 树 是由n（n>=1）个有限节点组成一个具有层次关系的集合。它具有以下特点：每个节点有零个或多个子节点；没有父节点的节点称为 根 节点；每一个非根节点有且只有一个 父节点 **；除了根节点外，每个子节点可以分为多个不相交的子树。\r\n\r\n \r\n\r\n树的结构\r\n二叉树基本概念\r\n\r\n定义\r\n二叉树是每个节点最多有两棵子树的树结构。通常子树被称作“左子树”和“右子树”。二叉树常被用于实现二叉查找树和二叉堆。\r\n\r\n相关性质\r\n二叉树的每个结点至多只有2棵子树(不存在度大于2的结点)，二叉树的子树有左右之分，次序不能颠倒。\r\n\r\n二叉树的第i层至多有2(i-1)个结点；深度为k的二叉树至多有2k-1个结点。\r\n\r\n一棵深度为k，且有2^k-1个节点的二叉树称之为** 满二叉树 **；\r\n\r\n深度为k，有n个节点的二叉树，当且仅当其每一个节点都与深度为k的满二叉树中，序号为1至n的节点对应时，称之为** 完全二叉树 **。\r\n\r\n \r\n\r\n \r\n三种遍历方法\r\n在二叉树的一些应用中，常常要求在树中查找具有某种特征的节点，或者对树中全部节点进行某种处理，这就涉及到二叉树的遍历。二叉树主要是由3个基本单元组成，根节点、左子树和右子树。如果限定先左后右，那么根据这三个部分遍历的顺序不同，可以分为先序遍历、中序遍历和后续遍历三种。\r\n\r\n(1) 先序遍历 若二叉树为空，则空操作，否则先访问根节点，再先序遍历左子树，最后先序遍历右子树。 (2) 中序遍历 若二叉树为空，则空操作，否则先中序遍历左子树，再访问根节点，最后中序遍历右子树。(3) 后序遍历 若二叉树为空，则空操作，否则先后序遍历左子树访问根节点，再后序遍历右子树，最后访问根节点。\r\n\r\n \r\n\r\n给定二叉树写出三种遍历结果\r\n树和二叉树的区别\r\n(1) 二叉树每个节点最多有2个子节点，树则无限制。 (2) 二叉树中节点的子树分为左子树和右子树，即使某节点只有一棵子树，也要指明该子树是左子树还是右子树，即二叉树是有序的。 (3) 树决不能为空，它至少有一个节点，而一棵二叉树可以是空的。\r\n\r\n上面我们主要对二叉树的相关概念进行了介绍，下面我们将从二叉查找树开始，介绍二叉树的几种常见类型，同时将之前的理论部分用代码实现出来。\r\n\r\n二叉查找树\r\n\r\n定义\r\n二叉查找树就是二叉排序树，也叫二叉搜索树。二叉查找树或者是一棵空树，或者是具有下列性质的二叉树： (1) 若左子树不空，则左子树上所有结点的值均小于它的根结点的值；(2) 若右子树不空，则右子树上所有结点的值均大于它的根结点的值；(3) 左、右子树也分别为二叉排序树；(4) 没有键值相等的结点。\r\n\r\n \r\n\r\n典型的二叉查找树的构建过程\r\n性能分析\r\n对于二叉查找树来说，当给定值相同但顺序不同时，所构建的二叉查找树形态是不同的，下面看一个例子。\r\n\r\n \r\n\r\n不同形态平衡二叉树的ASL不同\r\n可以看到，含有n个节点的二叉查找树的平均查找长度和树的形态有关。最坏情况下，当先后插入的关键字有序时，构成的二叉查找树蜕变为单支树，树的深度为n，其平均查找长度(n+1)/2(和顺序查找相同），最好的情况是二叉查找树的形态和折半查找的判定树相同，其平均查找长度和log2(n)成正比。平均情况下，二叉查找树的平均查找长度和logn是等数量级的，所以为了获得更好的性能，通常在二叉查找树的构建过程需要进行“平衡化处理”，之后我们将介绍平衡二叉树和红黑树，这些均可以使查找树的高度为O(log(n))。\r\n\r\n代码10 二叉树的节点\r\n\r\nclass TreeNode<E> {\r\n\r\n    E element;\r\n    TreeNode<E> left;\r\n    TreeNode<E> right;\r\n\r\n    public TreeNode(E e) {\r\n        element = e;\r\n    }\r\n}\r\n二叉查找树的三种遍历都可以直接用递归的方法来实现：\r\n\r\n代码12 先序遍历\r\nprotected void preorder(TreeNode<E> root) {\r\n\r\n    if (root == null)\r\n        return;\r\n\r\n    System.out.println(root.element + \" \");\r\n\r\n    preorder(root.left);\r\n\r\n    preorder(root.right);\r\n}\r\n代码13 中序遍历\r\nprotected void inorder(TreeNode<E> root) {\r\n\r\n    if (root == null)\r\n        return;\r\n\r\n    inorder(root.left);\r\n\r\n    System.out.println(root.element + \" \");\r\n\r\n    inorder(root.right);\r\n}\r\n代码14 后序遍历\r\nprotected void postorder(TreeNode<E> root) {\r\n\r\n    if (root == null)\r\n        return;\r\n\r\n    postorder(root.left);\r\n\r\n    postorder(root.right);\r\n\r\n    System.out.println(root.element + \" \");\r\n}\r\n代码15 二叉查找树的简单实现\r\n/**\r\n * @author JackalTsc\r\n */\r\npublic class MyBinSearchTree<E extends Comparable<E>> {\r\n\r\n    // 根\r\n    private TreeNode<E> root;\r\n\r\n    // 默认构造函数\r\n    public MyBinSearchTree() {\r\n    }\r\n\r\n    // 二叉查找树的搜索\r\n    public boolean search(E e) {\r\n\r\n        TreeNode<E> current = root;\r\n\r\n        while (current != null) {\r\n\r\n            if (e.compareTo(current.element) < 0) {\r\n                current = current.left;\r\n            } else if (e.compareTo(current.element) > 0) {\r\n                current = current.right;\r\n            } else {\r\n                return true;\r\n            }\r\n        }\r\n\r\n        return false;\r\n    }\r\n\r\n    // 二叉查找树的插入\r\n    public boolean insert(E e) {\r\n\r\n        // 如果之前是空二叉树 插入的元素就作为根节点\r\n        if (root == null) {\r\n            root = createNewNode(e);\r\n        } else {\r\n            // 否则就从根节点开始遍历 直到找到合适的父节点\r\n            TreeNode<E> parent = null;\r\n            TreeNode<E> current = root;\r\n            while (current != null) {\r\n                if (e.compareTo(current.element) < 0) {\r\n                    parent = current;\r\n                    current = current.left;\r\n                } else if (e.compareTo(current.element) > 0) {\r\n                    parent = current;\r\n                    current = current.right;\r\n                } else {\r\n                    return false;\r\n                }\r\n            }\r\n            // 插入\r\n            if (e.compareTo(parent.element) < 0) {\r\n                parent.left = createNewNode(e);\r\n            } else {\r\n                parent.right = createNewNode(e);\r\n            }\r\n        }\r\n        return true;\r\n    }\r\n\r\n    // 创建新的节点\r\n    protected TreeNode<E> createNewNode(E e) {\r\n        return new TreeNode(e);\r\n    }\r\n\r\n}\r\n\r\n// 二叉树的节点\r\nclass TreeNode<E extends Comparable<E>> {\r\n\r\n    E element;\r\n    TreeNode<E> left;\r\n    TreeNode<E> right;\r\n\r\n    public TreeNode(E e) {\r\n        element = e;\r\n    }\r\n}\r\n\r\n上面的代码15主要展示了一个自己实现的简单的二叉查找树，其中包括了几个常见的操作，当然更多的操作还是需要大家自己去完成。因为在二叉查找树中删除节点的操作比较复杂，所以下面我详细介绍一下这里。\r\n\r\n二叉查找树中删除节点分析\r\n要在二叉查找树中删除一个元素，首先需要定位包含该元素的节点，以及它的父节点。假设current指向二叉查找树中包含该元素的节点，而parent指向current节点的父节点，current节点可能是parent节点的左孩子，也可能是右孩子。这里需要考虑两种情况：\r\n\r\ncurrent节点没有左孩子，那么只需要将patent节点和current节点的右孩子相连。\r\ncurrent节点有一个左孩子，假设rightMost指向包含current节点的左子树中最大元素的节点，而parentOfRightMost指向rightMost节点的父节点。那么先使用rightMost节点中的元素值替换current节点中的元素值，将parentOfRightMost节点和rightMost节点的左孩子相连，然后删除rightMost节点。\r\n    // 二叉搜索树删除节点\r\n    public boolean delete(E e) {\r\n\r\n        TreeNode<E> parent = null;\r\n        TreeNode<E> current = root;\r\n\r\n        // 找到要删除的节点的位置\r\n        while (current != null) {\r\n            if (e.compareTo(current.element) < 0) {\r\n                parent = current;\r\n                current = current.left;\r\n            } else if (e.compareTo(current.element) > 0) {\r\n                parent = current;\r\n                current = current.right;\r\n            } else {\r\n                break;\r\n            }\r\n        }\r\n\r\n        // 没找到要删除的节点\r\n        if (current == null) {\r\n            return false;\r\n        }\r\n\r\n        // 考虑第一种情况\r\n        if (current.left == null) {\r\n            if (parent == null) {\r\n                root = current.right;\r\n            } else {\r\n                if (e.compareTo(parent.element) < 0) {\r\n                    parent.left = current.right;\r\n                } else {\r\n                    parent.right = current.right;\r\n                }\r\n            }\r\n        } else { // 考虑第二种情况\r\n            TreeNode<E> parentOfRightMost = current;\r\n            TreeNode<E> rightMost = current.left;\r\n            // 找到左子树中最大的元素节点\r\n            while (rightMost.right != null) {\r\n                parentOfRightMost = rightMost;\r\n                rightMost = rightMost.right;\r\n            }\r\n\r\n            // 替换\r\n            current.element = rightMost.element;\r\n\r\n            // parentOfRightMost和rightMost左孩子相连\r\n            if (parentOfRightMost.right == rightMost) {\r\n                parentOfRightMost.right = rightMost.left;\r\n            } else {\r\n                parentOfRightMost.left = rightMost.left;\r\n            }\r\n        }\r\n\r\n        return true;\r\n    }\r\n平衡二叉树\r\n\r\n平衡二叉树又称AVL树，它或者是一棵空树，或者是具有下列性质的二叉树：它的左子树和右子树都是平衡二叉树，且左子树和右子树的深度之差的绝对值不超过1。\r\n\r\n \r\n\r\n平衡二叉树\r\nAVL树是最先发明的自平衡二叉查找树算法。在AVL中任何节点的两个儿子子树的高度最大差别为1，所以它也被称为高度平衡树，n个结点的AVL树最大深度约1.44log2n。查找、插入和删除在平均和最坏情况下都是O（log n）。增加和删除可能需要通过一次或多次树旋转来重新平衡这个树。\r\n\r\n红黑树\r\n\r\n红黑树是平衡二叉树的一种，它保证在最坏情况下基本动态集合操作的事件复杂度为O(log n)。红黑树和平衡二叉树区别如下：(1) 红黑树放弃了追求完全平衡，追求大致平衡，在与平衡二叉树的时间复杂度相差不大的情况下，保证每次插入最多只需要三次旋转就能达到平衡，实现起来也更为简单。(2) 平衡二叉树追求绝对平衡，条件比较苛刻，实现起来比较麻烦，每次插入新节点之后需要旋转的次数不能预知。点击查看更多\r\n\r\n四、图\r\n简介\r\n图是一种较线性表和树更为复杂的数据结构，在线性表中，数据元素之间仅有线性关系，在树形结构中，数据元素之间有着明显的层次关系，而在图形结构中，节点之间的关系可以是任意的，图中任意两个数据元素之间都可能相关。图的应用相当广泛，特别是近年来的迅速发展，已经渗入到诸如语言学、逻辑学、物理、化学、电讯工程、计算机科学以及数学的其他分支中。\r\n\r\n\r\n\r\n','2020-03-12 04:30:27.670000','https://picsum.photos/800/450/?blur=2','转载',_binary '',_binary '',_binary '','数据结构与算法','2020-04-10 11:46:53.426000',64,3,1,'数据结构与算法简单解析'),(12,_binary '',_binary '',_binary '一、关于 Typo.css\r\np { color: red }\r\np { color: red }\r\nTypo.css 的目的是，在一致化浏览器排版效果的同时，构建最适合中文阅读的网页排版。\r\n\r\n现状和如何去做：\r\n排版是一个麻烦的问题 # 附录一，需要精心设计，而这个设计却是常被视觉设计师所忽略的。前端工程师更常看到这样的问题，但不便变更。因为在多个 OS 中的不同浏览器渲染不同，改动需要多的时间做回归测试，所以改变变得更困难。而像我们一般使用的 Yahoo、Eric Meyer 和 Alice base.css 中采用的 Reset 都没有很好地考虑中文排版。Typo.css 要做的就是解决中文排版的问题。\r\n\r\nTypo.css 测试于如下平台：\r\n\r\nOS/浏览器	Firefox	Chrome	Safari	Opera	IE9	IE8	IE7	IE6\r\nOS X	✔	✔	✔	✔	-	-	-	-\r\nWin 7	✔	✔	✔	✔	✔	✔	✔	-\r\nWin XP	✔	✔	✔	✔	-	✔	✔	✔\r\nUbuntu	✔	✔	-	✔	-	-	-	-\r\n中文排版的重点和难点\r\n在中文排版中，HTML4 的很多标准在语义在都有照顾到。但从视觉效果上，却很难利用单独的 CSS 来实现，像着重号（例：这里强调一下）。在 HTML4 中，专名号标签（<u>）已经被放弃，而 HTML5 被重新提起。Typo.css 也根据实际情况提供相应的方案。我们重要要注意的两点是：\r\n\r\n语义：语义对应的用法和样式是否与中文排版一致\r\n表现：在各浏览器中的字体、大小和缩放是否如排版预期\r\n对于这些，Typo.css 排版项目的中文偏重注意点，都添加在附录中，详见：\r\n\r\n附录一：Typo.css 排版偏重点\r\n目前已有像百姓网等全面使用 Typo.css 的项目，测试平台的覆盖，特别是在移动端上还没有覆盖完主流平台，希望有能力的同学能加入测试行列，或者加入到 Typo.css 的开发。加入方法：参与 Typo.css 开发。如有批评、建议和意见，也随时欢迎给在 Github 直接提 issues，或给我发邮件。\r\n\r\n二、排版实例：\r\n提供2个排版实例，第一个中文实例来自于来自于张燕婴的《论语》，由于古文排版涉及到的元素比较多，所以采用《论语》中《学而》的第一篇作为排版实例介绍；第2个来自到经典的 Lorem Ipsum，并加入了一些代码和列表等比较具有代表性的排版元素。\r\n\r\n例1：论语学而篇第一\r\n作者：孔子（ 前551年9月28日－前479年4月11日 ）\r\n\r\n本篇引语\r\n《学而》是《论语》第一篇的篇名。《论语》中各篇一般都是以第一章的前二三个字作为该篇的篇名。《学而》一篇包括16章，内容涉及诸多方面。其中重点是「吾日三省吾身」；「节用而爱人，使民以时」；「礼之用，和为贵」以及仁、孝、信等道德范畴。\r\n\r\n原文\r\n子曰：「学而时习之，不亦说乎？有朋自远方来，不亦乐乎？人不知，而不愠，不亦君子乎？」\r\n\r\n译文\r\n孔子说：「学了又时常温习和练习，不是很愉快吗？有志同道合的人从远方来，不是很令人高兴的吗？人家不了解我，我也不怨恨、恼怒，不也是一个有德的君子吗？」\r\n\r\n评析\r\n宋代著名学者朱熹对此章评价极高，说它是「入道之门，积德之基」。本章这三句话是人们非常熟悉的。历来的解释都是：学了以后，又时常温习和练习，不也高兴吗等等。三句话，一句一个意思，前后句子也没有什么连贯性。但也有人认为这样解释不符合原义，指出这里的「学」不是指学习，而是指学说或主张；「时」不能解为时常，而是时代或社会的意思，「习」不是温习，而是使用，引申为采用。而且，这三句话不是孤立的，而是前后相互连贯的。这三句的意思是：自己的学说，要是被社会采用了，那就太高兴了；退一步说，要是没有被社会所采用，可是很多朋友赞同我的学说，纷纷到我这里来讨论问题，我也感到快乐；再退一步说，即使社会不采用，人们也不理解我，我也不怨恨，这样做，不也就是君子吗？（见《齐鲁学刊》1986年第6期文）这种解释可以自圆其说，而且也有一定的道理，供读者在理解本章内容时参考。\r\n\r\n此外，在对「人不知，而不愠」一句的解释中，也有人认为，「人不知」的后面没有宾语，人家不知道什么呢？当时因为孔子有说话的特定环境，他不需要说出知道什么，别人就可以理解了，却给后人留下一个谜。有人说，这一句是接上一句说的，从远方来的朋友向我求教，我告诉他，他还不懂，我却不怨恨。这样，「人不知」就是「人家不知道我所讲述的」了。这样的解释似乎有些牵强。\r\n\r\n总之，本章提出以学习为乐事，做到人不知而不愠，反映出孔子学而不厌、诲人不倦、注重修养、严格要求自己的主张。这些思想主张在《论语》书中多处可见，有助于对第一章内容的深入了解。\r\n\r\n例2：英文排版\r\nLorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.\r\n\r\nLorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.\r\nThe standard Lorem Ipsum passage, used since the 1500s\r\n\"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.\"\r\n\r\nSection 1.10.32 of \"de Finibus Bonorum et Malorum\", written by Cicero in 45 BC\r\n\"Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?\"\r\n\r\nList style in action\r\nIf you wish to succeed, you should use persistence as your good friend, experience as your reference, prudence as your brother and hope as your sentry.\r\n如果你希望成功，当以恒心为良友，以经验为参谋，以谨慎为兄弟，以希望为哨兵。\r\n\r\nSometimes one pays most for the things one gets for nothing.\r\n有时候一个人为不花钱得到的东西付出的代价最高。\r\n\r\nOnly those who have the patience to do simple things perfectly ever acquire the skill to do difficult things easily.\r\n只有有耐心圆满完成简单工作的人，才能够轻而易举的完成困难的事。\r\n\r\nYou may want to create a perfect <hr /> line, despite the fact that there will never have one\r\nLa Racheforcauld said: \"Few things are impossible in themselves; and it is often for want of will, rather than of means, that man fails to succeed\". You just need to follow the browser\'s behavior, and set a right margin to it。it will works nice as the demo you\'re watching now. The following code is the best way to render typo in Chinese:\r\n\r\n\r\n/* 标题应该更贴紧内容，并与其他块区分，margin 值要相应做优化 */\r\nh1,h2,h3,h4,h5,h6 {\r\n    line-height:1;font-family:Arial,sans-serif;margin:1.4em 0 0.8em;\r\n}\r\nh1{font-size:1.8em;}\r\nh2{font-size:1.6em;}\r\nh3{font-size:1.4em;}\r\nh4{font-size:1.2em;}\r\nh5,h6{font-size:1em;}\r\n\r\n/* 现代排版：保证块/段落之间的空白隔行 */\r\n.typo p, .typo pre, .typo ul, .typo ol, .typo dl, .typo form, .typo hr {\r\n    margin:1em 0 0.6em;\r\n}\r\n三、附录\r\n1、Typo.css 排版偏重点\r\n类型	语义	标签	注意点\r\n基础标签	标题	h1 ～ h6	全局不强制大小，.typo 中标题与其对应的内容应紧贴，并且有相应的大小设置\r\n上、下标	sup/sub	保持与 MicroSoft Office Word 等程序的日常排版一致\r\n引用	blockquote	显示/嵌套样式\r\n缩写	abbr	是否都有下划线，鼠标 hover 是否为帮助手势\r\n分割线	hr	显示的 padding 和 margin正确\r\n列表	ul/ol/dl	在全局没有 list-style，在 .typo 中对齐正确\r\n定义列表	dl	全局 padding 和 margin为0， .typo 中对齐正确\r\n选项	input[type=radio[, checkbox]]	与其他 form 元素排版时是否居中\r\n斜体	i	只设置一种斜体，让 em 和 cite 显示为正体\r\n强调	em	在全局显示正体，在 .typo 中显示与 b 和 strong 的样式一致，为粗体\r\n加强	strong/b	显示为粗体\r\n标记	mark	类似荧光笔\r\n印刷	small	保持为正确字体的 80% 大小，颜色设置为浅灰色\r\n表格	table	全局不显示线条，在 table 中显示表格外框，并且表头有浅灰背景\r\n代码	pre/code	字体使用 courier 系字体，保持与 serif 有比较一致的显示效果\r\n特殊符号	着重号	在文字下加点	在支持 :after 和 :before 的浏览器可以做渐进增强实现\r\n专名号	林建锋	专名号，有下划线，使用 u 或都 .typo-u 类\r\n破折号	——	保持一划，而非两划\r\n人民币	¥	使用两平等线的符号，或者 HTML 实体符号 &yen;\r\n删除符	已删除（deleted）	一致化各浏览器显示，中英混排正确\r\n加强类	专名号	.typo-u	由于 u 被 HTML4 放弃，在向后兼容上推荐使用 .typo-u\r\n着重符	.typo-em	利用 :after 和 :before 实现着重符\r\n清除浮动	.clearfix	与一般 CSS Reset 保持一对致 API\r\n注意点	（1）中英文混排行高/行距\r\n（2）上下标在 IE 中显示效果\r\n（3）块/段落分割空白是否符合设计原则\r\n（4）input 多余空间问题\r\n（5）默认字体色彩，目前采用 #333 在各种浏览显示比较好\r\n2、开源许可','2020-03-12 05:47:17.224000','https://picsum.photos/800/450','转载',_binary '',_binary '',_binary '','关于刻意练习的清单','2020-04-10 11:46:11.273000',48,3,1,'一、关于 Typo.css\r\np { color: red }\r\np { color: red }\r\nTypo.css 的目的是，在一致化浏览器排版效果的同时，构建最适合中文阅读的网页排版。\r\n'),(30,_binary '',_binary '',_binary '1. 依次选择 File ---> Settings ---> Version Control ---> Git \r\n在 Path to Git executable 中选择自己安装的git的路径，然后可以点击右边的Test测试，出现git的版本表示成功，如下图1所示。\r\n2. 在Version Control中选择Github 点击右上方的加号，在弹出的界面中添加自己的github账号和密码，如下图2所示，显示出自己的github账号表示成功。\r\n3. 在idea上方依次选择 VCS ---> Import into Version Control ---> Create Git Repository , 如图3所示，点击 Create Git Repository,出现如下图3所示\r\n4.在第3步后弹出的界面中选择本地要提交的项目的路径。如下图4所示。\r\n5. 在弹出的 Git init 界面中点击 Yes 。\r\n6. 右击项目选择 Git ---> Add\r\n7. 右击项目选择 Git ---> Commit Directory ，将该项目提交到本地仓库，如下图5所示。\r\n8. 在弹出的 Commit Changes 界面中输入自己对提交内容的描述，如下图6所示，点击commit,将代码提交到本地仓库完成。\r\n9. 将该项目 push (上传)到新建的远程仓库中，(创建远程仓库步骤如上述所示)，如下图7所示。\r\n10. 在弹出的界面中点击 Define remote，URL选择远程仓库的URL即可，选择OK，如果出现自己对提交内容的描述，点击对提交内容的描述，(如下图8所示)，选择push，稍等片刻，idea会提交项目 push successful ,项目上传成功,在github中可以看到提交内容，如下图9所示。','2020-03-17 08:32:26.561000','https://picsum.photos/800/450','原创',_binary '',_binary '',_binary '','idea上传github','2020-04-10 14:03:08.204000',148,3,1,'上传git');
/*!40000 ALTER TABLE `t_blog` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_blog_tags`
--

DROP TABLE IF EXISTS `t_blog_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_blog_tags` (
  `blogs_id` bigint(20) DEFAULT NULL,
  `tags_id` bigint(20) DEFAULT NULL,
  KEY `FKh4pacwjwofrugxa9hpwaxg6mr` (`blogs_id`),
  KEY `FK5feau0gb4lq47fdb03uboswm8` (`tags_id`),
  CONSTRAINT `FK5feau0gb4lq47fdb03uboswm8` FOREIGN KEY (`tags_id`) REFERENCES `t_tag` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKh4pacwjwofrugxa9hpwaxg6mr` FOREIGN KEY (`blogs_id`) REFERENCES `t_blog` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_blog_tags`
--

LOCK TABLES `t_blog_tags` WRITE;
/*!40000 ALTER TABLE `t_blog_tags` DISABLE KEYS */;
INSERT INTO `t_blog_tags` VALUES (12,13),(30,13);
/*!40000 ALTER TABLE `t_blog_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_comment`
--

DROP TABLE IF EXISTS `t_comment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_comment` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `content` varchar(255) NOT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) NOT NULL,
  `nickname` varchar(255) NOT NULL,
  `blog_id` bigint(20) DEFAULT NULL,
  `parent_comment_id` bigint(20) DEFAULT NULL,
  `admin_comment` bit(1) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK4jj284r3pb7japogvo6h72q95` (`parent_comment_id`),
  KEY `FKke3uogd04j4jx316m1p51e05u` (`blog_id`),
  CONSTRAINT `FK4jj284r3pb7japogvo6h72q95` FOREIGN KEY (`parent_comment_id`) REFERENCES `t_comment` (`id`) ON DELETE CASCADE,
  CONSTRAINT `FKke3uogd04j4jx316m1p51e05u` FOREIGN KEY (`blog_id`) REFERENCES `t_blog` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_comment`
--

LOCK TABLES `t_comment` WRITE;
/*!40000 ALTER TABLE `t_comment` DISABLE KEYS */;
INSERT INTO `t_comment` VALUES (133,'https://unsplash.it/100/100?image=1005','123','2020-04-19 04:59:22.191000','1281443565@qq.com','王小伟',10,NULL,_binary '');
/*!40000 ALTER TABLE `t_comment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_tag`
--

DROP TABLE IF EXISTS `t_tag`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_tag` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_tag`
--

LOCK TABLES `t_tag` WRITE;
/*!40000 ALTER TABLE `t_tag` DISABLE KEYS */;
INSERT INTO `t_tag` VALUES (13,'方法论'),(17,'linux'),(35,'服务器');
/*!40000 ALTER TABLE `t_tag` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_type`
--

DROP TABLE IF EXISTS `t_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_type` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_type`
--

LOCK TABLES `t_type` WRITE;
/*!40000 ALTER TABLE `t_type` DISABLE KEYS */;
INSERT INTO `t_type` VALUES (3,'数据结构与算法');
/*!40000 ALTER TABLE `t_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_user`
--

DROP TABLE IF EXISTS `t_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `t_user` (
  `id` bigint(20) NOT NULL,
  `avatar` varchar(255) NOT NULL,
  `create_time` datetime(6) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nickname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `type` int(11) DEFAULT NULL,
  `update_time` datetime(6) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_user`
--

LOCK TABLES `t_user` WRITE;
/*!40000 ALTER TABLE `t_user` DISABLE KEYS */;
INSERT INTO `t_user` VALUES (1,'https://unsplash.it/100/100?image=1005','2020-03-06 00:00:00.000000','1281443565@qq.com','王小伟','9fc3fd8a614729528c35a2a3a5fdb5ed',1,'2020-03-06 00:00:00.000000','wxw');
/*!40000 ALTER TABLE `t_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-05-06  9:06:52





