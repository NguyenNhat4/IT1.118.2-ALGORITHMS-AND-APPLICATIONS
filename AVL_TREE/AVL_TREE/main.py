# main.py

from avl_tree import AVLTree, pre_order

# Example usage
avl_tree = AVLTree()
root = None

# Insert nodes
values = [10,20,30,25,28,27,5,4,3,9,15]
for value in values:
    root = avl_tree.insert(root, value)

# Pre-order traversal
pre_order(root)  # Output will be balanced tree keys in pre-order
