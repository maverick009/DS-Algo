#include <iostream>
#include <cstdlib>

using namespace std;

struct Node {
    int val;
    Node *left;
    Node *right;
    Node(int x) : val(x), left(nullptr), right(nullptr) {}    
};

class Morris {
public:
    Node *root = nullptr;
    
    void morris(Node* root) {
        if(root == nullptr)
            return;
        
        Node* curr = root;
        Node* prev = nullptr;
        
        while(curr) {
            if(!curr->left) {
                cout << curr->val << " ";
                curr = curr->right;
            } else {
                prev = curr->left;
                while(prev->right != nullptr && prev->right != curr)
                    prev = prev->right;
                
                if(!prev->right) {
                    prev->right = curr;
                    curr = curr->left;
                } else {
                    prev->right = nullptr;
                    cout << curr->val << " ";
                    curr = curr->right;
                }
            }
        }
    }
    
};

int main(int argc, char** argv) {
    Morris m;
    m.root = new Node(1);
    m.root->left = new Node(2);
    m.root->right = new Node(3);
    m.root->left->left = new Node(4);
    m.root->left->right = new Node(5);
    
    m.morris(m.root);
    return 0;
}