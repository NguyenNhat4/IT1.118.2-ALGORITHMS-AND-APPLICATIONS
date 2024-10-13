# avl_tree_package/avl_tree.py

from avl_node import AVLNode

def pre_order(node: 'AVLNode') -> None:
    if not node:
        return
    print(node.key, end=" ")
    pre_order(node.left)
    pre_order(node.right)
class AVLTree:
    def get_height(self, node: 'AVLNode') -> int:
        return node.height if node else 0

    def get_balance(self, node: 'AVLNode') -> int:
        return self.get_height(node.left) - self.get_height(node.right) if node else 0

    def right_rotate(self, y: 'AVLNode') -> 'AVLNode':
        x = y.left
        T2 = x.right

        # Perform rotation
        x.right = y
        y.left = T2

        # Update heights
        y.height = 1 + max(self.get_height(y.left), self.get_height(y.right))
        x.height = 1 + max(self.get_height(x.left), self.get_height(x.right))

        # Return new root
        return x

    def left_rotate(self, x: 'AVLNode') -> 'AVLNode':
        y = x.right
        T2 = y.left

        # Perform rotation
        y.left = x
        x.right = T2

        # Update heights
        x.height = 1 + max(self.get_height(x.left), self.get_height(x.right))
        y.height = 1 + max(self.get_height(y.left), self.get_height(y.right))

        # Return new root
        return y

    def insert(self, node: 'AVLNode', key: int) -> 'AVLNode':
        if not node:
            return AVLNode(key)

        # 1. Perform normal BST insert
        if key < node.key:
            node.left = self.insert(node.left, key)
        elif key > node.key:
            node.right = self.insert(node.right, key)
        else:
            return node

        # 2. Update height of this ancestor node
        node.height = 1 + max(self.get_height(node.left), self.get_height(node.right))

        # 3. Get the balance factor
        balance = self.get_balance(node)

        # 4. Balance the node if unbalanced
        # Case 1: Left Left
        if balance > 1 and key < node.left.key:
            return self.right_rotate(node)

        # Case 2: Right Right
        if balance < -1 and key > node.right.key:
            return self.left_rotate(node)

        # Case 3: Left Right
        if balance > 1 and key > node.left.key:
            node.left = self.left_rotate(node.left)
            return self.right_rotate(node)

        # Case 4: Right Left
        if balance < -1 and key < node.right.key:
            node.right = self.right_rotate(node.right)
            return self.left_rotate(node)

        return node
