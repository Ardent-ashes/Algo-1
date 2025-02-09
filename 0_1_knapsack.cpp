#include <bits/stdc++.h>
using namespace std;

void knapsack(int W,vector<int>& wt, vector<int>& val){
    int n=wt.size();
    vector<vector<int>> dp(n+1,vector<int>(W+1,0));
    for(int i=1;i<=n;i++){
        for(int w=0;w<=W;w++){
            if(i==0 || w==0){
                dp[i][w]=0;
            }
            else if(wt[i-1]<=w){
                dp[i][w] = max(val[i-1] + dp[i - 1][w - wt[i - 1]], dp[i - 1][w]);
            }
            else{
                dp[i][w]=dp[i-1][w];
            }
        }
    }
    cout<<dp[n][W];
}

int main(){
    vector<int> profit ={60,100,120};
    vector<int>weight={10,20,30};
    int w=50;
    knapsack(w,weight,profit);
}
