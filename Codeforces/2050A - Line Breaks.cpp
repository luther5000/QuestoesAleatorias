#include <iostream>
#include <string>

using namespace std;

int main() {
    string entrada;
    int n;
    
    cin >> n;
    
    for (int i = 0; i < n; ++i){
        int j, k, l, m;
        
        cin >> l;
        cin >> m;
        j = 0;
        k = 0;

        getline(cin, entrada);
        for (int o = 0; o < l; ++o) {
            getline(cin, entrada);
            
            if (k + entrada.size() <= m){
                ++j;
                k += entrada.size();
            } else 
                k = m + 1;
        }
        cout << j << endl;
    }

    return 0;
}
