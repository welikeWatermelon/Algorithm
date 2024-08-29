def solution(num, k):
    num_list=list(map(int,str(num)))
    if k in num_list:
        return 1+num_list.index(k)
    else:
        return -1