

# avl_tree_package/avl_node.py

class AVLNode:
    def __init__(self, key: int) -> None:
        self.key: int = key
        self.height: int = 1
        self.left: 'AVLNode' = None
        self.right: 'AVLNode' = None
