#include <cstdlib>
#include <iostream>
#include <climits>
#include <random>
#include <algorithm>
#include <cstring>
#include <utility>

#define NUM 256
using namespace std;

class Solution {
    public:
        char nonrep(string str, int k) {
            pair<int, int> pair[NUM];
            
            for(int i = 0;i < NUM;i++) {
                pair[i].first = 0;
                pair[i].second = NUM;
            }
            
            for(int i = 0;i < str.length();i++) {
                pair[str[i]].first++;
                pair[str[i]].second = i;
            }
            //O(1) operation as Size is fixed
            sort(begin(pair), end(pair),[](const std::pair<int,int> &left, const std::pair<int,int> &right) {
                return left.second < right.second;
            });
            
            return (pair[k-1].second != NUM)?str[pair[k-1].second]:'\0';
        }
};

int main(int argc, char** argv) {
    string str = "leetcode";
    cout << Solution().nonrep(str,3) << endl;    
    return 0;
}