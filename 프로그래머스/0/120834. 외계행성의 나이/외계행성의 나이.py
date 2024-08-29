def solution(age):
    age=str(age)
    dic_={0:'a',1:'b',2:'c',3:'d',4:'e',5:'f',6:'g',7:'h',8:'i',9:'j'}
    word_age=''
    for i in age:
        word_age+=dic_[int(i)]
    return word_age