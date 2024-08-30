def solution(array, n):
    answer = 0
    array.append(n)
    array.sort()
    sub=0
    ind=array.index(n)
    if max(array)==n:
        return array[-2]
    elif n-array[ind-1]<=array[ind+1]-n:
        return array[ind-1]
    else:
        return array[ind+1]