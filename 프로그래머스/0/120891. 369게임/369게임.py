def solution(order):
    syg=[3,6,9]
    return len([i for i in list(str(order)) if int(i) in syg ])
