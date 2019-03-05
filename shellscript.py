#!/usr/bin/python
import os

for x in range (2,502):
    y = "head -"+str(x)+" uncleaned_data.csv > cleaned_data.csv"
    os.system(y)
    f = open("cleaned_data.csv", "r")
    f.readline()
    arrayList=[]
    BSTList = []
    for line in f:
        z = line[0:19]
        output1 = "java PowerArrayApp \""+str(z)+"\""
        output2 = "java PowerBSTApp \""+str(z)+"\""
        os.system(output1)
        os.system(output2)
        
        fBST = open("BSTPerformance.txt", "r")
        fArray = open("arrayPerformance.txt", "r")
        
        bstAdd = int(fBST.readline())
        arrayAdd = int(fArray.readline())
        
        arrayList.append(arrayAdd)
        BSTList.append(bstAdd)
        
        fBST.close()
        fArray.close()
    f.close()
    n = x-1
    fBestArr = open("ArrayBest.txt","a")
    fAveArr = open("ArrayAve.txt","a")
    fWorstArr = open("ArrayWorst.txt","a")
    
    fBestBST = open("BSTBest.txt","a")
    fAveBST = open("BSTAve.txt","a")
    fWorstBST = open("BSTWorst.txt","a")    
    
    print ((str(n)+" "+str(min(arrayList))),file = fBestArr)
    print ((str(n)+" "+str(min(BSTList))),file = fBestBST)
    
    print ((str(n)+" "+str(max(arrayList))),file = fWorstArr)
    print ((str(n)+" "+str(max(BSTList))),file = fWorstBST)
    
    
    aveArrayCount = sum(arrayList)/len(arrayList)
    aveBSTCount  = sum(BSTList)/len(BSTList)
    
    
    print ((str(n)+" "+str(aveArrayCount)),file = fAveArr)
    print ((str(n)+" "+str(aveBSTCount)),file = fAveBST)
    
    fBestArr.close()
    fWorstArr.close()
    fAveArr.close()
    fBestBST.close()
    fWorstBST.close()
    fAveBST.close()    