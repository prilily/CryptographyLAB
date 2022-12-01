#include<bits/stdc++.h>
using namespace std;

const int a=17,b=20;

string enc(string s){
    string ans;
    for(int i=0;i<s.size();i++){
        if(s[i]==' ')ans+=" ";
        else{
            ans+=char(  (( a* (s[i]-'A')) +b)  %26+'A');
        }
    }
    return ans;
}

string dec(string enc){
    int a_inv=0,flag=0;
    string ans;
    for(int i=0;i<26;i++){
        flag=(a*i)%26;
        if(flag==1)a_inv=i;
    }

    for(int i=0;i<enc.size();i++){
        if(enc[i]==' ')ans+=enc[i];
        else{
            ans+=char(  (a_inv*((enc[i]+'A' -b)) %26) +'A');
        }
    }
    return ans;
}


int main(){
    string plaintext,cip,pla;
    cout<<"plaintext is  ";
    getline(cin,plaintext);

    cip=enc(plaintext);
    pla=dec(cip);

    cout<<endl<<cip<<endl;
    cout<<pla<<endl;
}