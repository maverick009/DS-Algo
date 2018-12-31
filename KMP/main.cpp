#include <iostream>
#include <cstdlib>
#include <cstring>

using namespace std;

class KMP {
    public :
        void compute_lps(char* pat, int m, int* lps) {
            int len = 0;
            lps[0] = 0;

            int i = 1; 
            while (i < m) { 
                if (pat[i] == pat[len]) { 
                    len++; 
                    lps[i] = len; 
                    i++; 
                } else {
                    if (len != 0) { 
                        len = lps[len - 1];
                    } else { 
                        lps[i] = 0; 
                        i++; 
                    } 
                } 
            }
            for(int i = 0;i < m;i++)
                cout << lps[i] << " ";
            cout << endl;
        }
        
        void kmp(char* pat, char* txt) {
            int M = strlen(pat); 
            int N = strlen(txt); 
            int lps[M]; 

            compute_lps(pat, M, lps); 

            int i = 0;
            int j = 0;
            while (i < N) { 
                if (pat[j] == txt[i]) { 
                    j++; 
                    i++; 
                } 

                if (j == M) { 
                    printf("Found pattern at index %d ", i - j); 
                    j = lps[j - 1]; 
                } else if (i < N && pat[j] != txt[i]) { 
                    if (j != 0) 
                        j = lps[j - 1]; 
                    else
                        i = i + 1; 
                } 
            }
        }
        
};

int main(int argc, char** argv) {
    char txt[] = "ABABDABACDABABCABAB"; 
    char pat[] = "ABABCABAB"; 
    KMP().kmp(pat, txt);
    return 0;
}