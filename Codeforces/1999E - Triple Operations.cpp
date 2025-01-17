#include <iostream>
#include <vector>
#include<cmath>
#define MX 3e5
     
using namespace std;
typedef long long ll;

int main(){
    vector<ll> v(MX);

    for (int i = 1; i < MX; ++i){
        int atual = i;
        int cont = 0;

        while (atual > 0){
            atual = floor(atual / 3);
            ++cont;
        }

        v[i] = cont;
    }

    int quant;
    cin >> quant;

    for (int i = 0; i < quant; ++i){
        int inicio, fim;
        cin >> inicio;
        cin >> fim;

        int num = v[inicio];
        for (int j = inicio; j <= fim; ++j){
            num += v[j];

        }
        
        cout << num << endl;
    }
    
    return 0;
}
