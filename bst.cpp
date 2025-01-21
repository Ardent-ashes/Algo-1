#include<bits/stdc++.h>
using namespace std;


struct tree{
    struct node{
        int data;
        node* left;
        node* right;
    };
    node* root=NULL;

    

    void add(int val) {
        node* a= new node();
        a->data=val;

        if(!root){
            root=a;
            return;
        }
        node* prev=NULL;
        node* temp=root;

        while(temp)
        {
            if(temp->data>val)
            {
                prev=temp;
                temp=temp->left;
            }
            else if(temp->data<val)
            {
                prev=temp;
                temp=temp->right;
            }
        }
        if(prev->data>val)
        {
            prev->left=a;
        }
        else
        prev->right=a;

      
    }

node* search(node* node, int val)
{
    if(node==NULL||node->data==val)
    return node;

    if(node->data<val)
    return search(node->right,val);

    return search(node->left,val);
}

node* deletion(node* a, int val) {
    if (a == NULL) return a;

    // If the value to be deleted is smaller, move to the left subtree
    if (a->data > val) {
        a->left = deletion(a->left, val);
        return a;
    }
    // If the value to be deleted is greater, move to the right subtree
    else if (a->data < val) {
        a->right = deletion(a->right, val);
        return a;
    }

    // Node found, perform deletion
    // Case 1: Node with only one child or no child
    if (a->left == NULL) {
        node* temp = a->right;
        delete a;
        return temp;
    }
    else if (a->right == NULL) {
        node* temp = a->left;
        delete a;
        return temp;
    }

    // Case 2: Node with two children
    // Find successor (smallest node in the right subtree)
    node* succParent = a;
    node* succ = a->right;
    while (succ->left != NULL) {
        succParent = succ;
        succ = succ->left;
    }

    // Copy successor's data to this node
    a->data = succ->data;

    // Recursively delete the successor node
    a->right = deletion(a->right, succ->data);

    return a;
}


void inorderTraversal(node* node) {
        if (node == NULL)
        return;

        inorderTraversal(node->left);
        cout <<"->"<< node->data;        
        inorderTraversal(node->right);
       
}
// Preorder traversal
void preorderTraversal(node* node) {
  if (node == NULL)
    return;

  cout << node->data << "->";
  preorderTraversal(node->left);
  preorderTraversal(node->right);
}

// Postorder traversal
void postorderTraversal(node* node) {
  if (node == NULL)
    return;

  postorderTraversal(node->left);
  postorderTraversal(node->right);
  cout << node->data << "->";
}


};

int main()
{
   int t;
    cin>>t;
    tree* T= new tree();
   

    while(t--)
    {
        int x;
       cin>>x;
       T->add(x);
    }
    /*cout<<"\ninorder ";
    T->inorderTraversal(T->root);
    cout<<"\npost\n";
    T->postorderTraversal(T->root);
    cout<<"\npre\n";
    T->preorderTraversal(T->root);
    cout<<"\n";
    int val=60;
    if (T->search(T->root, val) == NULL)
        cout << val << " not found" << endl;
    else
        cout << val << " found" << endl;*/
        printf("Original BST: ");
    T->inorderTraversal(T->root);
   
    printf("\n\nDelete a Leaf Node: 20\n");
    T->deletion(T->root, 20);
    printf("Modified BST tree after deleting Leaf Node:\n");
    T->inorderTraversal(T->root);

    printf("\n\nDelete a Leaf Node: 70\n");
    T->deletion(T->root, 70);
    printf("Modified BST tree after deleting Leaf Node:\n");
    T->inorderTraversal(T->root);
    
    printf("\n\nDelete a Leaf Node: 50\n");
    T->deletion(T->root, 50);
    printf("Modified BST tree after deleting Leaf Node:\n");
    T->inorderTraversal(T->root);
 
 
   

}
