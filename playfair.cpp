#include<bits/stdc++.h>
using namespace std;


int main(){
    string key="monarchy";
    vector<vector<string>>matrix(5,vector<string>(5));
    vector<bool>visited(26,false);
    map<char,pair<int,int>>mp;

    int row=0,col=0;
    for(int i=0;i<key.size();i++){
        if(col==5){
            row++;
            col=0;
        }
        mp[key[i]]={row,col++};
        visited[key[i]-'a']=true;
    }

    visited['i'-'a']=true;
    visited['j'-'a']=true;
    mp['i']={2,3};
    mp['j']={2,3};
    for(char c='a';c<='z';c++){
        if(!visited[c-'a']){
            if(col==5){
                row++;
                col=0;
            }
            if(c=='k')col++;
            mp[c]={row,col++};
            visited[c]=true;
        }
    }

    for(auto x:mp){
        //cout<<x.first<<" "<<x.second.first<<" "<<x.second.second<<endl;
        if(x.first=='j')continue;
        else matrix[x.second.first][x.second.second]=x.first;
    }
    

    for(int i=0;i<5;i++){
        for(int j=0;j<5;j++){
            cout<<matrix[i][j]<<" ";
        }
        cout<<endl;
    }

    string plaintext="instruments";
    if(plaintext.size()%2==1)plaintext.push_back('z');

    cout<<plaintext<<endl;

    string ans;

    for(int i=0;i<plaintext.size();i+=2){
        cout<<plaintext[i]<<" "<<plaintext[i+1]<<" ";
        int r1=mp[plaintext[i]].first;
        int c1=mp[plaintext[i]].second;
        int r2=mp[plaintext[i+1]].first;
        int c2=mp[plaintext[i+1]].second;

        if(r1==r2){
            //col next
            int idx_i=(c1+1)%5;
            int idx_i1=(c2+1)%5;
            ans+=matrix[r1][idx_i]+matrix[r1][idx_i1];
            cout<<matrix[r1][idx_i]+matrix[r2][idx_i1]<<endl;
        }
        else if(c1==c2){
            int idx1=(r1+1)%5;
            int idx2=(r2+1)%5;
            ans+=matrix[idx1][c1]+matrix[idx2][c2];
            cout<<matrix[idx1][c1]+matrix[idx2][c2]<<endl;
        }
        else{
                ans+=matrix[r1][c2]+matrix[r2][c1];
                cout<<matrix[r1][c2]+matrix[r2][c1]<<endl;
            
        }
    }
    cout<<ans<<endl;

}