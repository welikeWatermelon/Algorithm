def solution(emergency):
    answer=[1]*len(emergency)
    for i in range(len(emergency)):
        for j in emergency:
            if emergency[i]<j:
                answer[i]+=1
    return answer