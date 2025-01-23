#include <iostream>
#include <vector>
    
using namespace std;
typedef long long ll;

int main(){
    int quant;
    cin >> quant;

    for (int i = 0; i < quant; ++i){
        int n;
        cin >> n;

        int bons = 0;
        ll total = 0;
        int mx = 0;

        for (int j = 0; j < n; ++j){
            ll atual;
            cin >> atual;

            total += atual;
            mx = atual > mx ? atual : mx;

            if (total - mx == mx)
                ++bons;

        }
        cout << bons << endl;
    }
    
    return 0;
}
